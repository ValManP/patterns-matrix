package edu.university.arrays.commands.impl;

import edu.university.arrays.commands.Command;

import java.util.List;

public class DeleteElementCommand implements Command {
    List<Double> array;
    private int position;
    private double value;

    public DeleteElementCommand(List<Double> array, int position) {
        this.array = array;
        this.position = position;
    }

    @Override
    public boolean execute() {
        this.value = array.get(position);
        array.remove(position);
        return true;
    }

    @Override
    public void undo() {
        array.add(position, value);
    }
}
