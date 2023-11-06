package org.example.model.animalFactory;

import org.example.model.pets.Dog;

import java.util.Calendar;

public class DogFactory implements AbstractAnimalFactory<Dog>{

    @Override
    public Dog create(String name, Calendar bdate) {
        return new Dog(name, bdate);
    }
}
