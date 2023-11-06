package org.example.ui.menu.command;

import org.example.ui.UI;

public class AddTestData implements Command {
    private UI view;
    public AddTestData(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить тестовые данные";
    }

    @Override
    public void exec() {
        view.addTestData();
    }
}