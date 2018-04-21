package edu.university.matrix;

import edu.university.matrix.drawers.AbstractDrawer;

public abstract class AbstractMatrix {
    private AbstractDrawer drawer;
    protected AbstractMatrix component;

    public AbstractMatrix(AbstractDrawer drawer) {
        this.drawer = drawer;
    }

    public abstract int getN();
    public abstract double getValue(int row, int col);
    public abstract void setValue(int row, int col, double value);
    public abstract AbstractMatrix getComponent();

    public void draw() {
        drawer.drawMatrix(this);
    }
}
