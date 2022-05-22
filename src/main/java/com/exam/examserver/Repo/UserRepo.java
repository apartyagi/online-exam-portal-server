package com.exam.examserver.Repo;

import com.exam.examserver.Models.exam.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    public User findByUsername(String name);


}
