package org.example;

public class APIService {
    private final ExternalAPI externalAPI;
    public APIService(ExternalAPI api){
        this.externalAPI = api;
    }

    public String fetchData() {
        return externalAPI.getData();
    }
}