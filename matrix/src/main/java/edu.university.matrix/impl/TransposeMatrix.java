package edu.university.matrix.impl;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.drawers.AbstractDrawer;

public class TransposeMatrix extends AbstractMatrix {
    public TransposeMatrix(AbstractMatrix component, AbstractDrawer drawer) {
        super(drawer);
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
    public AbstractMatrix getComponent() {
        return component;
    }
}
