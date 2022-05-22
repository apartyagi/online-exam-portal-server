package com.exam.examserver.Controller;

import com.exam.examserver.Conf.JwtConf;
import com.exam.examserver.Models.JwtRequest;
import com.exam.examserver.Models.JwtResponse;
import com.exam.examserver.Models.exam.User;
import com.exam.examserver.Models.exam.User_Role;
import com.exam.examserver.Service.ServiceImp.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class JwtContra {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtConf jwtUtil;

    @PostMapping("/generate-token")
    public ResponseEntity<?> gen(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }
        catch (UsernameNotFoundException exception){
            throw new Exception("User not found"+exception);
        }
            //authencate
        UserDetails userDetails=userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token=jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public void authenticate(String username ,String password) throws Exception {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }
        catch (BadCredentialsException exception){
            throw  new Exception("Invalid credential"+exception);
        }
        catch (DisabledException exception){
            throw new Exception("User Disabled"+exception);
        }
    }

    @GetMapping("/current-user")
    public User get_current_user(Principal principal){
        String name = principal.getName();
        return userDetailsService.loadUserByUsername(name);
    }
    @GetMapping("/current-user-type")
    public ResponseEntity<?> get_current_user_role(Principal principal){
        String name = principal.getName();
        User user = userDetailsService.loadUserByUsername(name);
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return ResponseEntity.ok(authorities);
    }

}
