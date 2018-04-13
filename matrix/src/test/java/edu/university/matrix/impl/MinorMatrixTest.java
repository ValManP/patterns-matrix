package edu.university.matrix.impl;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.drawers.AbstractDrawer;
import edu.university.matrix.errorhandling.MatrixOperationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinorMatrixTest {
    private AbstractMatrix matrix;
    private AbstractDrawer drawer;

    @Before
    public void setUp() {
        int size = 10;
        matrix = new Matrix(size, drawer);
        matrix.setValue(1, 8, 10.0);
    }

    @Test
    public void testGetN() {
        // Arrange
        AbstractMatrix minor = new MinorMatrix(drawer, matrix, 1, 3, 8);

        // Act & Assert
        int expected = 3;
        Assert.assertEquals(expected, minor.getN());
    }

    @Test
    public void testGetValue() {
        // Arrange
        AbstractMatrix minor = new MinorMatrix(drawer, matrix, 1, 3, 8);

        // Act & Assert
        double expected = 10.0;
        Assert.assertEquals(expected, minor.getValue(0, 2), 0.001);
    }

    @Test
    public void testSetValue() {
        // Arrange
        AbstractMatrix minor = new MinorMatrix(drawer, matrix, 1, 3, 8);

        // Act
        minor.setValue(0, 1, 20.0);

        // Assert
        double expected = 20.0;
        Assert.assertEquals(expected, minor.getValue(0, 1), 0.001);
    }

    @Test
    public void testGetComponent() {
        // Arrange
        AbstractMatrix minor = new MinorMatrix(drawer, matrix, 1, 3, 8);

        // Act & Assert
        Assert.assertTrue(minor.getComponent() instanceof Matrix);
    }

    @Test
    public void testEmptyMinor() {
        // Arrange
        AbstractMatrix minor = new MinorMatrix(drawer, matrix);

        // Act & Assert
        Assert.assertTrue(minor.getComponent() instanceof Matrix);
    }

    @Test
    public void testUnsortedRows() {
        // Arrange
        AbstractMatrix minor = new MinorMatrix(drawer, matrix, 3, 1, 8);

        // Act
        minor.setValue(0, 1, 20.0);

        // Assert
        double expected = 20.0;
        Assert.assertEquals(expected, minor.getValue(0, 1), 0.001);
    }

    @Test(expected = MatrixOperationException.class)
    public void testGetByInvalidIndex() {
        // Arrange
        AbstractMatrix minor = new MinorMatrix(drawer, matrix, 1, 3, 8);

        minor.getValue(0, 3);
    }

    @Test(expected = MatrixOperationException.class)
    public void testSetByInvalidIndex() {
        // Arrange
        AbstractMatrix minor = new MinorMatrix(drawer, matrix, 1, 3, 8);

        // Act
        minor.setValue(3, -1, 20.0);
    }
}