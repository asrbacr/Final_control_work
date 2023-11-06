package org.example.model.packAnimals;

import java.util.Calendar;

public class Horse extends PackAnimals {
    public Horse(String name, Calendar bdate) {
        super(name, bdate, (byte) 35);
    }
}