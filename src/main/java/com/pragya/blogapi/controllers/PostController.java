package com.pragya.blogapi.controllers;

import com.pragya.blogapi.entities.Post;
import com.pragya.blogapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/{id}")
    public Post createPost(@PathVariable("id") int id, @RequestParam String name){
        Post post=postService.createPost(name,id);
        return post;
    }


}
