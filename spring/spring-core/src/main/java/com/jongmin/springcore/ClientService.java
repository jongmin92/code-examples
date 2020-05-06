package com.jongmin.springcore;

public class ClientService {

    private static final ClientService clientService = new ClientService();

    public static ClientService createInstance() {
        return clientService;
    }
}
