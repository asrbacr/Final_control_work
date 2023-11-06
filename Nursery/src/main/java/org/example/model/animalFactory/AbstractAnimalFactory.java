package org.example.model.animalFactory;

import org.example.model.animal.Animal;

import java.util.Calendar;

public interface AbstractAnimalFactory<T extends Animal> {
    T create(String name, Calendar bdate);
}
