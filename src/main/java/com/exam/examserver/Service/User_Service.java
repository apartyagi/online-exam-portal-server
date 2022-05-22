package com.exam.examserver.Service;

import com.exam.examserver.Models.exam.User;
import com.exam.examserver.Models.exam.User_Role;
import org.springframework.stereotype.Service;

import java.util.Set;
public interface User_Service {

    public User Create_User(User user, Set<User_Role> set_user_roles);

    public User GetUser(String user);

    public String Delete_User(int userId);
    public User Update_user(User user);
}
