package com.exam.examserver.Service;

import com.exam.examserver.Models.exam.Category;
import com.exam.examserver.Models.exam.Quizz;
import org.springframework.stereotype.Service;

import java.util.List;
public interface Quizz_Service {

    public Quizz addQuiz(Quizz quizz);
    public Quizz getQuiz(int id);
    public List<Quizz> get_all_Quiz();
    public Quizz update_quiz(Quizz quizz);
    public String delete_quiz(int quizz);
    public List<Quizz> get_quiz_by_category_id(Category category);
    public List<Quizz> get_all_active_quiz_resp_category_id(Category category);
}
