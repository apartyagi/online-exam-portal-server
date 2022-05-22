package com.exam.examserver.Models.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Quizz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean active;
    private String title;
    private String description;
    private String max_marks;
    private String no_of_question;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "quizz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Questions> questions=new ArrayList<>();
    public Quizz() {
    }

    public Quizz(int id, boolean active, String title, String description, String max_marks, String no_of_question, Category category, List<Questions> questions) {
        this.id = id;
        this.active = active;
        this.title = title;
        this.description = description;
        this.max_marks = max_marks;
        this.no_of_question = no_of_question;
        this.category = category;
        this.questions = questions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getMax_marks() {
        return max_marks;
    }

    public void setMax_marks(String max_marks) {
        this.max_marks = max_marks;
    }

    public String getNo_of_question() {
        return no_of_question;
    }

    public void setNo_of_question(String no_of_question) {
        this.no_of_question = no_of_question;
    }
}
