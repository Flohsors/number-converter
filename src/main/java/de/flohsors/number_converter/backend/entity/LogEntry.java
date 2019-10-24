package de.flohsors.number_converter.backend.entity;

import java.time.LocalDateTime;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public class LogEntry {

    private LocalDateTime timestamp;
    private String conversion;
    private String inputNumber;
    private String outputNumber;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(final String conversion) {
        this.conversion = conversion;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(final String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public String getOutputNumber() {
        return outputNumber;
    }

    public void setOutputNumber(final String outputNumber) {
        this.outputNumber = outputNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof LogEntry)) {
            return false;
        }

        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(timestamp, logEntry.timestamp) && Objects.equals(conversion, logEntry.conversion)
                && Objects.equals(inputNumber, logEntry.inputNumber)
                && Objects.equals(outputNumber, logEntry.outputNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, conversion, inputNumber, outputNumber);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("timestamp", timestamp).add("conversion", conversion)
                          .add("inputNumber", inputNumber).add("outputNumber", outputNumber).toString();
    }
}
