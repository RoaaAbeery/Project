package com.example.foodtruck.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TicketDTO {
    private  String address;
    private String startDate;
    private Integer NumberWeek;
    private String city;
    private String street;
    private String status;
    private Integer user_id;
    private Integer order_id;

}
