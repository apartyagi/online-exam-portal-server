package com.exam.examserver.Service.ServiceImp;

import com.exam.examserver.Models.exam.Category;
import com.exam.examserver.Repo.CategoryRepo;
import com.exam.examserver.Service.Category_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Category_Service_Impl implements Category_Service {

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public Category addCategory(Category category) {
            return categoryRepo.save(category);
    }

    @Override
    public Category getCategory(int id) {
        return categoryRepo.findById(id).get();

    }

    @Override
    public List<Category> get_all_Category() {
        return categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(Category cat) {
        return categoryRepo.save(cat);
    }

    @Override
    public String deleteCategory(int cat) {
        try{
            categoryRepo.deleteById(cat);
            return "Delete_Success";
        }catch (Exception exception){
            return "Failure";
        }
    }
}
