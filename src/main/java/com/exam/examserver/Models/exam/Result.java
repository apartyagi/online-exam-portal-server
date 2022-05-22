package com.exam.examserver.Models.exam;

import javax.persistence.*;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    @ManyToOne()
    private User userdata;
    @ManyToOne()
    private Quizz quizdata;
    private String result;
    private String Marks_obtained;
    private String Marks_get;

    public Result(int id, User userdata, Quizz quizdata, String result, String marks_obtained, String marks_get) {
        this.id = id;
        this.userdata = userdata;
        this.quizdata = quizdata;
        this.result = result;
        Marks_obtained = marks_obtained;
        Marks_get = marks_get;
    }

    public Result() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserdata() {
        return userdata;
    }

    public void setUserdata(User userdata) {
        this.userdata = userdata;
    }

    public Quizz getQuizdata() {
        return quizdata;
    }

    public void setQuizdata(Quizz quizdata) {
        this.quizdata = quizdata;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMarks_obtained() {
        return Marks_obtained;
    }

    public void setMarks_obtained(String marks_obtained) {
        Marks_obtained = marks_obtained;
    }

    public String getMarks_get() {
        return Marks_get;
    }

    public void setMarks_get(String marks_get) {
        Marks_get = marks_get;
    }
}
