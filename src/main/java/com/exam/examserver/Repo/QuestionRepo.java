package com.exam.examserver.Repo;

import com.exam.examserver.Models.exam.Questions;
import com.exam.examserver.Models.exam.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Questions,Integer> {


    List<Questions> findByQuizz(Quizz quizz);
}
