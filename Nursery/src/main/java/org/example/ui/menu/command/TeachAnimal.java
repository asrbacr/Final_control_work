package org.example.ui.menu.command;

import org.example.ui.UI;

public class TeachAnimal implements Command {
    private UI view;
    public TeachAnimal(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Обучить животное(не гарантия результата)";
    }

    @Override
    public void exec() {
        view.teachAnimal();
    }
}
