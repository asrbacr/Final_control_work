package org.example.model.pets;

import java.util.Calendar;

public class Hamster extends Pets {
    private final short max_commands = 5;
    public Hamster(String name, Calendar bdate) {
        super(name, bdate);
    }
}
