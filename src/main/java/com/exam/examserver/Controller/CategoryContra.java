package com.exam.examserver.Controller;

import com.exam.examserver.Models.exam.Category;
import com.exam.examserver.Service.Category_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cat")
public class CategoryContra {
    @Autowired
    Category_Service category_service;

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        try{
        Category category1 = category_service.addCategory(category);
        return ResponseEntity.ok(category1);
        }
        catch (Exception exception){
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get_single_category(@PathVariable("id") int id){
        Category category = category_service.getCategory(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/all")
    public ResponseEntity<?> get_all_cat(){
        List<Category> all_category = category_service.get_all_Category();
        return ResponseEntity.ok(all_category);
    }
    @PutMapping("/upd")
    public ResponseEntity<?> update_cat(@RequestBody Category category){
        Category category1 = category_service.updateCategory(category);
        return ResponseEntity.ok(category1);
    }
    @DeleteMapping("/del/{id}")
    public String del_cat(@PathVariable("id") int id){
        try{
            String s = category_service.deleteCategory(id);
            return "Success";
        }catch (Exception exception){
            return "failure";
        }
    }


}
