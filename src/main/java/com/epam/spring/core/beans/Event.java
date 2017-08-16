package com.epam.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.util.Date;

public class Event {
    @Autowired
    private int id;
    private String msg;
    private Date date;
    private DateFormat formatter;

    public Event(Date date, DateFormat formatter) {
        this.date = date;
        this.formatter = formatter;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + formatter.format(date) +
                '}';
    }
}
