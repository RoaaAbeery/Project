package com.example.foodtruck.Repository;

import com.example.foodtruck.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    Orders findOrderById(Integer id);

}
