package com.epam.components;

public enum SweetType {
    CARAMEL("Caramel"),
    IRIS("Iris"),
    CHOCOLATE("Chocolate");
    private final String type;

    SweetType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
