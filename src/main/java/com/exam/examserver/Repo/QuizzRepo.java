package com.exam.examserver.Repo;

import com.exam.examserver.Models.exam.Category;
import com.exam.examserver.Models.exam.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizzRepo extends JpaRepository<Quizz,Integer> {
    public void deleteById(int id);
    public List<Quizz> findByCategory(Category category);
    public List<Quizz> findByCategoryAndActive(Category category, boolean active);
}
