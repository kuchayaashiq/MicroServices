package com.lcwd.hotel.HotelService.Controllers;

import com.lcwd.hotel.HotelService.Model.Hotel;
import com.lcwd.hotel.HotelService.Repositories.HotelRepo;
import com.lcwd.hotel.HotelService.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHostel(@RequestBody Hotel hotel){
        Hotel addedHotel =  hotelService.saveHotel(hotel);
        return new ResponseEntity<>(addedHotel, HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        Hotel hotel = hotelService.getHotelbyId(hotelId);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> AllHotels = hotelService.getAllHotels();
        return new ResponseEntity<>(AllHotels, HttpStatus.OK);
    }


}
