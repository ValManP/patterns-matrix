package edu.university.matrix.draw.api.impl;

import edu.university.matrix.draw.api.IDrawAPI;

public class ConsoleDrawAPI implements IDrawAPI {
    @Override
    public void drawOuterBoundary() {
        System.out.println("Console API draws outer boundary");
    }

    @Override
    public void drawInnerBoundary() {
        System.out.println("Console API draws inner boundary");
    }

    @Override
    public void drawElements() {
        System.out.println("Console API draws elements");
    }

    @Override
    public void drawNonZeroElements() {
        System.out.println("Console API draws non-zero elements");
    }
}
