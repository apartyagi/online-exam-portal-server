package com.exam.examserver.Models.exam;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {

    @Id
    int id;
    String role_name;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
    private Set<User_Role> userRoleSet=new HashSet<>();

    public Role() {
    }

    public Role(int id, String role_name, Set<User_Role> userRoleSet) {
        this.id = id;
        this.role_name = role_name;
        this.userRoleSet = userRoleSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Set<User_Role> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<User_Role> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}