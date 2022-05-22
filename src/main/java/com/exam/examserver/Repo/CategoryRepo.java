package com.exam.examserver.Repo;

import com.exam.examserver.Models.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    public void deleteById(int id);
}
