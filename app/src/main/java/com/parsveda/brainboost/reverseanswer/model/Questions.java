package com.parsveda.brainboost.reverseanswer.model;

import java.util.ArrayList;

/**
 * Created by kami on 12/24/2016.
 */
public class Questions extends ArrayList<Question> {


    public Questions newInstance() {
        Questions questions = new Questions();
        for (Question question : this) {
            questions.add(question.newInstance());
        }
        return questions;
    }
}
