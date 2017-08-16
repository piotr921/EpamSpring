package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileDir;
    private File file;

    FileEventLogger(String fileDir) {
        this.fileDir = fileDir;
        file = new File(fileDir);
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", "UTF-8",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        if (!file.exists()) {
            boolean isCreateSucceed = file.createNewFile();
            if (!isCreateSucceed) {
                throw new IOException("cannot create file: " + fileDir);
            }
        }
        if (!file.canWrite()) {
            throw new IOException("Cannot write to file: " + fileDir);
        }
    }
}
