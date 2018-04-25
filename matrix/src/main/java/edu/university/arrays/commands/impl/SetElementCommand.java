package edu.university.arrays.commands.impl;

import edu.university.arrays.commands.Command;

import java.util.List;

public class SetElementCommand implements Command {
    private List<Double> array;
    private int position;
    private double value;
    private double oldValue;

    public SetElementCommand(List<Double> array, int position, double value) {
        this.array = array;
        this.position = position;
        this.value = value;
    }

    @Override
    public boolean execute() {
        oldValue = array.get(position);
        array.set(position, value);
        return true;
    }

    @Override
    public void undo() {
        array.set(position, oldValue);
    }
}
