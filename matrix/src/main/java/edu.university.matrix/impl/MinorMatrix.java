package edu.university.matrix.impl;

import edu.university.matrix.IMatrix;
import edu.university.matrix.errorhandling.MatrixOperationException;

import java.util.Arrays;

public class MinorMatrix implements IMatrix {
    private IMatrix component;
    private int[] items;

    public MinorMatrix(IMatrix component, int... rows) {
        this.items = new int[rows.length];
        for (int i = 0; i < rows.length; i++) {
            items[i] = rows[i];
        }

        Arrays.sort(items);

        this.component = component;
    }

    @Override
    public int getN() {
        return items.length;
    }

    @Override
    public double getValue(int row, int col) {
        if (row < 0 || row >= items.length || col < 0 || col >= items.length) {
            throw new MatrixOperationException("Invalid row/column index");
        }
        return component.getValue(items[row], items[col]);
    }

    @Override
    public void setValue(int row, int col, double value) {
        if (row < 0 || row >= items.length || col < 0 || col >= items.length) {
            throw new MatrixOperationException("Invalid row/column index");
        }
        component.setValue(items[row], items[col], value);
    }

    @Override
    public IMatrix getComponent() {
        return component;
    }
}
