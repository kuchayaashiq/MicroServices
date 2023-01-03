package com.lcwd.user.service.UserService.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name ="hotel")
public class Hotel {
    @javax.persistence.Id
    private String Id;
    private String name;
    private String location;
    private String about;
}
