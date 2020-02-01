package xyz.ariesfish.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (s == null) {
            throw new RuntimeException("No Argument.");
        }
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        try {
            // convert string to date
            return format.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("Data convert failed.");
        }
    }
}
