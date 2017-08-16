package com.epam.spring.core;

class Client {

    private String id;
    private String fullName;

    Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
