package de.flohsors.number_converter.backend.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import static de.flohsors.number_converter.backend.entity.NumberType.BINARY;
import static de.flohsors.number_converter.backend.entity.NumberType.DECIMAL;
import static de.flohsors.number_converter.backend.entity.NumberType.ROMAN;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import de.flohsors.number_converter.backend.service.NumberConverterService;
import de.flohsors.number_converter.rest.resource.ConvertibleNumber;

public class NumberConverterServiceTest {

    private static final String BINARY_TEST_NUMBER = "110100";
    private static final String DECIMAL_TEST_NUMBER = "52";
    private static final String ROMAN_TEST_NUMBER = "LII";

    @Autowired
    private NumberConverterService numberConverterService;

    @Test
    public void convertToRomanNumber_successfullyConvertsBinaryNumbersToRomanNumbers() {
        final ConvertibleNumber request = new ConvertibleNumber(BINARY_TEST_NUMBER);
        request.setNumberType(BINARY);

        final ConvertibleNumber result = numberConverterService.convertNumber(request);

        assertThat(result.getNumberType()).isEqualTo(ROMAN);
        assertThat(result.getInputNumber()).isEqualTo(ROMAN_TEST_NUMBER);
    }

    @Test
    public void convertToRomanNumber_successfullyConvertsDecimalNumbersToRomanNumbers() {
        final ConvertibleNumber request = new ConvertibleNumber(DECIMAL_TEST_NUMBER);
        request.setNumberType(DECIMAL);

        final ConvertibleNumber result = numberConverterService.convertNumber(request);

        assertThat(result.getNumberType()).isEqualTo(ROMAN);
        assertThat(result.getInputNumber()).isEqualTo(ROMAN_TEST_NUMBER);
    }
}
