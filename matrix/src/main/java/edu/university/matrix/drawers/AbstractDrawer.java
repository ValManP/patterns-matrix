package edu.university.matrix.drawers;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.draw.api.IDrawAPI;

public abstract class AbstractDrawer {
    protected IDrawAPI drawAPI;

    public AbstractDrawer(IDrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void drawMatrix(AbstractMatrix matrix);
}
