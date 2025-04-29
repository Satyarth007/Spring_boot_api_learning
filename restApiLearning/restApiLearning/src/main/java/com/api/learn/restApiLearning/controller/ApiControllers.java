package com.api.learn.restApiLearning.controller;

import com.api.learn.restApiLearning.models.Users;
import com.api.learn.restApiLearning.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/demo")
    public String getMessage(){
        return "Satyarth!!";
    }


    @GetMapping(value = "/allUsers")
    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/saveuser")
    public String saveuser(@RequestBody Users users){
        userRepo.save(users);
        return "User details added.....";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUserDetails(@PathVariable long id, @RequestBody Users users){

        Users userToUpdate = userRepo.findById(id).get();
        userToUpdate.setFirstName(users.getFirstName());
        userToUpdate.setLastName(users.getLastName());
        userToUpdate.setOccupation(users.getOccupation());
        userToUpdate.setAge(users.getAge());
        userRepo.save(userToUpdate);

        return "User details is updated for id : "+id;
    }


    @DeleteMapping(value="/delete/{id}")
    public String deleteUsers(@PathVariable long id){

        Users user = userRepo.findById(id).get();
        userRepo.delete(user);
        return "User "+user.toString() +" is deleted.......";
    }

}
