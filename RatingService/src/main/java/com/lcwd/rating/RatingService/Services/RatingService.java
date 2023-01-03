package com.lcwd.rating.RatingService.Services;

import com.lcwd.rating.RatingService.Model.Rating;
import com.lcwd.rating.RatingService.Repositories.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingService {
    @Autowired
    RatingRepo ratingRepo;
    public Rating createRating( Rating rating){
        String randomRatingId = UUID.randomUUID().toString();
        rating.setRatingdId(randomRatingId);
        return ratingRepo.save(rating);
    }

    public List<Rating> getAllRatings(){
        return ratingRepo.findAll();
    }

    public List<Rating> getRatingByHotelId(String hotelId){
        return ratingRepo.findByHotelId(hotelId);
    }
    public List<Rating> getRatingUserId(String userId){
        return ratingRepo.findByUserId(userId);
    }

}
