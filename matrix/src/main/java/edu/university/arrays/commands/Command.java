package edu.university.arrays.commands;

import edu.university.arrays.ArrayManager;

public abstract class Command {
    protected ArrayManager manager;

    public Command(ArrayManager manager) {
        this.manager = manager;
    }

    public abstract boolean execute();
    public void undo() {};
}
