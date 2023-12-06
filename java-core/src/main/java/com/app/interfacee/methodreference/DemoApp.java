package com.app.interfacee.methodreference;

public class DemoApp {
    public static void main(String[] args) {
        Square s = new Square(4);

        Shapes shapes = (Square square) -> {
          return square.calculateArea();
        };

        System.out.println("Area: " + shapes.getArea(s));

        Shapes shapes1 = Square::calculateArea;

        System.out.println("Area: " + shapes1.getArea(s));
    }
}
