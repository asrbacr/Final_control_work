package org.example.model;

import org.example.model.animal.Animal;
import org.example.model.animalFactory.AbstractAnimalFactory;
import org.example.model.animalFactory.FactoryAnimalProvider;
import org.example.model.command.Command;
import org.example.model.command.CommandList;

import java.util.*;

public class NurseryService {
    private final List<Animal> animals;
    private final CommandList availableCommands;
    private int animalCounter;

    public static int numberInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min)+1) + min;
    }

    public NurseryService() {
        animalCounter = 0;
        animals = new ArrayList<>();
        availableCommands = CommandList.getInstance();
    }

    public List<String> getAnimalTypes() {
        return FactoryAnimalProvider.availableAnimalClass;
    }

    @SuppressWarnings("unchecked")
    public boolean addAnimal(String type, String name, Calendar bdate) {
        Animal existed = getAnimalByName(name);
        if (existed != null) return false;
        AbstractAnimalFactory<Animal> factory = FactoryAnimalProvider.getFactory(type);
        if (factory != null) {
            animals.add(factory.create(name, bdate));
            animalCounter++;
            return true;
        }
        else return false;
    }

    public int getAnimalCounter(){
        return animalCounter;
    }

    public List<String> getAvailableCommands(){
        List<String> result = new ArrayList<>(availableCommands.listAvailableCommandsNames());
        Collections.sort(result);
        return result;
    }

    /**
     * Search for animal by name ignore Case
     * @param name name to search
     * @return Animal obj or null
     */
    private Animal getAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) return animal;
        }
        return null;
    }

    private boolean teachCommand(Animal animal, Command command) {
        if (animal != null) {
            if (command != null) return animal.learn(command);
        }
        return false;
    }

    public boolean teachCommand(String animalName, String commandName) {
        return teachCommand(getAnimalByName(animalName), availableCommands.getCommand(commandName));
    }

    private List<String> getAnimalCommandNames(Animal animal)
    {
        List<String> result = new ArrayList<>();
        if (animal != null) {
            List<Command> commands = animal.getCommands();
            if (commands != null) {
                for (Command command : commands) {
                    result.add(command.toString());
                }
            }
        }
        return result;
    }

    public List<String> getAnimalCommandNames(String name) {
        return getAnimalCommandNames(getAnimalByName(name));
    }

    public List<String> getAnimalNames() {
        List<String> result = new ArrayList<>();
        for (Animal animal : animals) {
            result.add(animal.getName());
        }
        return result;
    }

    private String getAnimalDescription(Animal animal) {
        if (animal != null) {
            return animal.toString();
        }
        else return null;
    }

    private String getAnimalDescription(String name) {
        return getAnimalDescription(getAnimalByName(name));
    }

    public List<String> getAnimalsDescription() {
        return getAnimalsDescription(false);
    }

    public List<String> getAnimalsDescription(boolean sortByDate) {
        List<Animal> animalList = animals;
        if (sortByDate) {
            animalList = new ArrayList<>(animals);
            animalList.sort((Comparator.comparing(Animal::getBirthDate)));
        }
        List<String> result = new ArrayList<>();
        for (Animal animal : animalList) {
            result.add(getAnimalDescription(animal));
        }
        return result;
    }

    public void addTestData() {
        addAnimal("dog", "Fido", new GregorianCalendar(2020, Calendar.JANUARY , 1));
        teachCommand("Fido", "sit");
        teachCommand("Fido", "fetch");
        addAnimal("cat", "Whiskers", new GregorianCalendar(2019, Calendar.MAY, 15));
        teachCommand("Whiskers", "sit");
        addAnimal("hamster", "Hammy", new GregorianCalendar(2021, Calendar.MARCH, 10));
        teachCommand("Hammy", "roll");
        teachCommand("Hammy", "Hide");
        addAnimal("dog", "Buddy", new GregorianCalendar(2018, Calendar.DECEMBER, 10));
        teachCommand("Buddy", "Sit");
        teachCommand("Buddy", "Paw");
    }
}