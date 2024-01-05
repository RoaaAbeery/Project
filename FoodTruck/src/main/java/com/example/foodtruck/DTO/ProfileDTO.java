package com.example.foodtruck.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class ProfileDTO {
    private String name;
    private String address;
    private String description;
    private LocalDateTime accountCreationDate =LocalDateTime.now();

    private Integer user_id;
}
