package com.epam.spring.core;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.loggers.ConsoleEventLogger;
import com.epam.spring.core.loggers.EventLogger;

class App {

    private Client client;
    private EventLogger logger;

    App(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public static void main(String[] args) {
        App app = new App(new Client("1", "John Smith"), new ConsoleEventLogger());

        app.client = new Client("1", "John Smith");
        app.logEvent("Some event for user 1");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        logger.logEvent(message);
    }
}
