package com.epam.components;

public class ChocolateIngredient extends Ingredient {

    public ChocolateIngredient(Ingredient ingredient, String chocolateType) {
        setName("CHOCOLATE");
        setWeight(ingredient.getWeight());
        setChocolateType(chocolateType);
    }

    private String chocolateType;

    public void setChocolateType(String chocolateType) {
        this.chocolateType = chocolateType;
    }

    public String getChocolateType() {
        return chocolateType;
    }

    @Override
    public String toString() {
        return "ChocolateIngredient{" +
                "name='" + getName() + '\'' +
                ", weight=" + getWeight() +
                ", type='" + getChocolateType() +
                "'}";
    }
}
