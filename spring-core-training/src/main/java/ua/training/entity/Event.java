package ua.training.entity;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Event {
    private static final LocalTime startOfEvening = LocalTime.of(17, 0);

    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;
    private EventType eventType;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public Date getDate() {
        return date;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public static boolean isDay() {
        return LocalTime.now().compareTo(startOfEvening) < 0;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
