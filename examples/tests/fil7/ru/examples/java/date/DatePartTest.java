package fil7.ru.examples.java.date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DatePartTest {

    private static Date currentDate;
    private static Calendar calendar;
    private static int year;
    private static int month;
    private static int day;
    private static int hour;
    private static int minute;
    private static DatePart datePart;

    @BeforeClass
    public static void init() {
        currentDate = new Date();
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);

        datePart = new DatePart(currentDate);
    }

    @Test
    public void getDay() throws Exception {
        Assert.assertEquals(day, datePart.getDay());
    }

    @Test
    public void getMonth() throws Exception {
        Assert.assertEquals(month, datePart.getMonth());
    }

    @Test
    public void getYear() throws Exception {
        Assert.assertEquals(year, datePart.getYear());
    }

    @Test
    public void getHour() throws Exception {
        Assert.assertEquals(hour, datePart.getHour());
    }

    @Test
    public void getMinute() throws Exception {
        Assert.assertEquals(minute, datePart.getMinute());
    }
}

