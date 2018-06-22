package ua.training.logger.impl;

import ua.training.entity.Event;
import ua.training.logger.EventLogger;

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
