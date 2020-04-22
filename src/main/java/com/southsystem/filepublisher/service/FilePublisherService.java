package com.southsystem.filepublisher.service;

import com.southsystem.filepublisher.config.ProcessorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class FilePublisherService {

    @Autowired
    ProcessorConfig processorConfig;

    @Autowired
    MessageService messageService;

    public Void readDirectory() {
        String inPath = System.getProperty("user.home") + processorConfig.getInDirPath();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(inPath), entry -> !Files.isDirectory(entry) && entry.getFileName().toString().endsWith(".dat"))) {
            stream.forEach(path -> {
                try {
                    List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));
                    messageService.sendFileToQueue(lines, path.getFileName().toFile().getName());
                    path.toFile().delete();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Arquivo: " + path + " com problema");
                }
            });
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(() -> {
            readDirectory();
        }, 10, TimeUnit.SECONDS);

        return null;
    }
}
