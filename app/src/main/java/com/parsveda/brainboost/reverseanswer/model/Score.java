package com.parsveda.brainboost.reverseanswer.model;

/**
 * Created by kami on 12/20/2016.
 */
public class Score {

    private int currentValue = 0;
    private int score = 0;
    private float time = 0.0f;
    private int partCount = 0;

    private int highestNumber = 0;

    private int survivalModeBestScore = 0;
    private int timeTrailModeBestScore = 0;
    //private int ComplexModeBestScore = 0;

//    public int getComplexModeBestScore() {
//        return ComplexModeBestScore;
//    }
//
//    public void setComplexModeBestScore(int complexModeBestScore) {
//        ComplexModeBestScore = complexModeBestScore;
//    }

//    private List<Part> parts = new ArrayList<>();

    private GameType type = GameType.SURVIVAL;

//    private StageTouchOrderType touchOrderType = StageTouchOrderType.NORMAL;
//    public StageTouchOrderType partTouchOrderType = StageTouchOrderType.NORMAL;


    public int getSurvivalModeBestScore() {
        return survivalModeBestScore;
    }

    public void setSurvivalModeBestScore(int survivalModeBestScore) {
        this.survivalModeBestScore = survivalModeBestScore;
    }

    public int getTimeTrailModeBestScore() {
        return timeTrailModeBestScore;
    }

    public void setTimeTrailModeBestScore(int timeTrailModeBestScore) {
        this.timeTrailModeBestScore = timeTrailModeBestScore;
    }

    public int getHighestNumber() {
        return highestNumber;
    }

    public void setHighestNumber(int highestNumber) {
        this.highestNumber = highestNumber;
    }


//    public StageTouchOrderType getTouchOrderType() {
//        return touchOrderType;
//    }
//
//    public void setTouchOrderType(StageTouchOrderType touchOrderType) {
//        this.touchOrderType = touchOrderType;
//    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public int getPartCount() {
        return partCount;
    }

    public void setPartCount(int partCount) {
        this.partCount = partCount;
    }

    public void addPartCount(int partCount) {
        this.partCount += partCount;
    }


    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }


    public void addCurrentValue(int currentValue) {
        this.currentValue += currentValue;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }


    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
