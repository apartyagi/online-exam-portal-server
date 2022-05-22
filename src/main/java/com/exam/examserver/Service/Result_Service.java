package com.exam.examserver.Service;

import com.exam.examserver.Models.exam.Result;
import com.exam.examserver.Models.exam.User;

import java.util.List;

public interface Result_Service {

    public Result add_answer(Result result);
    public List<Result> get_all_result_of_particular_user(User user_id);
    public List<Result> get_all_answer();

}
