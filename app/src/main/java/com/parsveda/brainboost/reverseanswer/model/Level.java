package com.parsveda.brainboost.reverseanswer.model;

import java.util.ArrayList;

/**
 * Created by kami on 12/21/2016.
 */
public class Level {
    private int id;
    private int partCount;
    private int SizeVar;
    private ArrayList<Integer> PresetShapesCount;

    public Level() {
        this.id = 0;
        this.partCount = 0;
        this.PresetShapesCount = new ArrayList<>();
    }

    public int getSizeVar() {
        return SizeVar;
    }

    public void setSizeVar(int sizeVar) {
        SizeVar = sizeVar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPartCount() {
        return partCount;
    }

    public void setPartCount(int partCount) {
        this.partCount = partCount;
    }

    public ArrayList<Integer> getPresetShapesCount() {
        return PresetShapesCount;
    }

    public void setPresetShapesCount(ArrayList<Integer> presetShapesCount) {
        PresetShapesCount = presetShapesCount;
    }
}
