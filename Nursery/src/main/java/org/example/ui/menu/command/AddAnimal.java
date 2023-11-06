package org.example.ui.menu.command;

import org.example.ui.UI;
public class AddAnimal implements Command {
    private UI view;
    public AddAnimal(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить животное";
    }

    @Override
    public void exec() {
        view.addAnimal();
    }
}