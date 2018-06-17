package com.epam.logger.impl;

import com.epam.Event;
import com.epam.logger.EventLogger;

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
