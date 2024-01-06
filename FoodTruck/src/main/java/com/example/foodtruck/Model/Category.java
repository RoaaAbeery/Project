package com.example.foodtruck.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    @Pattern(regexp = "^[a-zA-Z ]+$")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private Set<FoodTruck> foodTrucks;
}
