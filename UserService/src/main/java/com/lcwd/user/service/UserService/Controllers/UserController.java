package com.lcwd.user.service.UserService.Controllers;
import com.lcwd.user.service.UserService.Model.User;
import com.lcwd.user.service.UserService.Services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.flogger.Flogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
   Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser =  userService.saveUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    int retryCount = 1;
    @GetMapping("/{userId}")
   // @CircuitBreaker(name ="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        logger.info("get single user handler: UserController");
        logger.info("Retry count - {}", retryCount);
        retryCount++;
        User findUser = userService.getUser(userId);
        return new ResponseEntity<>(findUser,HttpStatus.OK);
    }

    // creating fallback Method

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){

        //logger.info("fallback is executed because service is down",ex.getMessage());
        User user = User.builder().email("dummy@gmail.come").name("Dummy")
                .about("this is created dummy because some services are down")
                .userId("3i003ii04i959").build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<User>> AllUsers(){

        List<User> alluserslist = userService.getAllUser();
        return new ResponseEntity<>(alluserslist,HttpStatus.OK);
    }

}
