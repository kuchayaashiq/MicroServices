package com.lcwd.user.service.UserService.Services;

import com.lcwd.user.service.UserService.Exceptions.ResourceNotFoundException;
import com.lcwd.user.service.UserService.Model.Hotel;
import com.lcwd.user.service.UserService.Model.Rating;
import com.lcwd.user.service.UserService.Model.User;
import com.lcwd.user.service.UserService.OuterServices.HotelService;
import com.lcwd.user.service.UserService.Repositories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public User saveUser(User user){
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    public List<User> getAllUser(){

       return userRepo.findAll();//.stream().map(user -> restTemplate.getForObject("http://localhost:8093/ratings/user/"+user.getUserId(),Ratings.class));
        //return null;
    }

    public User getUser(String userId){

//        User user =userRepo.findById(userId).orElseThrow(() ->
//                new ResourceNotFoundException("User whit given id is not found" + userId));
//       ArrayList<Ratings> ratingsOfUser = restTemplate.getForObject("http://localhost:8090/ratings/user/"+user.getUserId(), ArrayList.class);
//        logger.info("{} ", ratingsOfUser);
//        user.setRating(ratingsOfUser);

         User u =userRepo.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User with given id not found" + userId));
         Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+u.getUserId(), Rating[].class);
         List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
         List<Rating> ratingsList = ratings.stream().map(rating -> {
             //localhost:8092/hotels/37db9256-247e-459f-8e53-8c406d0a8f11
             // ---> this is because if we use RestTemplate
            // ResponseEntity<Hotel> forEntity =  restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
             //Hotel hotel = forEntity.getBody();
             // ---> this is because if we use Fiegn Client
             Hotel hotel = hotelService.getHotel(rating.getHotelId());
             rating.setHotel(hotel);
            return rating;
         }).collect(Collectors.toList());
         u.setRating(ratingsList);
         return u;
    }
}
