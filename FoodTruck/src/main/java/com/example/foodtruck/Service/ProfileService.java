package com.example.foodtruck.Service;

import com.example.foodtruck.ApiException.ApiException;
import com.example.foodtruck.DTO.ProfileDTO;
import com.example.foodtruck.Model.Profile;
import com.example.foodtruck.Model.User;
import com.example.foodtruck.Repository.ProfileRepository;
import com.example.foodtruck.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    public List<Profile> getProfile(){
        return profileRepository.findAll();
    }
    public void addProfile(ProfileDTO profileDTO){
        User user=userRepository.findUserById(profileDTO.getUser_id());
        if (user == null) {
            throw new ApiException("the id user not found");
        }
        Profile profile=new Profile(null,profileDTO.getName(),profileDTO.getAddress(),profileDTO.getDescription(),profileDTO.getAccountCreationDate(),user);
        profileRepository.save(profile);
    }
    public void updateProfile(Integer auth,ProfileDTO profileDTO){
//        User user=userRepository.findUserById(auth);
        Profile profile=profileRepository.findProfileById(auth);
        if (profile == null) {
            throw new ApiException("the id profile not found");
        }
        profile.setName(profileDTO.getName());
        profile.setAddress(profileDTO.getAddress());
        profile.setDescription(profileDTO.getDescription());
        profile.setAccountCreationDate(profileDTO.getAccountCreationDate());
        profileRepository.save(profile);
//        if (profileDTO.getUser_id()==auth) {
//
//            Profile profile = new Profile(null, profileDTO.getName(), profileDTO.getAddress(), profileDTO.getDescription(), profileDTO.getAccountCreationDate(), user);
//            profileRepository.save(profile);
//        }else throw new ApiException("the user id not same");

    }
    public void deleteProfile(Integer auth){
        Profile profile=profileRepository.findProfileById(auth);
        if (profile == null) {
            throw new ApiException("the id user not found");
        }
        profileRepository.delete(profile);
    }
}
