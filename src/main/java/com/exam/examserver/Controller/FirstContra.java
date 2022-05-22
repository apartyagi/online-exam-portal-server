package com.exam.examserver.Controller;

import com.exam.examserver.Models.exam.Role;
import com.exam.examserver.Models.exam.User;
import com.exam.examserver.Models.exam.User_Role;
import com.exam.examserver.Service.ServiceImp.User_Service_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class FirstContra {

    @Autowired
    private User_Service_Impl userService;

    @PostMapping("/add")
    public ResponseEntity<?> Create_Use(@RequestBody User user){
        var role = new Role();
        role.setId(1);
        role.setRole_name("Normal");
        Set<User_Role> userRoles =new HashSet<>();
        User_Role user_role = new User_Role();
        user_role.setRole(role);
        user_role.setUser(user);
        userRoles.add(user_role);
        return  ResponseEntity.ok(userService.Create_User(user,userRoles));
    }

    @PutMapping("/upd")
    public User Update_use(@RequestBody User user){

        return user;
    }


    @GetMapping("/show/{username}")
    public User Get_Use(@PathVariable("username") String username){
        return  userService.GetUser(username);
    }

    @DeleteMapping("del/{userId}")
    public String Del_Use(@PathVariable("userId") int userId) {
        return userService.Delete_User(userId);
    }
}
