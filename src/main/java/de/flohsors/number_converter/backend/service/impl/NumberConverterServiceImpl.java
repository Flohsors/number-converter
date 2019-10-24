package de.flohsors.number_converter.backend.service.impl;

import static java.lang.String.valueOf;

import static org.apache.commons.lang3.StringUtils.isBlank;

import static org.slf4j.LoggerFactory.getLogger;

import static de.flohsors.number_converter.backend.entity.NumberType.BINARY;
import static de.flohsors.number_converter.backend.entity.NumberType.DECIMAL;
import static de.flohsors.number_converter.backend.entity.NumberType.ROMAN;
import static de.flohsors.number_converter.backend.entity.NumberType.UNKNOWN;

import java.security.InvalidParameterException;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import de.flohsors.number_converter.backend.service.ConversionHistoryService;
import de.flohsors.number_converter.backend.service.NumberConverterService;
import de.flohsors.number_converter.rest.resource.ConvertibleNumber;

@Service
public class NumberConverterServiceImpl implements NumberConverterService {

    private static final Logger LOGGER = getLogger(NumberConverterService.class);

    private NumberVerifier numberVerifier;
    private BinaryNumberConverter binaryNumberConverter;
    private RomanNumberConverter romanNumberConverter;
    private ConversionHistoryService conversionHistoryService;

    @Autowired
    public NumberConverterServiceImpl(final NumberVerifier numberVerifier,
            final BinaryNumberConverter binaryNumberConverter, final RomanNumberConverter romanNumberConverter,
            final ConversionHistoryService conversionHistoryService) {
        this.numberVerifier = numberVerifier;
        this.binaryNumberConverter = binaryNumberConverter;
        this.romanNumberConverter = romanNumberConverter;
        this.conversionHistoryService = conversionHistoryService;
    }

    @Override
    public ConvertibleNumber convertNumber(final ConvertibleNumber conversionRequest) {
        if (UNKNOWN == conversionRequest.getNumberType()) {
            identifyNumber(conversionRequest);
        }

        return convertToRomanNumber(conversionRequest);
    }

    private void identifyNumber(final ConvertibleNumber convertibleNumber) {
        numberVerifier.setNumberType(convertibleNumber);
    }

    private ConvertibleNumber convertToRomanNumber(final ConvertibleNumber inputNumber) {
        final ConvertibleNumber outputNumber = new ConvertibleNumber(inputNumber.getInputNumber());
        outputNumber.setNumberType(inputNumber.getNumberType());
        if (BINARY == outputNumber.getNumberType()) {
            outputNumber.setInputNumber(valueOf(
                    binaryNumberConverter.convertBinaryToDecimal(outputNumber.getInputNumber())));
            outputNumber.setNumberType(DECIMAL);
        }

        if (DECIMAL == outputNumber.getNumberType()) {
            final String decimalNumber = outputNumber.getInputNumber();
            if (isBlank(decimalNumber)) {
                throw new InvalidParameterException();
            }

            outputNumber.setInputNumber(romanNumberConverter.convertDecimalToRomanNumber(
                    Integer.valueOf(decimalNumber)));
            outputNumber.setNumberType(ROMAN);

            conversionHistoryService.writeConversionLog(inputNumber, outputNumber);
            return outputNumber;
        } else {
            LOGGER.warn("Found a number type that is currently not supported!");
            return null;
        }
    }
}
