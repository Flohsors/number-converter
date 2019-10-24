package de.flohsors.number_converter.backend.service;

import de.flohsors.number_converter.rest.resource.ConvertibleNumber;

public interface ConversionHistoryService {

    void writeConversionLog(ConvertibleNumber input, ConvertibleNumber output);
}
