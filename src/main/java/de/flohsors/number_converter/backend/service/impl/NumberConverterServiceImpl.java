package de.flohsors.number_converter.backend.service.impl;

import static de.flohsors.number_converter.backend.entity.NumberType.ROMAN;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import de.flohsors.number_converter.backend.service.NumberConverterService;
import de.flohsors.number_converter.rest.resource.ConvertibleNumber;

@Service
public class NumberConverterServiceImpl implements NumberConverterService {

    private NumberVerifier numberVerifier;

    @Autowired
    public NumberConverterServiceImpl(final NumberVerifier numberVerifier) {
        this.numberVerifier = numberVerifier;
    }

    @Override
    public ConvertibleNumber identifyAndConvertNumber(final ConvertibleNumber conversionRequest) {
        numberVerifier.setNumberType(conversionRequest);
        return convertNumber(conversionRequest);
    }

    @Override
    public ConvertibleNumber convertNumber(final ConvertibleNumber conversionRequest) {
        return convertToRomanNumber(conversionRequest);
    }

    private ConvertibleNumber convertToRomanNumber(final ConvertibleNumber convertibleNumber) {

        // convert number to roman number
        convertibleNumber.setNumberType(ROMAN);
        return convertibleNumber;
    }
}
