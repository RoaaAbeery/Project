package com.example.foodtruck.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class UserDTO {

    private  String UserName;
    private String Password;
    private  String email;

//    private Integer t_id;
}
