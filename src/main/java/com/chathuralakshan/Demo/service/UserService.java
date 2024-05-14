package com.chathuralakshan.Demo.service;

import com.chathuralakshan.Demo.dto.UserDTO;
import com.chathuralakshan.Demo.entity.User;
import com.chathuralakshan.Demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getUsers(){
        List<User> usersList=userRepo.findAll();
        return modelMapper.map(usersList,new TypeToken<List<UserDTO>>(){}.getType());
    }


    public UserDTO saveUser(UserDTO userDTO){

        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    public Boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }

    public UserDTO getUserByUserID(String userID){
        User user=userRepo.getUserByUserID(userID);
        return modelMapper.map(user,UserDTO.class) ;
    }


    public UserDTO getUserByIDAndAddress(String userID,String address){
        User user=userRepo.getUserByIDAndAddress(userID,address);
        return modelMapper.map(user,UserDTO.class);
    }
}
