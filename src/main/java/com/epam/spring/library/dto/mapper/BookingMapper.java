package com.epam.spring.library.dto.mapper;

import com.epam.spring.library.dto.BookingDTO;
import com.epam.spring.library.model.Booking;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BookingMapper {

    BookingDTO toDTO(Booking booking);

    List<BookingDTO> toDTO(List<Booking> bookings);

    Booking toBooking(BookingDTO bookingDto);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateBooking(BookingDTO bookingDTO, @MappingTarget Booking booking);
}
