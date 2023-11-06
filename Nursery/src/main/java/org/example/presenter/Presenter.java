package org.example.presenter;

import org.example.model.NurseryService;
import org.example.ui.UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Presenter {
    private UI view;
    private NurseryService model;

    public Presenter(UI view) {
        this.view = view;
        model = new NurseryService();
    }

    public void showAnimals(boolean orderByDate) {
        List<String> animalStrings = model.getAnimalsDescription(orderByDate);
        if (animalStrings.isEmpty()) view.print(view.noData());
        else {
            StringBuilder result = new StringBuilder();
            for (String animalStr : animalStrings) {
                result.append(animalStr).append("\n");
            }
            view.print(result.toString());
        }
    }

    public void addTestData() {
        model.addTestData();
    }

    public void getAnimalCount() {
        view.print(String.format("Животных учтено: %d", model.getAnimalCounter()));
    }

    public void showAnimalTypes() {
        List<String> animalTypes = model.getAnimalTypes();
        for (int i = 0; i < animalTypes.size(); i++) {
            view.print(String.format("%d. %s", i+1, animalTypes.get(i)));
        }
    }
    public List<String> getAnimalTypes() {
        return model.getAnimalTypes();
    }

    public boolean addAnimal(int animalTypeNumber, String name, String birthDateStr) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(sdf.parse(birthDateStr));
            return model.addAnimal(model.getAnimalTypes().get(animalTypeNumber-1), name, cal);
        } catch (ParseException e) {
            return false;
        }
    }

    public List<String> getAnimalList() {
        return model.getAnimalNames();
    }

    public void showAnimalsList() {
        List<String> animalStrings = model.getAnimalNames();
        if (animalStrings.isEmpty()) view.print(view.noData());
        else {
            for (int i = 0; i < animalStrings.size(); i++) {
                view.print(String.format("%d. %s", i+1, animalStrings.get(i)));
            }
        }
    }

    public List<String> getCommandList() {
        return model.getAvailableCommands();
    }

    public void showCommandList() {
        List<String> commands = model.getAvailableCommands();
        if (commands.isEmpty()) view.print(view.noData());
        else {
            for (int i = 0; i < commands.size(); i++) {
                view.print(String.format("%d. %s", i+1, commands.get(i)));
            }
        }
    }

    public boolean teachAnimal(int animalChoice, int commandChoice) {
        return model.teachCommand(model.getAnimalNames().get(animalChoice-1), model.getAvailableCommands().get(commandChoice-1));
    }
}
