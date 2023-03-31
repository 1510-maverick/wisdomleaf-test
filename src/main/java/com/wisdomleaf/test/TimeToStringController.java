package com.wisdomleaf.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class TimeToStringController {

    @Autowired
    private TimeToStringConverter converter;

    @GetMapping("convert-time")
    public String convertTime() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        return converter.convertTime(hour, minute);
    }
}
