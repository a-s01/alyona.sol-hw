package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.model.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BookMapper.class, UserMapper.class})
public interface BookingMapper {
    BookingDTO toDTO(Booking booking);

    Booking toBooking(BookingDTO bookingDto);
/*
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "books", defaultExpression = "java(new java.util.ArrayList())")
    void updateBooking(BookingDTO bookingDTO, Booking booking);

 */
}
