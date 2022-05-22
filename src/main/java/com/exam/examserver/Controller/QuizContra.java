package com.exam.examserver.Controller;

import com.exam.examserver.Models.exam.Category;
import com.exam.examserver.Models.exam.Quizz;
import com.exam.examserver.Service.Quizz_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/qui")
@RestController
@CrossOrigin("*")
public class QuizContra {
    @Autowired
    Quizz_Service quizz_service;

    @PostMapping("/add")
    public ResponseEntity<?> add_quiz(@RequestBody Quizz quizz){
        Quizz quizz1 = quizz_service.addQuiz(quizz);
        return ResponseEntity.ok(quizz1);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get_quiz(@PathVariable("id") int id){
        Quizz quiz = quizz_service.getQuiz(id);
        return ResponseEntity.ok(quiz);
    }

    @GetMapping("/all")
    public ResponseEntity<?> get_all_quiz(){
        List<Quizz> all_quiz = quizz_service.get_all_Quiz();
        return ResponseEntity.ok(all_quiz);
    }


    @PutMapping("/upd")
    public ResponseEntity<?> upd_quiz(@RequestBody Quizz quizz){
        Quizz quizz1 = quizz_service.update_quiz(quizz);
        return ResponseEntity.ok(quizz1);
    }


    @DeleteMapping("del/{id}")
    public String del_quiz(@PathVariable("id") int id){
        try{
            quizz_service.delete_quiz(id);
            return "success";
        }catch (Exception exception){

        return "error";
        }
    }

    @GetMapping("/cat/{id}")
    public  ResponseEntity<?> getAllQuizByCategoryId(@PathVariable("id") int id){
        Category category=new Category();
        category.setId(id);
        List<Quizz> quizzes = quizz_service.get_quiz_by_category_id(category);
        return  ResponseEntity.ok(quizzes);
    }

    @GetMapping("cat/act/{id}")
    public  List<Quizz> get_all_active_quiz_with_cat_id(@PathVariable("id") int id){
        Category category1=new Category();
        category1.setId(id);
        return quizz_service.get_all_active_quiz_resp_category_id(category1);
    }
}
