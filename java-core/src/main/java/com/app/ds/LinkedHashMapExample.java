package com.app.ds;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {

        LinkedHashMap<String, Integer> phonebook = new LinkedHashMap(4, 0.75f, false);

        phonebook.put("Arif", 1234);
        phonebook.put("Jill", 999);
        phonebook.put("BikeKite", 786);
        phonebook.put("Brenda", 564);
        phonebook.put("Gary", 256);

        System.out.println("Kevin's Number: "+ phonebook.get("Brenda"));

        for (Map.Entry<String, Integer> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }
    }
}
