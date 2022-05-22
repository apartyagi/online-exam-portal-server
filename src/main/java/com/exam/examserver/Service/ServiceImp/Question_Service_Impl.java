package com.exam.examserver.Service.ServiceImp;

import com.exam.examserver.Models.exam.Questions;
import com.exam.examserver.Models.exam.Quizz;
import com.exam.examserver.Models.exam.Result;
import com.exam.examserver.Repo.QuestionRepo;
import com.exam.examserver.Repo.ResultRepo;
import com.exam.examserver.Service.Question_Service;
import com.exam.examserver.Service.Result_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Question_Service_Impl implements Question_Service {
    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    ResultRepo resultRepo;

    @Autowired
    Question_Service question_service;

    @Override
    public Questions addQuestion(Questions questions) {
        return questionRepo.save(questions);
    }

    @Override
    public Questions getQuestion(int id) {
        return questionRepo.findById(id).get();
    }

    @Override
    public List<Questions> get_all_Question() {
        return questionRepo.findAll();
    }

    @Override
    public Questions updateQuestion(Questions questions) {
      return questionRepo.save(questions);
    }

    @Override
    public String delete_question(int questions) {
        try{
            questionRepo.deleteById(questions);
            return "Success";
        }catch(Exception exception){
            return "Error";
        }
    }

    @Override
    public List<Questions> get_all_question_of_quiz(Quizz quizz) {
    return questionRepo.findByQuizz(quizz);
    }


    @Override
    public Map<String, Object> evaluate_question(List<Questions> questions) {
        int total_question=0;
        int attempted_question=0;
        int per_question_marks=0;
        int correct_answer=0;
        int wrong_answer=0;
        int total_marks=0;
        int result=0;

        for(Questions client_req:questions){
            Questions question = question_service.getQuestion(client_req.getId());
            Quizz quizz = question.getQuizz();
            total_marks=Integer.parseInt(quizz.getMax_marks());
            total_question=Integer.parseInt(quizz.getNo_of_question());
            per_question_marks=total_marks/total_question;
            attempted_question=total_question;
            if (client_req.getGiven_answer().equals(question.getAnswer())){
                correct_answer++;
            }
            else {
                wrong_answer++;
            }
            result=correct_answer*per_question_marks;
        }
        Map<String,Object> objectMap =new HashMap<>();
        objectMap.put("total_question",total_question);
        objectMap.put("attempted_question",attempted_question);
        objectMap.put("per_question_marks",per_question_marks);
        objectMap.put("correct_answer",correct_answer);
        objectMap.put("wrong_answer",wrong_answer);
        objectMap.put("total_marks",total_marks);
        objectMap.put("result",result);
        return objectMap;
    }


}
