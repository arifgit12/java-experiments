package com.app.interfacee.methodreference;

public class Square {
    int sideLength;

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    public int calculateArea(){
        return sideLength * sideLength;
    }
}
