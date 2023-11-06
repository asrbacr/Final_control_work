package org.example.ui.menu.command;

import org.example.ui.menu.MainMenu;
import org.example.ui.UI;
import org.example.ui.menu.Menu;
public class ExitMenu implements Command {
    private UI view;
    private Menu menu;
    public ExitMenu(UI view, Menu menu) {
        this.view = view;
        this.menu = menu;
    }

    @Override
    public String getDescription() {
        if (menu.getClass().equals(MainMenu.class)) return "Завершить программу";
        else return "Выйти из меню";
    }

    @Override
    public void exec() {
        menu.unsetActive();
    }
}
