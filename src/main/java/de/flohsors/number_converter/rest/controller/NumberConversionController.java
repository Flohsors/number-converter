package de.flohsors.number_converter.rest.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import static org.springframework.util.StringUtils.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.flohsors.number_converter.backend.service.NumberConverterService;
import de.flohsors.number_converter.rest.resource.ConvertibleNumber;

@RestController
@RequestMapping(value = "converter")
public class NumberConversionController {

    private NumberConverterService numberConverterService;

    @Autowired
    public NumberConversionController(final NumberConverterService numberConverterService) {
        this.numberConverterService = numberConverterService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ConvertibleNumber> convertNumber(@RequestBody final String number) {
        if (isEmpty(number)) {
            return ResponseEntity.badRequest().build();
        }

        final ConvertibleNumber convertibleNumber = new ConvertibleNumber(number);
        return ResponseEntity.ok(numberConverterService.identifyAndConvertNumber(convertibleNumber));
    }
}
