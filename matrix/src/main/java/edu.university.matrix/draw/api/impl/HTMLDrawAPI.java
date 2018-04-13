package edu.university.matrix.draw.api.impl;

import edu.university.matrix.draw.api.IDrawAPI;

public class HTMLDrawAPI implements IDrawAPI {
    @Override
    public void drawOuterBoundary() {
        System.out.println("HTML API draws outer boundary");
    }

    @Override
    public void drawInnerBoundary() {
        System.out.println("HTML API draws inner boundary");
    }

    @Override
    public void drawElements() {
        System.out.println("HTML API draws elements");
    }

    @Override
    public void drawNonZeroElements() {
        System.out.println("HTML API draws non-zero elements");
    }
}
