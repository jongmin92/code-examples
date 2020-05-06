package com.jongmin.springcore;

public class ClientServiceFactory {

    private static final ClientService clientService = new ClientService();

    public ClientService createClientServiceInstance() {
        return clientService;
    }
}
