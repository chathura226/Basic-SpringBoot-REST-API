package com.chathuralakshan.Demo.controller;

import com.chathuralakshan.Demo.dto.UserDTO;
import com.chathuralakshan.Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/getusers")
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(path = "/saveuser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping(path = "/updateuser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping(path = "/deleteuser")
    public Boolean deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }

    @GetMapping(path = "/getUserByUserID/{userID}")
    public UserDTO getUserByUserID(@PathVariable String userID){
        return userService.getUserByUserID(userID);
    }

    @GetMapping(path = "/getUserByIDAndAddress/{userID}/{address}")
    public UserDTO getUserByUserID(@PathVariable String userID,@PathVariable String address){
        return userService.getUserByIDAndAddress(userID,address);
    }
}
