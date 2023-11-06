package org.example;

import org.example.ui.Console;
import org.example.ui.UI;

public class Main {
    public static void main(String[] args) {
        UI view = new Console();
        view.start();
    }
}