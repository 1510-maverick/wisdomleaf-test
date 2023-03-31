package com.wisdomleaf.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class TimeToStringConverter {

    private static final String PREFIX = "It's ";

    public String convertTime(int hour, int minute) {
        StringBuilder time = new StringBuilder();

        try (InputStream hourMappingStream = TimeToStringConverter.class.getResourceAsStream("/hour-word-mapping.json");
             InputStream minuteMappingStream = TimeToStringConverter.class.getResourceAsStream("/minute-word-mapping.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map hourMappings = objectMapper.readValue(hourMappingStream, Map.class);
            Map minuteMappings = objectMapper.readValue(minuteMappingStream, Map.class);
            Object obj = null;

            for (Object h : hourMappings.keySet()) {
                if (String.valueOf(hour).equals(h)) {
                    obj = hourMappings.get(h);
                    time.append(obj);
                }
            }

            if (obj != null && !obj.equals("Midday") && !obj.equals("Midnight")) {
                time.append(" ");

                for (Object m : minuteMappings.keySet()) {
                    if (String.valueOf(minute).equals(m)) {
                        time.append(minuteMappings.get(m));
                    }
                }
            }


            return PREFIX + time;

        } catch (IOException e) {
            throw new ResourceNotFoundException("The mapping file(s) could not be found.");
        }
    }
}
