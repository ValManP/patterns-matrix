package edu.university.matrix.draw.api.impl;

import edu.university.matrix.draw.api.IDrawAPI;

public class GraphicalContextDrawAPI implements IDrawAPI {
    @Override
    public void drawOuterBoundary() {
        System.out.println("Graphical Context API draws outer boundary");
    }

    @Override
    public void drawInnerBoundary() {
        System.out.println("Graphical Context API draws inner boundary");
    }

    @Override
    public void drawElements() {
        System.out.println("Graphical Context API draws elements");
    }

    @Override
    public void drawNonZeroElements() {
        System.out.println("Graphical Context API draws non-zero elements");
    }
}
