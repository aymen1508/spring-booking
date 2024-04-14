package com.hotel.backend.hotels;


import java.time.Instant;

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

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels(){
        return new ResponseEntity<List<Hotel>>(hotelService.getHotels(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long id){
        return new ResponseEntity<Hotel>(hotelService.getHotel(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        // Set createdAt and updatedAt to current timestamp
        java.sql.Timestamp timestamp=new java.sql.Timestamp(Instant.now().toEpochMilli());
        hotel.setCreatedAt(timestamp);
        hotel.setUpdatedAt(timestamp);
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable Long id){
        return new ResponseEntity<Hotel>(hotelService.deleteHotel(id), HttpStatus.OK);
    }
    

    @PutMapping
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel){
        java.sql.Timestamp timestamp=new java.sql.Timestamp(Instant.now().toEpochMilli());
        hotel.setUpdatedAt(timestamp);
        return new ResponseEntity<Hotel>(hotelService.createHotel(hotel), HttpStatus.OK);
    }


}
