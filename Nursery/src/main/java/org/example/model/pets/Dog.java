package org.example.model.pets;

import java.util.Calendar;

public class Dog extends Pets {
    public Dog(String name, Calendar bdate) {
        super(name, bdate, (short) 24, (byte) 65);
    }
}
