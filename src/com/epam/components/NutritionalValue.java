package com.epam.components;

public class NutritionalValue {
    private Integer proteins;
    private Integer fats;
    private Integer carbs;

    public void setProteins(Integer proteins) {
        this.proteins = proteins;
    }

    public void setFats(Integer fats) {
        this.fats = fats;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    public Integer getProteins() {
        return proteins;
    }

    public Integer getFats() {
        return fats;
    }

    public Integer getCarbs() {
        return carbs;
    }

    @Override
    public String toString() {
        return "NutritionalValue{" +
                "proteins=" + proteins +
                ", fats=" + fats +
                ", carbs=" + carbs +
                '}';
    }
}
