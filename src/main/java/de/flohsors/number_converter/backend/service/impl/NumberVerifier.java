package de.flohsors.number_converter.backend.service.impl;

import static de.flohsors.number_converter.backend.entity.NumberType.BINARY;
import static de.flohsors.number_converter.backend.entity.NumberType.DECIMAL;
import static de.flohsors.number_converter.backend.entity.NumberType.UNKNOWN;

import org.springframework.stereotype.Component;

import de.flohsors.number_converter.rest.resource.ConvertibleNumber;

@Component
public class NumberVerifier {

    private String binaryRegex = "[01]+";
    private String decimalRegex = "[0-9]+";

    boolean isBinary(final String number) {
        return number.matches(binaryRegex);
    }

    boolean isDecimal(final String number) {
        return number.matches(decimalRegex);
    }

    public void setNumberType(final ConvertibleNumber convertibleNumber) {
        if (isBinary(convertibleNumber.getInputNumber())) {
            convertibleNumber.setNumberType(BINARY);
        } else if (isDecimal(convertibleNumber.getInputNumber())) {
            convertibleNumber.setNumberType(DECIMAL);
        } else {
            convertibleNumber.setNumberType(UNKNOWN);
        }
    }
}
