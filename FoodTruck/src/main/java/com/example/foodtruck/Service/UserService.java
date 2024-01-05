package com.example.foodtruck.Service;

import com.example.foodtruck.ApiException.ApiException;
import com.example.foodtruck.DTO.UserDTO;
import com.example.foodtruck.Model.User;
import com.example.foodtruck.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private  final UserRepository userRepository;
    public List<User> getAll(){
        return userRepository.findAll();
    }
    public void addClient(UserDTO user){
//        User add= userRepository.findUserById(user.getId());
//        if (add == null) {
//            throw new ApiException("the id nt found");
//        }
        User u=new User(null, user.getUserName(), user.getPassword(), user.getEmail(), null,null,null,null);
        userRepository.save(u);
    }
    public void updateClint(Integer auth , User user) {
        User oldadd = userRepository.findUserById(auth);
        if (oldadd == null) {
            throw new ApiException("the id nt found");
        }
        user.setId(oldadd.getId());
        userRepository.save(user);
    }
    public void deletClient(Integer auth){
        User user = userRepository.findUserById(auth);
        if (user == null) {
            throw new ApiException("the id nt found");
        }
        userRepository.delete(user);
    }
}
