package com.exam.examserver.Service;

import com.exam.examserver.Models.exam.Questions;
import com.exam.examserver.Models.exam.Quizz;
import com.exam.examserver.Models.exam.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface Question_Service {

    public Questions addQuestion(Questions questions);
    public Questions getQuestion(int id);
    public List<Questions> get_all_Question();
    public Questions updateQuestion(Questions questions);
    public String  delete_question(int id);
    public List<Questions> get_all_question_of_quiz(Quizz id);
    public Map<String,Object> evaluate_question(List<Questions> questions);

}
