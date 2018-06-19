package com.company.logger.impl;

import com.company.entity.Event;
import com.company.logger.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ConsoleEventLogger implements EventLogger {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void logEvent(Event event) {
        System.out.println(event);
//        saveEvent(event);
        System.out.println("----------------");
        getEvents().forEach(System.out::println);
        System.out.println("----------------");
    }

    private List<Event> getEvents() {
        return jdbcTemplate.query("select * from test_db.event", (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String msg = resultSet.getString("event");
            Event event = new Event(new Date(), new SimpleDateFormat());
            event.setMsg(msg);
            return event;
        });
    }

    private void saveEvent(Event event) {
        jdbcTemplate.update("INSERT INTO event (event) VALUES (?)", event.getMsg());
    }
}
