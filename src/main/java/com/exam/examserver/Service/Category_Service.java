package com.exam.examserver.Service;

import com.exam.examserver.Models.exam.Category;
import org.springframework.stereotype.Service;

import java.util.List;
public interface Category_Service {
    public Category addCategory(Category category);
    public Category getCategory(int id);
    public List<Category> get_all_Category();
    public Category updateCategory(Category cat);
    public String deleteCategory(int id);

}
