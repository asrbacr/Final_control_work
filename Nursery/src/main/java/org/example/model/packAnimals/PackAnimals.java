package org.example.model.packAnimals;

import org.example.model.animal.Animal;

import java.util.Calendar;

public abstract class PackAnimals extends Animal {

    public PackAnimals(String name, Calendar bdate) {
        this(name, bdate, (short) 5, (byte) 15);
    }
    public PackAnimals(String name, Calendar bdate, byte learn_probability) {
        this(name, bdate, (short) 5, learn_probability);
    }
    public PackAnimals(String name, Calendar bdate, short max_commands, byte learn_probability) {
        super(name, bdate, (short) max_commands, (byte) learn_probability);
    }
}
