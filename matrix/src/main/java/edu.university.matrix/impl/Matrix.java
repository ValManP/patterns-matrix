package edu.university.matrix.impl;

import edu.university.matrix.IMatrix;
import edu.university.matrix.errorhandling.MatrixOperationException;

public class Matrix implements IMatrix {
    private int size;
    private double[][] values;

    public Matrix(int n) {
        if (n <= 0) {
            throw new MatrixOperationException("Invalid size of matrix");
        }
        this.values = new double[n][n];
        this.size = n;
    }

    @Override
    public int getN() {
        return size;
    }

    @Override
    public double getValue(int row, int col) {
        if (row >= size || row < 0 || col >= size || col < 0) {
            throw new MatrixOperationException("Invalid row/column index");
        }
        return values[row][col];
    }

    @Override
    public void setValue(int row, int col, double value) {
        if (row >= size || row < 0 || col >= size || col < 0) {
            throw new MatrixOperationException("Invalid row/column index");
        }
        this.values[row][col] = value;
    }

    @Override
    public IMatrix getComponent() {
        return this;
    }
}
