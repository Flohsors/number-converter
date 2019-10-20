package de.flohsors.number_converter.backend.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BinaryNumberConverterTest {

    private BinaryNumberConverter binaryNumberConverter = new BinaryNumberConverter();

    @Test
    public void simpleConversion_10is2() {
        assertThat(binaryNumberConverter.convertBinaryToDecimal("10")).isEqualTo(2);
    }

    @Test
    public void simpleConversion_101100is52() {
        assertThat(binaryNumberConverter.convertBinaryToDecimal("110100")).isEqualTo(52);
    }
}
