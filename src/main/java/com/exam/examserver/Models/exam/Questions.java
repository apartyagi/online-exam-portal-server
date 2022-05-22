package com.exam.examserver.Models.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String content;
    private String image;
    private String answer;
    @Transient
    private String given_answer;
    private String type;
    @ManyToOne(fetch = FetchType.EAGER)
    private Quizz quizz;

    public Quizz getQuizz() {
        return quizz;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }

    public Questions(int id, String option1, String option2, String option3, String option4, String content, String image, String answer, Quizz quizz) {
        this.id = id;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.content = content;
        this.image = image;
        this.answer = answer;
        this.quizz = quizz;
    }

    public Questions() {
    }

    public String getGiven_answer() {
        return given_answer;
    }

    public void setGiven_answer(String given_answer) {
        this.given_answer = given_answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
