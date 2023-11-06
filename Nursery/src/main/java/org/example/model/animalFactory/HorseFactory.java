package org.example.model.animalFactory;

import org.example.model.packAnimals.Horse;

import java.util.Calendar;

public class HorseFactory implements AbstractAnimalFactory<Horse>{

    @Override
    public Horse create(String name, Calendar bdate) {
        return new Horse(name, bdate);
    }
}