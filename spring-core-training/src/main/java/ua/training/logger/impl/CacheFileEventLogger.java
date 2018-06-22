package ua.training.logger.impl;

import ua.training.entity.Event;

import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize = 10;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, List<Event> cache, int cacheSize) {
        super(fileName);
        this.cache = cache;
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        cache.forEach(super::logEvent);
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
