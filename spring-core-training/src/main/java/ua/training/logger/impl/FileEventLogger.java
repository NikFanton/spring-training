package ua.training.logger.impl;

import ua.training.entity.Event;
import ua.training.logger.EventLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() {
        this.file = new File(fileName);
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, String.valueOf(event) + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
