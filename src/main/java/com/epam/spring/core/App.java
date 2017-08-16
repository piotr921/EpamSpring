package com.epam.spring.core;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class App {

    private Client client;
    private EventLogger logger;

    App(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = context.getBean("app", App.class);

        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        logger.logEvent(message);
    }
}
