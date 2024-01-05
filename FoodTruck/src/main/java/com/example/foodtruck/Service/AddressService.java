package com.example.foodtruck.Service;

import com.example.foodtruck.ApiException.ApiException;
import com.example.foodtruck.DTO.AddressDto;
import com.example.foodtruck.Model.Address;
import com.example.foodtruck.Model.User;
import com.example.foodtruck.Repository.AddressRepository;
import com.example.foodtruck.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    public List<Address> getAll(){
        return addressRepository.findAll();
    }
    public void addAddress(AddressDto addressDTO){
        User user=userRepository.findUserById(addressDTO.getUser_id());
        if (user == null) {
            throw new ApiException("the id user not found");
        }
        Address address =new Address(null,addressDTO.getAddress(),addressDTO.getStartDate(),addressDTO.getNumberWeek(),addressDTO.getCity(),addressDTO.getStreet(),user);
        addressRepository.save(address);
    }
    public void updateAddress(Integer auth , AddressDto addressDTO) {
//        User user=userRepository.findUserById(auth);
        Address address=addressRepository.findAddressById(auth);
        if (address == null) {
            throw new ApiException("the id address not found");
        }
        address.setAddress(address.getAddress());
        address.setStartDate(addressDTO.getStartDate());
        address.setNumberWeek(addressDTO.getNumberWeek());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        addressRepository.save(address);
//        if (addressDTO.getUser_id()==auth) {
//
//            Address address = new Address(null, addressDTO.getAddress(), addressDTO.getStartDate(), addressDTO.getNumberWeek(), addressDTO.getCity(), addressDTO.getStreet(), user);
//            addressRepository.save(address);
//        }else throw new ApiException("the user id not same");
    }
    public void deleteAddress(Integer auth){
        Address address = addressRepository.findAddressById(auth);
        if (address == null) {
            throw new ApiException("the id nt found");
        }
        addressRepository.delete(address);
    }
}
