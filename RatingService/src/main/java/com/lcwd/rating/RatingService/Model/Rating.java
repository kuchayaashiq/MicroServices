package com.lcwd.rating.RatingService.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Rating {
    @Id
    private String ratingdId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
