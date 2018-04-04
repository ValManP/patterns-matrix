package edu.university.matrix;

public interface IMatrix {
    int getN();
    double getValue(int row, int col);
    void setValue(int row, int col, double value);
    IMatrix getComponent();
}
