package com.lcwd.user.service.UserService.Repositories;

import com.lcwd.user.service.UserService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
