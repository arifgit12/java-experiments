package com.app.oop;

import com.app.model.Building;
import com.app.model.House;
import com.app.model.Office;

import java.util.List;

public class Substitution {
    public static void main(String[] args) {
        Building building = new Building();
        Office office = new Office();
        build(building);
        build(office);
    }

    static void build(Building building){
        System.out.println("Construction a new: "+ building.toString());
    }

    static void addHouseToList(List<? super House> buildings) {

    }
}
