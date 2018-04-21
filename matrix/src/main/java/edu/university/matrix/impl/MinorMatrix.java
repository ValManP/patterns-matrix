package edu.university.matrix.impl;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.drawers.AbstractDrawer;
import edu.university.matrix.errorhandling.MatrixOperationException;

import java.util.Arrays;

public class MinorMatrix extends AbstractMatrix {
    private int[] items;

    public MinorMatrix(AbstractDrawer drawer, AbstractMatrix component, int... rows) {
        super(drawer);

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
    public AbstractMatrix getComponent() {
        return component;
    }
}
