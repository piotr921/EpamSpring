package com.epam.spring.core;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.beans.Event;
import com.epam.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class App {

    private Client client;
    private EventLogger logger;

    App(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = context.getBean("app", App.class);

        app.logEvent(context, "Some event for user 1");
        context.close();
    }

    private void logEvent(ApplicationContext context, String msg) {
        Event event = context.getBean("event", Event.class);
        event.setMessage(msg.replaceAll(client.getId(), client.getFullName()));
        logger.logEvent(event);
    }
}
