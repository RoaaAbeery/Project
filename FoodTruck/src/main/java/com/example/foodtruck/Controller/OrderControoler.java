package com.example.foodtruck.Controller;

import com.example.foodtruck.DTO.OrderDTO;
import com.example.foodtruck.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/order")
public class OrderControoler {
    private final OrderService orderService;
    @GetMapping("/get")
    public ResponseEntity GetAllOrder(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAll());
    }
    @PostMapping("/add")
    public  ResponseEntity AddOrder(@RequestBody @Valid OrderDTO orderDTO){
        orderService.addOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.OK).body("added Order");
    }
    @PutMapping("/put")
    public ResponseEntity UpdateOrder(@PathVariable Integer id,@RequestBody @Valid OrderDTO orderDTO){
        orderService.updateOrder(id, orderDTO);
        return ResponseEntity.status(HttpStatus.OK).body("update Order");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete Order");
    }
}
