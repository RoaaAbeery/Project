package com.example.foodtruck.Repository;

import com.example.foodtruck.Model.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FoodTruckRepository extends JpaRepository<FoodTruck,Integer> {
    FoodTruck findFoodTruckById(Integer id);
}
