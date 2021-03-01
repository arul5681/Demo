package com.restaurant.demo.dto;

import lombok.Builder;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="users")
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
   /** @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private Set<Menus> menus;**/

    @Column(name = "fullname")
    private String name;
    @Column(name = "username")
    private String userid;
    @Column(name = "password")
    private String password;
    @Column(name = "signedin")
    private boolean signedin = false;


    public User() {
    }

    public User(long id, String name, String userid, String password, boolean signedin) {
        super();
        this.id = id;
        this.name = name;
        this.userid = userid;
        this.password = password;
        this.signedin = signedin;
        //this.menus = menus;
    }

}