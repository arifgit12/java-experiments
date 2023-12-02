package com.app.interfacee;

import com.app.comparison.SortItemComparator;
import com.app.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortItem {

    private static final Logger logger = LoggerFactory.getLogger(SortItem.class);
    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "shirt", 100));
        items.add(new Item(2, "shoes", 3800));
        items.add(new Item(3, "pants", 1500));
        items.add(new Item(4, "hat", 70));
        items.add(new Item(5, "jacket", 1250));
        items.add(new Item(6, "shocks", 14));

        Collections.sort(items, new SortItemComparator());

        for (Item item: items) {
            logger.info(item.toString());
        }
    }

    static List<Item> sortList(List<Item> items){
        List<Item> result = new ArrayList<>(items);
        result.sort(Comparator.comparingDouble(Item::getPrice));
       return result;
    }
}
