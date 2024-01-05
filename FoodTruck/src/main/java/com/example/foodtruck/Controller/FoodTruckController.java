package com.example.foodtruck.Controller;

import com.example.foodtruck.Model.FoodTruck;
import com.example.foodtruck.Service.FoodTruckService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/food")
public class FoodTruckController {
    private final FoodTruckService foodTruckService;

    @GetMapping("/get")
    public ResponseEntity GetAllFoodTruck(){
        return ResponseEntity.status(HttpStatus.OK).body(foodTruckService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity AddFoodTruck(@RequestBody @Valid FoodTruck foodTruck){
        foodTruckService.addFood(foodTruck);
        return ResponseEntity.status(HttpStatus.OK).body("added FoodTruck");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity UpdateFoodTruck(@PathVariable Integer id,@RequestBody @Valid FoodTruck foodTruck){
        foodTruckService.updateFoodTruck(id, foodTruck);
        return ResponseEntity.status(HttpStatus.OK).body("update FoodTruck");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFoodTruck(@PathVariable Integer id){
        foodTruckService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete FoodTruck");
    }
}
