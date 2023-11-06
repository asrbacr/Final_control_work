package org.example.model.animal;

import org.example.model.command.Command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.example.model.NurseryService.numberInRange;

public abstract class Animal {
    private String name;
    private final Calendar birthDate;
    private List<Command> commands;
    private final short max_commands;
    private final byte learn_probability;

    public Animal(String name, Calendar bdate) {
        this(name, bdate, (short) 0, (byte)0, null);
    }

    public Animal(String name, Calendar bdate, short max_commands, byte learn_probability) {
        this(name, bdate, max_commands, learn_probability,null);
    }

    public Animal(String name, Calendar bdate, short max_commands, byte learn_probability, List<Command> commands) {
        this.name = name;
        this.birthDate = bdate;
        this.max_commands = max_commands;
        this.learn_probability = learn_probability;
        if (commands == null) commands = new ArrayList<>();
        this.commands = commands;
    }

    /**
     * Try to learn Command
     * By default animals can not learn
     * @param command to learn
     * @return learning result
     */
    public boolean learn(Command command) {
        if (commands != null && commands.size() < max_commands && !commands.contains(command) && numberInRange(0, 100) <= learn_probability) {
            commands.add(command);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public short getMax_commands() {
        return max_commands;
    }

    public byte getLearn_probability() {
        return learn_probability;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return name + " : " + df.format(birthDate.getTime()) +
                " : " + commands;
    }
}