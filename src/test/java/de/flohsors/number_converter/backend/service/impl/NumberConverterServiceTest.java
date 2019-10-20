package de.flohsors.number_converter.backend.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.eq;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static de.flohsors.number_converter.backend.entity.NumberType.BINARY;
import static de.flohsors.number_converter.backend.entity.NumberType.DECIMAL;
import static de.flohsors.number_converter.backend.entity.NumberType.ROMAN;

import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import de.flohsors.number_converter.backend.service.NumberConverterService;
import de.flohsors.number_converter.rest.resource.ConvertibleNumber;

public class NumberConverterServiceTest {

    private static final String BINARY_TEST_NUMBER = "110100";
    private static final String DECIMAL_TEST_NUMBER = "52";
    private static final String ROMAN_TEST_NUMBER = "LII";
    private static final int DECIMAL_TEST_INT = 52;

    @Autowired
    private NumberConverterService numberConverterService;

    @Before
    public void setup() {
        final BinaryNumberConverter binConverter = mock(BinaryNumberConverter.class);
        when(binConverter.convertBinaryToDecimal(eq(BINARY_TEST_NUMBER))).thenReturn(DECIMAL_TEST_INT);

        final RomanNumberConverter romConverter = mock(RomanNumberConverter.class);
        when(romConverter.convertDecimalToRomanNumber(eq(DECIMAL_TEST_INT))).thenReturn(ROMAN_TEST_NUMBER);

        numberConverterService = new NumberConverterServiceImpl(mock(NumberVerifier.class), binConverter, romConverter);
    }

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
