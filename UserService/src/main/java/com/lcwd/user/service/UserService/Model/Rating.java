package com.lcwd.user.service.UserService.Model;

import lombok.Data;


@Data

public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String ratings;
    private String feedback;
    public Hotel hotel;
}
