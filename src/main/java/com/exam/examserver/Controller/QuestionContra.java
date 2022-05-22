package com.exam.examserver.Controller;

import com.exam.examserver.Models.exam.Questions;
import com.exam.examserver.Models.exam.Quizz;
import com.exam.examserver.Models.exam.Result;
import com.exam.examserver.Service.Question_Service;
import com.exam.examserver.Service.Result_Service;
import com.exam.examserver.Service.ServiceImp.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/que")
@CrossOrigin("*")
public class QuestionContra {

    @Autowired
    Question_Service question_service;

    @Autowired
    Result_Service result_service;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    int total_question=0;
    int attempted_question=0;
    int per_question_marks=0;
    int correct_answer=0;
    int wrong_answer=0;
    int total_marks=5;
    int results=0;


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Questions questions){
        Questions questions1 = question_service.addQuestion(questions);
        return ResponseEntity.ok(questions1);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get_question(@PathVariable("id") int id){
        Questions question = question_service.getQuestion(id);
        return ResponseEntity.ok(question);

    }
    @GetMapping("/all")
    public ResponseEntity<?> get_all_question(){
        List<Questions> all_question = question_service.get_all_Question();
        return ResponseEntity.ok(all_question);

    }
    @PutMapping("/upd")
    public ResponseEntity<?> update(@RequestBody Questions questions){
        Questions questions1 = question_service.updateQuestion(questions);
        return ResponseEntity.ok(questions1);

    }
    @DeleteMapping("/del/{id}")
    public String add(@PathVariable("id") int id){
        try{
            question_service.delete_question(id);
            return "Success";
        }catch (Exception exception){
            return "Failure";
        }
    }

   @GetMapping("/quiz/ques/{id}")
   public ResponseEntity<?> questions(@PathVariable("id") int id){
        Quizz quizz=new Quizz();
        quizz.setId(id);
       List<Questions> all_question_of_quiz = question_service.get_all_question_of_quiz(quizz);
       all_question_of_quiz.forEach((questions -> questions.setAnswer("")));
       return ResponseEntity.ok(all_question_of_quiz);
   }
    //Examine Client Side Result


   @PostMapping("/eval-res")
   public ResponseEntity<?> evaluate_question_my_contra(@RequestBody List<Questions> questions){
       Map<String, Object> obj = question_service.evaluate_question(questions);

       total_question= (int) obj.get("total_question");
       attempted_question= (int) obj.get("attempted_question");
       per_question_marks= (int) obj.get("per_question_marks");
       correct_answer= (int) obj.get("correct_answer");
       wrong_answer= (int) obj.get("wrong_answer");
       total_marks= (int) obj.get("total_marks");
       results= (int) obj.get("result");

       return  ResponseEntity.ok(obj);
   }

    @PostMapping("/add-answer")
    public ResponseEntity<?> Add_Answer(@RequestBody Result result){
        result.setResult("pending");
        result.setMarks_get(""+results);
        result.setMarks_obtained(""+total_marks);
        result_service.add_answer(result);
        return ResponseEntity.ok("Answer Add Successfully");
    }




}
