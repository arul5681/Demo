package com.restaurant.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @Column(name = "fullname")
    private String name;
    @Column(name = "username")
    private String userid;
    @Column(name = "password")
    private String password;
    @Column(name = "signedin")
    private boolean signedin = false;

}