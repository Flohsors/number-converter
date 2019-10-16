package de.flohsors.number_converter.rest.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.flohsors.number_converter.rest.resource.ConversionRequest;
import de.flohsors.number_converter.rest.resource.ConvertedNumber;
import de.flohsors.number_converter.service.NumberConverterService;

@RestController
@RequestMapping(value = "converter")
public class NumberConversionController {

    private NumberConverterService numberConverterService;

    @Autowired
    public NumberConversionController(final NumberConverterService numberConverterService) {
        this.numberConverterService = numberConverterService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ConvertedNumber> convertNumber(@RequestBody final ConversionRequest conversionRequest) {
        return ResponseEntity.ok(numberConverterService.convertNumber(conversionRequest));
    }
}
