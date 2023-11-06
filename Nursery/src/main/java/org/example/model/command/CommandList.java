package org.example.model.command;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class CommandList {
    private static CommandList instance;
    private final HashMap<String, Command> commands;

    private CommandList() {
        commands = new HashMap<>();
        commands.put("bray", new Bray());
        commands.put("canter", new Canter());
        commands.put("carryload", new CarryLoad());
        commands.put("fetch", new Fetch());
        commands.put("gallop", new Gallop());
        commands.put("hide", new Hide());
        commands.put("jump", new Jump());
        commands.put("kick", new Kick());
        commands.put("paw", new Paw());
        commands.put("pounce", new Pounce());
        commands.put("roll", new Roll());
        commands.put("run", new Run());
        commands.put("scratch", new Scratch());
        commands.put("sit", new Sit());
        commands.put("spin", new Spin());
        commands.put("stay", new Stay());
        commands.put("trot", new Trot());
        commands.put("voice", new Voice());
        commands.put("walk", new Walk());
    }

    public static CommandList getInstance() {
        if (instance == null) {
            instance = new CommandList();
        }
        return instance;
    }

    public Collection<Command> listAvailableCommands() {
        return commands.values();
    }
    public Set<String> listAvailableCommandsNames() {
        return commands.keySet();
    }
    public Command getCommand(String name) {
        return commands.get(name.toLowerCase());
    }
}
