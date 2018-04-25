package edu.university.arrays.commands.impl;

import edu.university.arrays.CommandManager;
import edu.university.arrays.commands.Command;

public class UndoCommand implements Command {
    @Override
    public boolean execute() {
        CommandManager.getInstance().undo();
        return false;
    }

    @Override
    public void undo() {

    }
}
