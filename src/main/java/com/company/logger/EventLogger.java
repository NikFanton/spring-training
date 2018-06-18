package com.company.logger;

import com.company.entity.Event;

import java.io.IOException;

public interface EventLogger {
    void logEvent(Event event);
}
