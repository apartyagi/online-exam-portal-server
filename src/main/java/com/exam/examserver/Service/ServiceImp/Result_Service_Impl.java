package com.exam.examserver.Service.ServiceImp;

import com.exam.examserver.Models.exam.Result;
import com.exam.examserver.Models.exam.User;
import com.exam.examserver.Repo.ResultRepo;
import com.exam.examserver.Service.Result_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Result_Service_Impl  implements Result_Service {

    @Autowired
    private ResultRepo resultRepo;

    @Override
    public Result add_answer(Result result) {
        return resultRepo.save(result);
    }

    @Override
    public List<Result> get_all_result_of_particular_user(User user) {

        return resultRepo.findByUserdata(user);
    }

    @Override
    public List<Result> get_all_answer() {
        return resultRepo.findAll();
    }
}
