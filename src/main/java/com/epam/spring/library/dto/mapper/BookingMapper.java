package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.model.Booking;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BookingMapper {

    BookingDTO toDTO(Booking booking);

    List<BookingDTO> toDTO(List<Booking> bookings);

    Booking toBooking(BookingDTO bookingDto);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    void updateBooking(BookingDTO bookingDTO, @MappingTarget Booking booking);
}
