package com.lcwd.hotel.HotelService.Repositories;

import com.lcwd.hotel.HotelService.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, String > {
}
