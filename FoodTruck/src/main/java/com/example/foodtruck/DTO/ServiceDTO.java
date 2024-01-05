package com.example.foodtruck.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceDTO {
    private  String product;
    private String size;
    private  String basicDevice;
    private String sideDevice;
    private  String Brief;
    private String startDate;
    private Integer food_truck_id;
}
