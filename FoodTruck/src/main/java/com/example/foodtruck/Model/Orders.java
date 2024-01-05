package com.example.foodtruck.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    private Integer id;
    private LocalDate date;
    private Integer numberOfDay;
    private Double totalPrice;
    private String orderStatus;
    private String note;
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonIgnore
    private User user;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "order")
    @PrimaryKeyJoinColumn
    private Ticket ticket;
}
