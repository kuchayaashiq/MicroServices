package com.lcwd.user.service.UserService.OuterServices;

import com.lcwd.user.service.UserService.Model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
    @PostMapping("/ratings")
    public Rating createRating(@RequestBody Rating rating);

    // its APi is pending yet
    @PutMapping("/rating/{ratingId}")
    Rating updateRating(@PathVariable String ratingId, Rating rating);

    // its APi is pending yet
    @DeleteMapping("/{ratingId}")
    Rating deleteRating(@PathVariable String ratingId);
}
