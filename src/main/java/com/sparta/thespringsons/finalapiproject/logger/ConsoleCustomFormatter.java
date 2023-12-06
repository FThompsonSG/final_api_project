package com.sparta.thespringsons.finalapiproject.logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ConsoleCustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)
                + " " + LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME)
                + "\n" + record.getLevel() + " " + record.getMessage()
                + "\n" + record.getSourceClassName()
                + "\n\n";
    }
}
