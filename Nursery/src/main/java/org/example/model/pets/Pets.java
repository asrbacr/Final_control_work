package org.example.model.pets;

import org.example.model.animal.Animal;

import java.util.Calendar;

public abstract class Pets extends Animal {
    public Pets(String name, Calendar bdate) {
        this(name, bdate, (short) 16, (byte) 45);
    }
    public Pets(String name, Calendar bdate, short max_commands) {
        this(name, bdate, max_commands, (byte) 45);
    }
    public Pets(String name, Calendar bdate, short max_commands, byte learn_probability) {
        super(name, bdate, max_commands, learn_probability);
    }
}
