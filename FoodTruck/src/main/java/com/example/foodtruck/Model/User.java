package com.example.foodtruck.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String UserName;
    private String Password;
    private  String email;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Orders> orders;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Profile profile;
    @OneToOne
    @JsonIgnore
    private Ticket ticket;
}
