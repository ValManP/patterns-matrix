package edu.university.matrix.drawers.impl;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.draw.api.IDrawAPI;
import edu.university.matrix.drawers.AbstractDrawer;

public class SparseMatrixDrawer extends AbstractDrawer {
    public SparseMatrixDrawer(IDrawAPI drawAPI) {
        super(drawAPI);
    }

    @Override
    public void drawMatrix(AbstractMatrix matrix) {
        drawAPI.drawOuterBoundary();
        drawAPI.drawNonZeroElements();
    }
}
