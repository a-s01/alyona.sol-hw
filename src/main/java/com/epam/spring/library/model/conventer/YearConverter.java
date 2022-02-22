package com.epam.spring.library.model.conventer;

import com.epam.spring.library.exception.InvalidStateException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;
import java.util.Objects;

@Converter
public class YearConverter implements AttributeConverter<Year, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Year year) {
        if (Objects.isNull(year)) {
            throw new InvalidStateException("Year cannot be null");
        }
        return year.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Integer integer) {
        return Year.of(integer);
    }
}
