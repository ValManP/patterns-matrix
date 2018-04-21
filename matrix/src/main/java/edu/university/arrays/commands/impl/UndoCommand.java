package edu.university.arrays.commands.impl;

import edu.university.arrays.ArrayManager;
import edu.university.arrays.commands.Command;

public class UndoCommand extends Command {
    public UndoCommand(ArrayManager manager) {
        super(manager);
    }

    @Override
    public boolean execute() {
        manager.undo();
        return false;
    }
}
