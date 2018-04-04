package edu.university.matrix.impl;

import edu.university.matrix.IMatrix;

public class TransposeMatrix implements IMatrix {
    private IMatrix component;

    public TransposeMatrix(IMatrix component) {
        this.component = component;
    }

    @Override
    public int getN() {
        return component.getN();
    }

    @Override
    public double getValue(int row, int col) {
        return component.getValue(col, row);
    }

    @Override
    public void setValue(int row, int col, double value) {
        component.setValue(col, row, value);
    }

    @Override
    public IMatrix getComponent() {
        return component;
    }
}
