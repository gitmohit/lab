package lab.mohit.concurrency;

import java.text.ParseException;
import java.util.Date;

public class DateFormatTester {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                String dateStr = "2024-05-18";
                Date date = DateFormatter.parse(dateStr);
                String formattedDate = DateFormatter.format(date);
                System.out.println(Thread.currentThread().getName() + " - Parsed Date: " + date + " - Formatted Date: " + formattedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        };

        // Create multiple threads to test the DateFormatter
        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
