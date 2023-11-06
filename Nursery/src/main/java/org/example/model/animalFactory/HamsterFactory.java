package org.example.model.animalFactory;

import org.example.model.pets.Hamster;

import java.util.Calendar;

public class HamsterFactory implements AbstractAnimalFactory<Hamster>{

    @Override
    public Hamster create(String name, Calendar bdate) {
        return new Hamster(name, bdate);
    }
}