package com.example.foodtruck.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class OrderDTO {
    private LocalDate date;
    private Integer numberOfDay;
    private Double totalPrice;
    private String orderStatus;
    private String note;
    private Double discount;
    private Integer user_id;
    private Integer foodTruck_id;
}
