package com.hotel.backend.bookings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.backend.clients.ClientService;
import com.hotel.backend.hotels.HotelService;


@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> getBookings(){
        return new ResponseEntity<List<Booking>>(bookingService.getBookings(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id){
        return new ResponseEntity<Booking>(bookingService.getBooking(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        ClientService clientService=new ClientService();
        booking.setClient(clientService.getClient(booking.getClient().getId()));
        HotelService hotelService=new HotelService();
        booking.setHotel(hotelService.getHotel(booking.getHotel().getId()));
        return new ResponseEntity<>(bookingService.createBooking(booking), HttpStatus.CREATED);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable Long id){
        return new ResponseEntity<Booking>(bookingService.deleteBooking(id), HttpStatus.OK);
    }
    

    @PutMapping
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking){
        return new ResponseEntity<Booking>(bookingService.createBooking(booking), HttpStatus.OK);
    }


}
