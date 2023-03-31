package com.wisdomleaf.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeToStringConverterTest {

    @Test
    void convertTime_whenItsEightThirtyFour_thenReturnsTimeInString() {
        TimeToStringConverter converter = new TimeToStringConverter();
        String time = converter.convertTime(8, 34);

        assertEquals("It's eight thirty four", time);
    }

    @Test
    void convertTime_whenItsMidDay_thenReturnsTimeInString() {
        TimeToStringConverter converter = new TimeToStringConverter();
        String time = converter.convertTime(12, 0);

        assertEquals("It's Midday", time);
    }

    @Test
    void convertTime_whenItsMidNight_thenReturnsTimeInString() {
        TimeToStringConverter converter = new TimeToStringConverter();
        String time = converter.convertTime(0, 0);

        assertEquals("It's Midnight", time);
    }
}