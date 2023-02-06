package com.pragya.blogapi.services.impl;

import com.pragya.blogapi.entities.Post;
import com.pragya.blogapi.repositories.PostRepo;
import com.pragya.blogapi.repositories.UserRepo;
import com.pragya.blogapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;
    @Override
    public Post createPost(String name, int id) {

        Post post=new Post();
        post.setPostName(name);
        post.setUser(userRepo.findById(id).get());
        postRepo.save(post);

        return post;

    }
}
