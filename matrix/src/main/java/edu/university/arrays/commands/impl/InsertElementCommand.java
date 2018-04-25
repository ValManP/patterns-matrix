package edu.university.arrays.commands.impl;

import edu.university.arrays.CommandManager;
import edu.university.arrays.commands.Command;

import java.util.List;

public class InsertElementCommand implements Command {
    private List<Double> array;
    private double value;
    private int position;

    public InsertElementCommand(List<Double> array, int position, double value) {
        this.array = array;
        this.value = value;
        this.position = position;
    }

    @Override
    public boolean execute() {
        array.add(position, value);
        return true;
    }

    @Override
    public void undo() {
        array.remove(position);
    }
}
