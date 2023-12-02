package com.app.comparison;

import com.app.model.Item;

import java.util.Comparator;

public class SortItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item a, Item b){
        return Float.compare(a.getPrice(), b.getPrice());
    }
}
