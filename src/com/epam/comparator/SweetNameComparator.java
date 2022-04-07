package com.epam.comparator;

import com.epam.components.Sweet;

import java.util.Comparator;

public class SweetNameComparator implements Comparator<Sweet> {
    @Override
    public int compare(Sweet firstSweet, Sweet secondSweet) {
        return firstSweet.getName().compareTo(secondSweet.getName());
    }
}
