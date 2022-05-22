package com.exam.examserver.Models.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Quizz> quiz=new ArrayList<>();

    public List<Quizz> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<Quizz> quiz) {
        this.quiz = quiz;
    }


    public Category(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
