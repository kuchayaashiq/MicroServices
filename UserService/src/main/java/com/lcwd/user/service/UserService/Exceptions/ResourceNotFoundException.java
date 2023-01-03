package com.lcwd.user.service.UserService.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource not Found on server");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
