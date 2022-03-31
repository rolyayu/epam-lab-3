package com.epam.comparator;

import com.epam.components.Sweet;

import java.util.Comparator;

public class SweetWeightComparator implements Comparator<Sweet> {
    @Override
    public int compare(Sweet o1, Sweet o2) {
        return o1.weight() - o2.weight();
    }
}
