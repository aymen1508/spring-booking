package com.hotel.backend.bookings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

    public Booking getBooking(Long id){
        return bookingRepository.findById(id).get();
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id).get();
        bookingRepository.deleteById(id);
        return booking; 
    }
    
}
