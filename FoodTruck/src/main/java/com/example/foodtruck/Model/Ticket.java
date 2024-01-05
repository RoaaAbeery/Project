package com.example.foodtruck.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    private Integer id;
    private String status;

    @ManyToOne
    @JoinColumn(name = "foodTruck_id",referencedColumnName = "id")
    @JsonIgnore
    private FoodTruck foodTruck;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Orders order;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "ticket")
    @PrimaryKeyJoinColumn
    private User user;
}
