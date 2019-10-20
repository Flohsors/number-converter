package de.flohsors.number_converter.backend.service.impl;

public class BinaryNumberConverter {

    public int convertBinaryToDecimal(final String binaryNumber) {
        final int power = binaryNumber.length() - 1;
        if (binaryNumber.length() == 1) {
            return "1".equals(binaryNumber) ? (int) Math.pow(2, power) : 0;
        } else {

            final String firstChar = binaryNumber.substring(0, 1);
            if ("1".equals(firstChar)) {
                return (int) Math.pow(2, power) + convertBinaryToDecimal(binaryNumber.substring(1));
            } else {
                return convertBinaryToDecimal(binaryNumber.substring(1));
            }
        }
    }
}
