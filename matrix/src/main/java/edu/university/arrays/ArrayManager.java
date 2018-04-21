package edu.university.arrays;

import edu.university.arrays.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayManager {
    private List<Double> array;
    private Stack<Command> commandsHistory;

    public ArrayManager() {
        array = new ArrayList<>();
        commandsHistory = new Stack<>();
    }

    public void executeCommand(Command command) {
        if (command.execute()) {
            commandsHistory.push(command);
        }
    }

    public void undo() {
        Command command = commandsHistory.pop();
        if (command != null) {
            command.undo();
        }
    }

    public List<Double> getArray() {
        return array;
    }
}
