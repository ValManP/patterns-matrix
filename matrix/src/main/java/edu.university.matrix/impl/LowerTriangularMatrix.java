package edu.university.matrix.impl;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.drawers.AbstractDrawer;
import edu.university.matrix.errorhandling.MatrixOperationException;

public class LowerTriangularMatrix extends AbstractMatrix {
    public LowerTriangularMatrix(AbstractMatrix component, AbstractDrawer drawer) {
        super(drawer);
        this.component = component;
    }

    @Override
    public int getN() {
        return component.getN();
    }

    @Override
    public double getValue(int row, int col) {
        if (row < col) {
            return 0;
        }
        return component.getValue(row, col);
    }

    @Override
    public void setValue(int row, int col, double value) {
        if (row >= col) {
            component.setValue(row, col, value);
        } else {
            throw new MatrixOperationException("Set is available only for lower triangular part");
        }
    }

    @Override
    public AbstractMatrix getComponent() {
        return component;
    }
}
