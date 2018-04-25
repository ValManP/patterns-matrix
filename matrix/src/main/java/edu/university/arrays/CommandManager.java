package edu.university.arrays;

import edu.university.arrays.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandManager {
    private static CommandManager instance;
    private Stack<Command> commandsHistory;

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    private CommandManager() {
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
}
