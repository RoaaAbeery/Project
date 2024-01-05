package com.example.foodtruck.Repository;

import com.example.foodtruck.Model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ServiceRepository extends JpaRepository<Services,Integer> {
    Services findServiceById(Integer id);

}
