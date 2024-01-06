package com.example.foodtruck.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

@Table(name ="b")
public class FoodTruck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "License should not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String License;
//    private String startDate;
@NotNull(message = "number of day should not be empty")
@Column(columnDefinition = "int not null")
    private Integer NumberOfEmployee;
    @NotEmpty(message = "city should not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    @Pattern(regexp = "^[a-zA-Z ]+$")
    private String city;
//    private String cond;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "foodTruck")
    @PrimaryKeyJoinColumn
    private Services services;

    @ManyToOne
    @JoinColumn(name = "evaluation_id",referencedColumnName = "id")
    @JsonIgnore
    private Evaluation evaluation;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "foodTruck")
    private Set<Ticket> ticket;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    @JsonIgnore
    private Category category;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "foodTruck")
    @PrimaryKeyJoinColumn
    private Set<Orders> orders;

}
