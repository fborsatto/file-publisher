FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} file-publisher.jar
ENTRYPOINT ["java","-jar","/file-publisher.jar"]