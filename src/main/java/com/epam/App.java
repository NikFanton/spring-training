package com.epam;

import com.epam.logger.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public App() {
    }

    private void logEvent(Event event) {
        String newMessage = event.getMsg().replaceAll(client.getId(), client.getFullName());
        event.setMsg(newMessage);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        Event event = (Event) context.getBean("event");
        event.setMsg("Some event from user " + app.client.getId());
        app.logEvent(event);
    }
}
