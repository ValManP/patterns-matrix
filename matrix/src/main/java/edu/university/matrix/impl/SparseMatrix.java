package edu.university.matrix.impl;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.drawers.AbstractDrawer;
import edu.university.matrix.errorhandling.MatrixOperationException;

import java.util.ArrayList;
import java.util.List;

public class SparseMatrix extends AbstractMatrix {
    private int size;
    private List<Integer> rows;
    private List<Integer> columns;
    private List<Double> values;

    public SparseMatrix(int n, AbstractDrawer drawer) {
        super(drawer);

        if (n <= 0) {
            throw new MatrixOperationException("Invalid size of matrix");
        }
        this.size = n;
        rows = new ArrayList<>();
        columns = new ArrayList<>();
        values = new ArrayList<>();
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
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i) == row && columns.get(i) == col) {
                return values.get(i);
            }
        }
        return 0;
    }

    @Override
    public void setValue(int row, int col, double value) {
        if (row >= size || row < 0 || col >= size || col < 0) {
            throw new MatrixOperationException("Invalid row/column index");
        }
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i) == row && columns.get(i) == col) {
                values.set(i, value);
                return;
            }
        }
        rows.add(row);
        columns.add(col);
        values.add(value);
    }

    @Override
    public AbstractMatrix getComponent() {
        return this;
    }
}
