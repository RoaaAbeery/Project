package com.example.foodtruck.Controller;

import com.example.foodtruck.DTO.ServiceDTO;
import com.example.foodtruck.Service.ServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/service")
public class ServiceController {
    private final ServiceService serviceService;
    @GetMapping("/get")
    public ResponseEntity GetAllService(){
        return ResponseEntity.status(HttpStatus.OK).body(serviceService.getFood());
    }
    @PostMapping("/add")
    public  ResponseEntity AddService(@RequestBody @Valid ServiceDTO serviceDTO){
        serviceService.AddService(serviceDTO);
        return ResponseEntity.status(HttpStatus.OK).body("added Service");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity UpdateService(@PathVariable Integer id,@RequestBody @Valid ServiceDTO serviceDTO){
        serviceService.updateService(id, serviceDTO);
        return ResponseEntity.status(HttpStatus.OK).body("update Service");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteService(@PathVariable Integer id){
        serviceService.deleteService(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete Service");
    }
}
