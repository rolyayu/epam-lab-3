package com.epam.comparator;

import com.epam.components.Sweet;

import java.util.Comparator;

public class SweetWeightComparator implements Comparator<Sweet> {
    @Override
    public int compare(Sweet firstSweet, Sweet secondSweet) {
        return firstSweet.weight() - secondSweet.weight();
    }
}
