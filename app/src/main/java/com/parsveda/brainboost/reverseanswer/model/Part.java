package com.parsveda.brainboost.reverseanswer.model;

/**
 * Created by kami on 12/22/2016.
 */
public class Part {
    private int id;
    private StageTouchOrderType touchOrderType = StageTouchOrderType.NORMAL;
    private float remainingTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(float remainingTime) {
        this.remainingTime = remainingTime;
    }

    public StageTouchOrderType getTouchOrderType() {
        return touchOrderType;
    }

    public void setTouchOrderType(StageTouchOrderType touchOrderType) {
        this.touchOrderType = touchOrderType;
    }
}
