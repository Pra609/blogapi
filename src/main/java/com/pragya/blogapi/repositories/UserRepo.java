package com.pragya.blogapi.repositories;

import com.pragya.blogapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
