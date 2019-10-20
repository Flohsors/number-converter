package de.flohsors.number_converter.backend.service;

import de.flohsors.number_converter.rest.resource.ConvertibleNumber;

public interface NumberConverterService {

    ConvertibleNumber identifyAndConvertNumber(ConvertibleNumber convertibleNumber);

    ConvertibleNumber convertNumber(ConvertibleNumber convertibleNumber);
}
