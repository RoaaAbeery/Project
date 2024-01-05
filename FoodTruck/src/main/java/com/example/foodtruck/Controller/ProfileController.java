package com.example.foodtruck.Controller;

import com.example.foodtruck.DTO.ProfileDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/profile")
public class ProfileController {
    private final com.example.foodtruck.Service.ProfileService profileService;
    @GetMapping("/get")
    public ResponseEntity GetAllProfile(){
        return ResponseEntity.status(HttpStatus.OK).body(profileService.getProfile());
    }
    @PostMapping("/add")
    public  ResponseEntity AddProfile(@RequestBody @Valid ProfileDTO profileDTO){
        profileService.addProfile(profileDTO);
        return ResponseEntity.status(HttpStatus.OK).body("added Profile");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity UpdateProfile(@PathVariable Integer id,@RequestBody @Valid ProfileDTO profileDTO){
        profileService.updateProfile(id, profileDTO);
        return ResponseEntity.status(HttpStatus.OK).body("update Profile");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProfile(@PathVariable Integer id){
        profileService.deleteProfile(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete Profile");
    }
}
