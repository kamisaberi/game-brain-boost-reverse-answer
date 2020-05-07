package com.parsveda.brainboost.reverseanswer.model;

/**
 * Created by kami on 12/22/2016.
 */
public enum StageTouchOrderType {
    NORMAL(1), REVERSE(2), COMPLEX(3);

    private int value;

    StageTouchOrderType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
