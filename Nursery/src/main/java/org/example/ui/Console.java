package org.example.ui;

import org.example.presenter.Presenter;
import org.example.ui.menu.MainMenu;
import org.example.ui.menu.Menu;

import java.util.List;
import java.util.Scanner;

public class Console implements UI{
    private static final String GREETING = "Hello.";
    private static final String FAREWELL = "Have a nice day.";
    private static final String WRONGCHOICE = "Такого пункта нет, попробуйте ещё раз.";
    private static final String INCORRECTINPUT = "Неправильный формат данных.";
    private static final String NODATA = "Нет данных";
    private Scanner scanner;
    private Presenter presenter;
    private boolean active;

    public Console() {
        scanner = new Scanner(System.in);
        active = false;
        presenter = new Presenter(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        active = true;
        print(GREETING);
        enterMainMenu();
        finish();
    }

    @Override
    public void finish() {
        active = false;
        print(FAREWELL);
    }

    private void enterMainMenu() {
        Menu mainMenu = new MainMenu(this);
        enterMenu(mainMenu);
    }

    private void enterMenu(Menu menu) {
        menu.setActive();
        while (active && menu.isActive()) {
            printMenu(menu);
            userInteract(menu);
        }
    }

    private void printMenu(Menu menu){
        print(menu.buildMenu());
    }

    private void userInteract(Menu menu) {
        String userInput = scanner.nextLine();
        int choice = parseInput(userInput, menu);
        if (choice != -1) {
            menu.exec(choice);
        } else {
            print(WRONGCHOICE);
        }
    }

    private int parseInput(String input, Menu menu) {
        if (input.matches("^\\d+$")) {
            int numInput = Integer.parseInt(input);
            if (numInput > 0 && numInput <= menu.size()) return numInput;
        }
        return -1;
    }
    private int parseInput(String input, List<String> elements) {
        if (input.matches("^\\d+$")) {
            int numInput = Integer.parseInt(input);
            if (numInput > 0 && numInput <= elements.size()) return numInput;
        }
        return -1;
    }

    @Override
    public String noData() {
        return NODATA;
    }

    private boolean isDateFormatValid(String dateString) {
        return dateString.matches("^\\d{4}-\\d{2}-\\d{2}$") || dateString.isEmpty();
    }

    @Override
    public void addAnimal() {
        print("Выберите тип животного для добавления из списка ниже");
        presenter.showAnimalTypes();
        String userInput = scanner.nextLine();
        int choice = parseInput(userInput, presenter.getAnimalTypes());
        if (choice != -1) {
            print("Введите имя животного");
            String name = scanner.nextLine();
            print("Введите дату рождения животного в формате YYYY-MM-DD");
            String birthDateStr = scanner.nextLine();
            if (isDateFormatValid(birthDateStr)) {
                if (presenter.addAnimal(choice, name, birthDateStr)) {
                    print("Успешное создание");
                } else print("Что-то пошло не так, попробуйте ещё раз");
            } else {
                print(INCORRECTINPUT);
            }
        } else {
            print(WRONGCHOICE);
        }
    }

    @Override
    public void getAnimalCount() {
        presenter.getAnimalCount();
    }

    @Override
    public void showAnimals(boolean orderByDate) {
        presenter.showAnimals(orderByDate);
    }

    @Override
    public void addTestData() {
        presenter.addTestData();
    }

    @Override
    public void teachAnimal() {
        print("Выберите животное из списка ниже");
        presenter.showAnimalsList();
        String userInput = scanner.nextLine();
        int animalChoice = parseInput(userInput, presenter.getAnimalList());
        if (animalChoice != -1) {
            print("Выберите команду из списка ниже");
            presenter.showCommandList();
            String name = scanner.nextLine();
            int commandChoice = parseInput(name, presenter.getCommandList());
            if (commandChoice != -1) {
                if (presenter.teachAnimal(animalChoice, commandChoice)) {
                    print("Обучение успешно");
                } else print("Не удалось, может в следующий раз получится");
            } else {
                print(WRONGCHOICE);
            }
        } else {
            print(WRONGCHOICE);
        }
    }
}
