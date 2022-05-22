package com.exam.examserver.Controller;

import com.exam.examserver.Models.exam.Result;
import com.exam.examserver.Models.exam.User;
import com.exam.examserver.Repo.ResultRepo;
import com.exam.examserver.Service.Result_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@RestController
@CrossOrigin("*")
@RequestMapping("/ans")
public class ResultContra {

    @Autowired
    Result_Service result_service;


    @GetMapping("/get-quiz/{id}")
    public ResponseEntity<?> getAllQuizByThisUser(@PathVariable("id") int id){
        User user= new User();
        user.setId(id);
        List<Result> all_result_of_particular_user = result_service.get_all_result_of_particular_user(user);
        return ResponseEntity.ok(all_result_of_particular_user);
    }


}


