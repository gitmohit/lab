package lab.mohit.concurrency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateFormatter {
    private static ThreadLocal<SimpleDateFormat> dateFormatterHolder = new ThreadLocal<>() {
        @Override
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("dd-MM-yyyy");
        }
    };

    public static String format(Date date) {
        return dateFormatterHolder.get().format(date);
    }

    public static Date parse(String dateTimeString) throws ParseException {
        return dateFormatterHolder.get().parse(dateTimeString);
    }
}
