package de.flohsors.number_converter.backend.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class NumberVerifierTest {

    private NumberVerifier numberVerifier = new NumberVerifier();

    private static final String BINARY_NUMBER = "101001";
    private static final String DECIMAL_NUMBER = "12875612";

    @Test
    public void isBinary_successfullyIdentifiesBinaryNumbers() {
        assertThat(numberVerifier.isBinary(BINARY_NUMBER)).isTrue();
        assertThat(numberVerifier.isDecimal(BINARY_NUMBER)).isTrue();
    }

    @Test
    public void isDecimal_successfullyIdentifiesDecimalNumbers() {
        assertThat(numberVerifier.isBinary(DECIMAL_NUMBER)).isFalse();
        assertThat(numberVerifier.isDecimal(DECIMAL_NUMBER)).isTrue();
    }

}
