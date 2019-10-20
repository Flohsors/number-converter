package de.flohsors.number_converter.backend.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RomanNumberConverterTest {

    private RomanNumberConverter romanNumberConverter = new RomanNumberConverter();

    @Test
    public void convertDecimalToRomanNumber_converts5_toV() {
        assertThat(romanNumberConverter.convertDecimalToRomanNumber(5)).isEqualTo("V");
    }

    @Test
    public void convertDecimalToRomanNumber_converts1919_toMCMXIX() {
        assertThat(romanNumberConverter.convertDecimalToRomanNumber(1919)).isEqualTo("MCMXIX");
    }
}
