package com.app.varargs;

public class Varargs {

    public static void main(String[] args) {
        printShoppingList("Bread", "Milk", "Bananas");
    }

    private static void printShoppingList(String... items) {
        System.out.println("Shopping List");
        for (int i=0; i< items.length; i++) {
            System.out.println(i+1 + " :: " + items[i]);
        }
    }
}
