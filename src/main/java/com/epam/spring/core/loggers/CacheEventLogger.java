package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheEventLogger(String fileDir, int cacheSize) {
        super(fileDir);
        this.cacheSize = cacheSize;
        cache = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }

    private void writeEventsFromCache() {
        cache.forEach(super::logEvent);
    }
}
