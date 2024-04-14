package com.hotel.backend.hotels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public List<Hotel> getHotels(){
        return hotelRepository.findAll();
    }

    public Hotel getHotel(Long id){
        return hotelRepository.findById(id).get();
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id).get();
        hotelRepository.deleteById(id);
        return hotel; 
    }
    
}
