package org.example.model.animalFactory;

import org.example.model.pets.Cat;

import java.util.Calendar;

public class CatFactory implements AbstractAnimalFactory<Cat>{

    @Override
    public Cat create(String name, Calendar bdate) {
        return new Cat(name, bdate);
    }
}
