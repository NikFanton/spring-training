package com.company;

import com.company.entity.Client;
import com.company.entity.Event;
import com.company.entity.EventType;
import com.company.logger.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public App() {
    }

    private void logEvent(EventType type, Event event) {
        String newMessage = event.getMsg().replaceAll(client.getId(), client.getFullName());
        event.setMsg(newMessage);
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = eventLogger;
        }
        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        Event event = (Event) context.getBean("event");
        event.setMsg("Some event from user " + app.client.getId());
        app.logEvent(EventType.ERROR, event);
        context.close();
    }
}
