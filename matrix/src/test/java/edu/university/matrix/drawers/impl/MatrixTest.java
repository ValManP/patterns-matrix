package edu.university.matrix.drawers.impl;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.drawers.AbstractDrawer;
import edu.university.matrix.impl.Matrix;
import edu.university.matrix.errorhandling.MatrixOperationException;
import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {
    private AbstractDrawer drawer;

    @Test
    public void testCreate() {
        // Arrange
        int n = 10;
        AbstractMatrix matrix = new Matrix(n, drawer);

        // Act & Assert
        Assert.assertNotNull(matrix);
    }

    @Test
    public void testGetN() {
        // Arrange
        int n = 10;
        AbstractMatrix matrix = new Matrix(n, drawer);

        // Act & Assert
        Assert.assertEquals(n, matrix.getN());
    }

    @Test
    public void testSetAndGetValue() {
        // Arrange
        int n = 10;
        AbstractMatrix matrix = new Matrix(n, drawer);
        matrix.setValue(1, 1, 10.0);

        // Act & Assert
        double expected = 10.0;
        Assert.assertEquals(expected, matrix.getValue(1, 1), 0.001);
    }

    @Test(expected = MatrixOperationException.class)
    public void testSetToInvalidIndex() {
        // Arrange
        int n = 10;
        AbstractMatrix matrix = new Matrix(n, drawer);
        matrix.setValue(-1, 1, 10.0);
    }

    @Test(expected = MatrixOperationException.class)
    public void testGetToInvalidIndex() {
        // Arrange
        int n = 10;
        AbstractMatrix matrix = new Matrix(n, drawer);
        matrix.getValue(-1, 1);
    }

    @Test
    public void testEmptyComponent() {
        // Arrange
        int n = 10;
        AbstractMatrix minor = new Matrix(n, drawer);

        // Act & Assert
        Assert.assertTrue(minor.getComponent() instanceof Matrix);
    }

    @Test(expected = MatrixOperationException.class)
    public void testInvalidSize() {
        // Arrange
        int n = -10;
        AbstractMatrix matrix = new Matrix(n, drawer);
    }
}