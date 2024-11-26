package com.Hotel.Boking.service.interfc;

import com.Hotel.Boking.dto.Response;
import com.Hotel.Boking.entity.Booking;

public interface IBookingService {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);

}

