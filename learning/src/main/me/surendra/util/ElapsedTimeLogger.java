package me.surendra.util;

import me.surendra.event.LoggerUtils;


public class ElapsedTimeLogger implements AutoCloseable {

    private final long startTime;

    private final String message;

    ElapsedTimeLogger(final String message) {
        this.message = message;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void close() {
        final long endTime = System.currentTimeMillis();
        final String logMessage = LoggerUtils.format(
            "Message [{0}], startTime [{1}], endTime [{2}], elapsedTime [{3}]",
            message, startTime, endTime, (endTime - startTime));
        System.out.println(logMessage);
    }

}
