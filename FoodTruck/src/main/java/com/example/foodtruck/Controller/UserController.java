package com.example.foodtruck.Controller;

import com.example.foodtruck.DTO.UserDTO;
import com.example.foodtruck.Model.User;
import com.example.foodtruck.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Api/v1/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity GetAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity AddUser(@RequestBody @Valid UserDTO user){
        userService.addClient(user);
        return ResponseEntity.status(HttpStatus.OK).body("added Client");
    }
    @PutMapping("/put")
    public ResponseEntity UpdateUser(@PathVariable Integer id,@RequestBody @Valid User user){
        userService.updateClint(id, user);
        return ResponseEntity.status(HttpStatus.OK).body("update Client");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deletClient(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete Client");
    }
}
