package com.lcwd.hotel.HotelService.Services;

import com.lcwd.hotel.HotelService.Exception.ResourceNotFoundException;
import com.lcwd.hotel.HotelService.Model.Hotel;
import com.lcwd.hotel.HotelService.Repositories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelService {
    @Autowired
    HotelRepo hotelRepo;


    public Hotel saveHotel(Hotel hotel){
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setId(randomHotelId);
        return hotelRepo.save(hotel);
    }

    public Hotel getHotelbyId(String hotelId){
        return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found"));
    }

    public List<Hotel> getAllHotels(){
        return hotelRepo.findAll();
    }
}
