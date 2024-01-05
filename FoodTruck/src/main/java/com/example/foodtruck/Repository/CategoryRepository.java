package com.example.foodtruck.Repository;

import com.example.foodtruck.Model.Address;
import com.example.foodtruck.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepository extends  JpaRepository<Category,Integer>{

}
