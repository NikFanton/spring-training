package com.company.logger.impl;

import com.company.Event;
import com.company.logger.EventLogger;

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
