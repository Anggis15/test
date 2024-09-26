package com.testCoding.intiCorpora.controller;

import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testCoding.intiCorpora.Entity.UserProfile;
import com.testCoding.intiCorpora.constant.CodeMessage;
import com.testCoding.intiCorpora.model.WebResponse;
import com.testCoding.intiCorpora.model.request.CreateUserRequest;
import com.testCoding.intiCorpora.service.UserService;

@Controller
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/v1/create",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<UserProfile> createUser(@RequestBody CreateUserRequest userRequest){
        UserProfile user = userService.createUser(userRequest);
        return WebResponse.<UserProfile>builder().code(CodeMessage.Success_Response.toString()).data(user).build();
    }
    @GetMapping(path="/v1/delete/{id}",
                produces=MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> deleteUser(@PathVariable(name = "id") String id){
        String delete = userService.deleteUser(id);
        return WebResponse.<String>builder().code(CodeMessage.Success_Response.toString()).data(delete).build();
    }
    @GetMapping(path="/v1/getAll",
                produces=MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<List<UserProfile>> getAllUser(){
        List<UserProfile> allUser = userService.getAllUser();
        return WebResponse.<List<UserProfile>>builder().code(CodeMessage.Success_Response.toString()).data(allUser).build();
    }

}
