package com.exam.examserver.Models.exam;

import com.exam.examserver.Models.exam.Role;
import com.exam.examserver.Models.exam.User;

import javax.persistence.*;

@Entity
public class User_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne()
    Role role;

    public User_Role(int id, User user, Role role) {
        this.id = id;
        this.user = user;
        this.role = role;
    }

    public User_Role() {
    }

    public int getUser_role() {
        return id;
    }

    public void setUser_role(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
