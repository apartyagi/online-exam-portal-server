package com.exam.examserver.Service.ServiceImp;

import com.exam.examserver.Models.exam.User;
import com.exam.examserver.Models.exam.User_Role;
import com.exam.examserver.Repo.RoleRepo;
import com.exam.examserver.Repo.UserRepo;
import com.exam.examserver.Service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class User_Service_Impl implements User_Service {

    @Autowired
    private UserRepo  userRepo;

    @Autowired
    private RoleRepo  roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User Create_User(User user, Set<User_Role> set_user_roles) {

        User local=userRepo.findByUsername(user.getUsername());
        if (local!=null){
            System.out.println("Log Already Exist Motherfucker");
        }
        else {
            for(User_Role us:set_user_roles){
                roleRepo.save(us.getRole());
            }
            user.getUser_roleSet().addAll(set_user_roles);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            local=this.userRepo.save(user);
            System.out.println("user Not Exist =>"+user.getFirst_name());
        }

        return local;
    }

    @Override
    public User GetUser(String user) {
        return userRepo.findByUsername(user);
    }

    @Override
    public String Delete_User(int userId) {
     try {
         userRepo.deleteById(userId);
         return "Success_Delete";
     }
     catch (Exception er){
         return "Error_IN_DELETE";
     }
    }

    @Override
    public User Update_user(User user) {
        User byUsername = userRepo.findByUsername(user.getUsername());
        if (byUsername==null){
            System.out.println("User Not Exist");
        }
        else {

        }
        return null;
    }


}
