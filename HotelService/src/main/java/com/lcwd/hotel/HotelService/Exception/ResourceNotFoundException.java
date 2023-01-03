package com.lcwd.hotel.HotelService.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String str){
        super(str);
    }
    public ResourceNotFoundException(){
        super("Resource not found ");
    }
}

