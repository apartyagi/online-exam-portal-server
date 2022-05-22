package com.exam.examserver.Repo;

import com.exam.examserver.Models.exam.Result;
import com.exam.examserver.Models.exam.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepo extends JpaRepository<Result,Integer> {


    public List<Result> findByUserdata(User user);
    public List<Result> findByQuizdata(Result result);

}
