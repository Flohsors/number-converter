package de.flohsors.number_converter.rest.resource;

import static de.flohsors.number_converter.backend.entity.NumberType.UNKNOWN;

import java.util.Objects;

import com.google.common.base.MoreObjects;

import de.flohsors.number_converter.backend.entity.NumberType;

public class ConvertibleNumber {

    private String inputNumber;
    private NumberType numberType;

    public ConvertibleNumber() { }

    public ConvertibleNumber(final String inputNumber) {
        this.inputNumber = inputNumber;
        numberType = UNKNOWN;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(final String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public NumberType getNumberType() {
        return numberType;
    }

    public void setNumberType(final NumberType numberType) {
        this.numberType = numberType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ConvertibleNumber)) {
            return false;
        }

        ConvertibleNumber that = (ConvertibleNumber) o;
        return Objects.equals(inputNumber, that.inputNumber) && numberType == that.numberType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputNumber, numberType);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("inputNumber", inputNumber).add("numberType", numberType)
                          .toString();
    }
}
