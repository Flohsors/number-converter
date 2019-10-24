package de.flohsors.number_converter.backend.service.impl;

import static java.lang.String.format;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import de.flohsors.number_converter.backend.entity.LogEntry;
import de.flohsors.number_converter.backend.service.ConversionHistoryService;
import de.flohsors.number_converter.rest.resource.ConvertibleNumber;

@Service
public class ConversionHistoryServiceImpl implements ConversionHistoryService {

    private static final String PATTERN = "From %s to %s.";

    @Override
    public void writeConversionLog(final ConvertibleNumber input, final ConvertibleNumber output) {
        final LogEntry logEntry = new LogEntry();
        logEntry.setTimestamp(LocalDateTime.now());
        logEntry.setConversion(format(PATTERN, input.getNumberType().toString(), output.getNumberType().toString()));
        logEntry.setInputNumber(input.getInputNumber());
        logEntry.setOutputNumber(output.getInputNumber());
        writeEntry(logEntry);
    }

    private void writeEntry(final LogEntry entry) {
        // write to file
    }
}
