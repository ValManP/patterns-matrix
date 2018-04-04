package edu.university.matrix.impl;

import edu.university.matrix.IMatrix;
import edu.university.matrix.errorhandling.MatrixOperationException;

public class LowerTriangularMatrix implements IMatrix {
    private IMatrix component;

    public LowerTriangularMatrix(IMatrix component) {
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
    public IMatrix getComponent() {
        return component;
    }
}
