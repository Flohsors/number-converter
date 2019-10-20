package de.flohsors.number_converter.backend.service.impl;

import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Component;

@Component
public class RomanNumberConverter {

    private static final int ROMAN_NUMERAL_M = 1000;
    private static final int ROMAN_NUMERAL_CM = 900;
    private static final int ROMAN_NUMERAL_DCCC = 800;
    private static final int ROMAN_NUMERAL_DCC = 700;
    private static final int ROMAN_NUMERAL_DC = 600;
    private static final int ROMAN_NUMERAL_D = 500;
    private static final int ROMAN_NUMERAL_CD = 400;
    private static final int ROMAN_NUMERAL_CCC = 300;
    private static final int ROMAN_NUMERAL_CC = 200;
    private static final int ROMAN_NUMERAL_C = 100;
    private static final int ROMAN_NUMERAL_XC = 90;
    private static final int ROMAN_NUMERAL_LCCC = 80;
    private static final int ROMAN_NUMERAL_LCC = 70;
    private static final int ROMAN_NUMERAL_LC = 60;
    private static final int ROMAN_NUMERAL_L = 50;
    private static final int ROMAN_NUMERAL_CL = 40;
    private static final int ROMAN_NUMERAL_XXX = 30;
    private static final int ROMAN_NUMERAL_XX = 20;
    private static final int ROMAN_NUMERAL_X = 10;
    private static final int ROMAN_NUMERAL_IX = 9;
    private static final int ROMAN_NUMERAL_VIII = 8;
    private static final int ROMAN_NUMERAL_VII = 7;
    private static final int ROMAN_NUMERAL_VI = 6;
    private static final int ROMAN_NUMERAL_V = 5;
    private static final int ROMAN_NUMERAL_IV = 4;
    private static final int ROMAN_NUMERAL_III = 3;
    private static final int ROMAN_NUMERAL_II = 2;
    private static final int ROMAN_NUMERAL_I = 1;

    public String convertDecimalToRomanNumber(final int decimalNumber) {
        if (decimalNumber >= ROMAN_NUMERAL_M) {
            final int amountOfThousands = decimalNumber / ROMAN_NUMERAL_M;
            return appendM(amountOfThousands) + convertDecimalToRomanNumber(decimalNumber % ROMAN_NUMERAL_M);
        } else if (decimalNumber >= ROMAN_NUMERAL_CM) {
            return "CM" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_CM);
        } else if (decimalNumber >= ROMAN_NUMERAL_DCCC) {
            return "DCCC" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_DCCC);
        } else if (decimalNumber >= ROMAN_NUMERAL_DCC) {
            return "DCC" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_DCC);
        } else if (decimalNumber >= ROMAN_NUMERAL_DC) {
            return "DC" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_DC);
        } else if (decimalNumber >= ROMAN_NUMERAL_D) {
            return "D" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_D);
        } else if (decimalNumber >= ROMAN_NUMERAL_CD) {
            return "CD" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_CD);
        } else if (decimalNumber >= ROMAN_NUMERAL_CCC) {
            return "CCC" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_CCC);
        } else if (decimalNumber >= ROMAN_NUMERAL_CC) {
            return "CC" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_CC);
        } else if (decimalNumber >= ROMAN_NUMERAL_C) {
            return "C" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_C);
        } else if (decimalNumber >= ROMAN_NUMERAL_XC) {
            return "XC" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_XC);
        } else if (decimalNumber >= ROMAN_NUMERAL_LCCC) {
            return "LCCC" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_LCCC);
        } else if (decimalNumber >= ROMAN_NUMERAL_LCC) {
            return "LCC" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_LCC);
        } else if (decimalNumber >= ROMAN_NUMERAL_LC) {
            return "LC" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_LC);
        } else if (decimalNumber >= ROMAN_NUMERAL_L) {
            return "L" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_L);
        } else if (decimalNumber >= ROMAN_NUMERAL_CL) {
            return "CL" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_CL);
        } else if (decimalNumber >= ROMAN_NUMERAL_XXX) {
            return "XXX" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_XXX);
        } else if (decimalNumber >= ROMAN_NUMERAL_XX) {
            return "XX" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_XX);
        } else if (decimalNumber >= ROMAN_NUMERAL_X) {
            return "X" + convertDecimalToRomanNumber(decimalNumber - ROMAN_NUMERAL_X);
        } else if (decimalNumber == ROMAN_NUMERAL_IX) {
            return "IX";
        } else if (decimalNumber == ROMAN_NUMERAL_VIII) {
            return "VIII";
        } else if (decimalNumber == ROMAN_NUMERAL_VII) {
            return "VII";
        } else if (decimalNumber == ROMAN_NUMERAL_VI) {
            return "VI";
        } else if (decimalNumber == ROMAN_NUMERAL_V) {
            return "V";
        } else if (decimalNumber == ROMAN_NUMERAL_IV) {
            return "IV";
        } else if (decimalNumber == ROMAN_NUMERAL_III) {
            return "III";
        } else if (decimalNumber == ROMAN_NUMERAL_II) {
            return "II";
        } else if (decimalNumber == ROMAN_NUMERAL_I) {
            return "I";
        } else {
            return "";
        }
    }

    private String appendM(final int countOfM) {
        return StringUtils.repeat('M', countOfM);
    }
}
