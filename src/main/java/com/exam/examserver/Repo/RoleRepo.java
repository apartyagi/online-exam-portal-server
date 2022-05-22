package com.exam.examserver.Repo;

import com.exam.examserver.Models.exam.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {


}
