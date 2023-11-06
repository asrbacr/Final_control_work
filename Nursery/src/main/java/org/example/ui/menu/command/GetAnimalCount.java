package org.example.ui.menu.command;

import org.example.ui.UI;

public class GetAnimalCount implements Command {
    private UI view;
    public GetAnimalCount(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Отобразить счетчик животных";
    }

    @Override
    public void exec() {
        view.getAnimalCount();
    }
}
