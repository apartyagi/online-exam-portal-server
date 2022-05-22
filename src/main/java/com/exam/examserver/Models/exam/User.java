package com.exam.examserver.Models.exam;

import com.exam.examserver.Service.ServiceImp.Authority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String first_name;
    private String last_name;
    private String password;
    private String email;
    private String phone;
    private String about;
    private String username;
    private boolean enable;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    Set<User_Role> user_roleSet=new HashSet<>();

    @OneToMany(mappedBy = "userdata",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Result> result =new ArrayList<>();

    public User() {
    }

    public User(int id, String first_name, String last_name, String password, String email, String phone, String about, String username, boolean enable, Set<User_Role> user_roleSet) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.username = username;
        this.enable = enable;
        this.user_roleSet = user_roleSet;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> resul) {
        this.result = resul;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Set<User_Role> getUser_roleSet() {
        return user_roleSet;
    }

    public void setUser_roleSet(Set<User_Role> user_roleSet) {
        this.user_roleSet = user_roleSet;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> authoritySet=new HashSet<>();
        user_roleSet.forEach(userRole -> {
            authoritySet.add(new Authority(userRole.getRole().getRole_name()));
        });
        return authoritySet;

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
