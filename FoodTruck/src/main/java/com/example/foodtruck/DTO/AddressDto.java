package com.example.foodtruck.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDto {
    private  String address;
    private String startDate;
    private Integer NumberWeek;
    private String city;
    private String street;
    private Integer user_id;
}
