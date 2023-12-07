package com.app.bookingsystem;

public class App {
    public static void main(String[] args) {

        Schedular scheduler = new Schedular();
        scheduler.bookHaircut("Jill", "Friday");
        scheduler.bookHaircut("Harry", "Monday");
    }
}
