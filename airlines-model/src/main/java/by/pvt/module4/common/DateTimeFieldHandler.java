package by.pvt.module4.common;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.exolab.castor.mapping.ValidityException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class DateTimeFieldHandler extends GeneralizedFieldHandler {
    private static String dateFormatPattern;

    @Override
    public void setConfiguration(Properties config) throws ValidityException {
        dateFormatPattern = config.getProperty("date-format");
    }

    @Override
    public Object convertUponGet(Object value) {
        Date date = (Date) value;
        return format(date);
    }

    @Override
    public Object convertUponSet(Object value) {
        String dateString = (String) value;
        return parse(dateString);
    }

    @Override
    public Class<Date> getFieldType() {
        return Date.class;
    }

    protected static String format(final Date date) {
        String dateString = "";
        if (date != null) {
            DateFormat DF = new SimpleDateFormat(dateFormatPattern);
            dateString = DF.format(date);
        }
        return dateString;
    }

    protected static Date parse(final String dateString) {
        Date date = null;
        if (dateString != null && !dateString.isEmpty()) {
            DateFormat DF = new SimpleDateFormat(dateFormatPattern);
            try {
                date = DF.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }
}
