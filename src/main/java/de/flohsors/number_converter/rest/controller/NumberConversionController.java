package de.flohsors.number_converter.rest.controller;

import static java.util.Objects.isNull;

import static org.springframework.util.StringUtils.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.flohsors.number_converter.backend.service.NumberConverterService;
import de.flohsors.number_converter.rest.resource.ConvertibleNumber;

@RestController
public class NumberConversionController {

    private NumberConverterService numberConverterService;

    @Autowired
    public NumberConversionController(final NumberConverterService numberConverterService) {
        this.numberConverterService = numberConverterService;
    }

    @PostMapping(
        value = "/converter/convertNumber", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ConvertibleNumber> convertNumber(@RequestBody final ConvertibleNumber number) {
        if (isNull(number) || isEmpty(number.getInputNumber())) {
            return ResponseEntity.badRequest().build();
        }

        final ConvertibleNumber result = numberConverterService.convertNumber(number);
        if (result == null) {
            return ResponseEntity.badRequest().body(number);
        }

        return ResponseEntity.ok(result);
    }
}
