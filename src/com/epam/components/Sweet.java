package com.epam.components;

import java.util.List;

public class Sweet {
    private String identity;
    private String name;
    private String production;
    private SweetType sweetType;
    private Integer energy;
    private List<Ingredient> ingredients;
    private NutritionalValue nutritionalValue;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getName() {
        return name;
    }

    public Integer getEnergy() {
        return energy;
    }

    public SweetType getSweetType() {
        return sweetType;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Integer weight() {
        return ingredients.stream().map(Ingredient::getWeight).reduce(Integer::sum).get();
    }

    public NutritionalValue getNutritionalValue() {
        return nutritionalValue;
    }

    public String getProduction() {
        return production;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public void setSweetType(SweetType sweetType) {
        this.sweetType = sweetType;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setNutritionalValue(NutritionalValue nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "identity='" + identity + '\'' +
                ", name='" + name + '\'' +
                ", production='" + production + '\'' +
                ", sweetType=" + sweetType +
                ", energy=" + energy +
                ", ingredients=" + ingredients +
                ", sweet-weight=" + weight() +
                ", nutritionalValue=" + nutritionalValue +
                '}';
    }
}
