package com.testCoding.intiCorpora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testCoding.intiCorpora.Entity.UserProfile;
import com.testCoding.intiCorpora.model.request.CreateUserRequest;
import com.testCoding.intiCorpora.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserProfile createUser(CreateUserRequest userRequest){
        UserProfile user = new UserProfile();
        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        return userRepository.save(user);
    }
    public List<UserProfile> getAllUser(){
        return userRepository.findAll();
    }
    public String deleteUser(String id){
        userRepository.deleteById(id);
        return "User Sudah Di Apus";
    }
    

}
