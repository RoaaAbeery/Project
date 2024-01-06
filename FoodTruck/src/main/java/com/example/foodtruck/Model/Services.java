package com.example.foodtruck.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Services {
    @Id
    private Integer id;
    private  String product;
    private String size_trucks;
    private  String basicDevice;
    private String sideDevice;
    private  String Brief;
    private String startDate;
    @OneToOne
    @MapsId
    @JsonIgnore
    private FoodTruck foodTruck;
}
