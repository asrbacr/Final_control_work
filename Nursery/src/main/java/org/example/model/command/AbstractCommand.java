package org.example.model.command;

class AbstractCommand implements Command {
    private String name;

    public AbstractCommand(String name) {
        this.name = name;
    }

    @Override
    public String exec() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}