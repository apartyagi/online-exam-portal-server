package com.exam.examserver.Service.ServiceImp;

import com.exam.examserver.Models.exam.Category;
import com.exam.examserver.Models.exam.Quizz;
import com.exam.examserver.Repo.QuizzRepo;
import com.exam.examserver.Service.Quizz_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Quizz_Service_Impl implements Quizz_Service {
    @Autowired
    QuizzRepo quizzRepo;

    @Override
    public Quizz addQuiz(Quizz quizz) {
        return quizzRepo.save(quizz);
    }

    @Override
    public Quizz getQuiz(int id) {
        return quizzRepo.findById(id).get();
    }

    @Override
    public List<Quizz> get_all_Quiz() {
        return quizzRepo.findAll();
    }

    @Override
    public Quizz update_quiz(Quizz quizz) {
        return quizzRepo.save(quizz);
    }

    @Override
    public String delete_quiz(int quizz) {
        try{
            quizzRepo.deleteById(quizz);
            return "Success";
        }
        catch (Exception exception){
            return "Failure";
        }
    }

    @Override
    public List<Quizz> get_quiz_by_category_id(Category category) {
        return quizzRepo.findByCategory(category);
    }

    @Override
    public List<Quizz> get_all_active_quiz_resp_category_id(Category category) {

        return quizzRepo.findByCategoryAndActive(category, true);
    }


}
