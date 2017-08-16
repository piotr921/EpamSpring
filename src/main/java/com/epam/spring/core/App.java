package com.epam.spring.core;

class App {

    private Client client;
    private ConsoleEventLogger logger;

    public static void main(String[] args) {
        App app = new App();

        app.client = new Client("1", "John Smith");
        app.logger = new ConsoleEventLogger();

        app.logEvent("Some event for user 1");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        logger.logEvent(message);
    }
}
