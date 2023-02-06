package com.pragya.blogapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.rmi.server.UID;

@Data
@Entity
@Table(name="post")
public class Post {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int post_id;

    @Column(name = "post_name")
    private String postName;


   @ManyToOne
   @JsonBackReference
    private User user;

}
