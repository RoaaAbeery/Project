package com.example.foodtruck.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation {
    @Id
    Integer id;
    @ManyToOne
    @JoinColumn(name = "foodTruck_id",referencedColumnName = "id")
    @JsonIgnore
    private FoodTruck foodTruck;
}
