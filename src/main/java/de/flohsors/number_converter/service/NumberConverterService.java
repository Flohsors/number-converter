package de.flohsors.number_converter.service;

import de.flohsors.number_converter.rest.resource.ConversionRequest;
import de.flohsors.number_converter.rest.resource.ConvertedNumber;

public interface NumberConverterService {

    ConvertedNumber convertNumber(ConversionRequest conversionRequest);
}
