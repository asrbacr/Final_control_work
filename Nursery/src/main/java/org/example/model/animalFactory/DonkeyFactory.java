package org.example.model.animalFactory;

import org.example.model.packAnimals.Donkey;

import java.util.Calendar;

public class DonkeyFactory implements AbstractAnimalFactory<Donkey>{

    @Override
    public Donkey create(String name, Calendar bdate) {
        return new Donkey(name, bdate);
    }
}