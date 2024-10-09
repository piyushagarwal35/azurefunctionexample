package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//public class CustomDateConverter extends AbstractBeanField<Date, String> {
//    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm'Z'"; // Adjust the format as needed
//
//    @Override
//    protected  Object convert(String value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
//        try {
//            return new SimpleDateFormat(DATE_FORMAT).parse(value);
//        } catch (ParseException e) {
//            throw new CsvDataTypeMismatchException("Failed to parse date: " + value, e);
//        }
//    }
//}
public class CustomDateConverter extends AbstractBeanField<Date, String> {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm'Z'"; // Adjust the format as needed

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException {
        try {
            return new SimpleDateFormat(DATE_FORMAT).parse(value);
        } catch (ParseException e) {
            throw new CsvDataTypeMismatchException("Failed to parse date: " + e);
        }
    }
}
