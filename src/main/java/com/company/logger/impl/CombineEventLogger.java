package com.company.logger.impl;

import com.company.entity.Event;
import com.company.logger.EventLogger;

import java.util.List;

public class CombineEventLogger implements EventLogger {

    private List<EventLogger> loggers;

    public CombineEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
