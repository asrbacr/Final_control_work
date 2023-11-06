package org.example.ui.menu.command;

import org.example.ui.UI;

public class ShowAnimals implements Command {
    private UI view;
    public ShowAnimals(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать список животных";
    }

    @Override
    public void exec() {
        view.showAnimals(false);
    }
}