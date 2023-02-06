package com.pragya.blogapi.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;
    private String email;
    private String password;
    private String about;

   @OneToMany(mappedBy = "user",cascade = CascadeType.DETACH)
   @JsonManagedReference
    private Set<Post> post;

}
