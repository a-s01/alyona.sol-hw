package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.model.Booking;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class, UserMapper.class})
public interface BookingMapper {

    BookingDTO toDTO(Booking booking);

    List<BookingDTO> toDTO(List<Booking> bookings);

    Booking toBooking(BookingDTO bookingDto);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "books",
             defaultExpression = "java(new java.util.ArrayList())")
    void updateBooking(BookingDTO bookingDTO, @MappingTarget Booking booking);
}
