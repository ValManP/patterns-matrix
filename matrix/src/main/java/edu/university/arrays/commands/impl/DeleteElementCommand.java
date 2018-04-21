package edu.university.arrays.commands.impl;

import edu.university.arrays.ArrayManager;
import edu.university.arrays.commands.Command;

public class DeleteElementCommand extends Command {
    private int position;
    private double value;

    public DeleteElementCommand(ArrayManager manager, int position) {
        super(manager);
        this.position = position;
    }

    @Override
    public boolean execute() {
        this.value = manager.getArray().get(position);
        manager.getArray().remove(position);
        return true;
    }

    @Override
    public void undo() {
        manager.getArray().add(position, value);
    }
}
