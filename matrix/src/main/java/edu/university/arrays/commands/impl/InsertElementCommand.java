package edu.university.arrays.commands.impl;

import edu.university.arrays.ArrayManager;
import edu.university.arrays.commands.Command;

public class InsertElementCommand extends Command {
    private double value;
    private int position;

    public InsertElementCommand(ArrayManager manager, int position, double value) {
        super(manager);
        this.value = value;
        this.position = position;
    }

    @Override
    public boolean execute() {
        manager.getArray().add(position, value);
        return true;
    }

    @Override
    public void undo() {
        manager.getArray().remove(position);
    }
}
