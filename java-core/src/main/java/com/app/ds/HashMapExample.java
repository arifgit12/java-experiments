package com.app.ds;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {

        HashMap<String, Integer> phonebook = new HashMap<>();

        phonebook.put("Arif", 1234);
        phonebook.put("Jill", 999);
        phonebook.put("BikeKite", 786);
        phonebook.put("Brenda", 564);
        phonebook.put(null, 457);

        if(phonebook.containsKey("Brenda")){
            phonebook.put("Brenda", 765);
        }
        System.out.println(phonebook);
    }
}
