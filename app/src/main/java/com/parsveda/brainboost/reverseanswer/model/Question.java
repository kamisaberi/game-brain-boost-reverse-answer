package com.parsveda.brainboost.reverseanswer.model;

/**
 * Created by kami on 12/24/2016.
 */
public class Question {
    private int id;
    private String text;
    private int answer;

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question newInstance() {
        Question question = new Question();
        question.id = this.id;
        question.text = this.text;
        question.answer = this.answer;
        return question;
    }

}
