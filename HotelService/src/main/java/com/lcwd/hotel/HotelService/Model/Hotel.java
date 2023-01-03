package com.lcwd.hotel.HotelService.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name ="hotels")
public class Hotel {
    @Id
    private String Id;
    private String name;
    private String location;
    private String about;
}
