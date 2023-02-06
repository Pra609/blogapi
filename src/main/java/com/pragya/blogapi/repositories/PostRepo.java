package com.pragya.blogapi.repositories;

import com.pragya.blogapi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Integer> {
}
