package com.southsystem.filepublisher.model;

import java.io.Serializable;
import java.util.List;

public class File implements Serializable {

    List<Client> clients;
    List<Seller> sellers;
    List<Sale> sales;

    public File(List<Client> clients, List<Seller> sellers, List<Sale> sales) {
        this.clients = clients;
        this.sellers = sellers;
        this.sales = sales;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
