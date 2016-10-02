package fil7.ru.examples.java.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Получение даты и времени из строки
 * Способ выделения дня, месяца и т.д. из строки
 */
public class DatePart {

    private Date fromDate = null;
    private SimpleDateFormat formatter = null;

    public DatePart(Date fromDate) {
        this.fromDate = fromDate;
        this.formatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy", Locale.getDefault());
    }

    /**
     *  возвращает день
     */

    public int getDay() {
        formatter.applyPattern("d");
        return Integer.parseInt(formatter.format(fromDate));
    }

    /**
     * @return Месяц
     */
    public int getMonth() {
        formatter.applyPattern("M");
        return Integer.parseInt(formatter.format(fromDate));
    }

    /**
     * @return Год
     */
    public int getYear() {
        formatter.applyPattern("y");
        return Integer.parseInt(formatter.format(fromDate));
    }

    /**
     * @return Час
     */
    public int getHour() {
        formatter.applyPattern("h");
        return Integer.parseInt(formatter.format(fromDate));
    }

    public int getMinute() {
        formatter.applyPattern("m");
        return Integer.parseInt(formatter.format(fromDate));
    }


}
