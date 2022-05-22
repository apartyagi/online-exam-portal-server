package com.exam.examserver.Service.ServiceImp;

import com.exam.examserver.Models.exam.User;
import com.exam.examserver.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        User byUsername = userRepo.findByUsername(s);

        if (byUsername==null){
            throw new UsernameNotFoundException("!Could Not Found User");
        }
        return byUsername;

    }
}
