package de.flohsors.number_converter.backend.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BinaryNumberConverterTest {

    private BinaryNumberConverter binaryNumberConverter = new BinaryNumberConverter();

    @Test
    public void simpleConversion_Binary10is2Decimal() {
        assertThat(binaryNumberConverter.convertBinaryToDecimal("10")).isEqualTo(2);
    }

    @Test
    public void simpleConversion_Binary101100is52Decimal() {
        assertThat(binaryNumberConverter.convertBinaryToDecimal("110100")).isEqualTo(52);
    }
}
