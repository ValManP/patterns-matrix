package edu.university.arrays.commands.impl;

import edu.university.arrays.ArrayManager;
import edu.university.arrays.commands.Command;

public class SetElementCommand extends Command {
    private int position;
    private double value;
    private double oldValue;

    public SetElementCommand(ArrayManager manager, int position, double value) {
        super(manager);
        this.position = position;
        this.value = value;
    }

    @Override
    public boolean execute() {
        oldValue = manager.getArray().get(position);
        manager.getArray().set(position, value);
        return true;
    }

    @Override
    public void undo() {
        manager.getArray().set(position, oldValue);
    }
}
