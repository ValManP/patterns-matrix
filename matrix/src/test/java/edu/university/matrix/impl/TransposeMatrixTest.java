package edu.university.matrix.impl;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.drawers.AbstractDrawer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransposeMatrixTest {
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
        AbstractMatrix transpose = new TransposeMatrix(matrix, drawer);

        // Act & Assert
        int expected = 10;
        Assert.assertEquals(expected, transpose.getN());
    }

    @Test
    public void testGetValue() {
        // Arrange
        AbstractMatrix transpose = new TransposeMatrix(matrix, drawer);

        // Act & Assert
        double expected = 10.0;
        Assert.assertEquals(expected, transpose.getValue(8, 1), 0.001);
    }

    @Test
    public void testSetValue() {
        // Arrange
        AbstractMatrix transpose = new TransposeMatrix(matrix, drawer);

        // Act
        transpose.setValue(0, 1, 20.0);

        // Assert
        double expected = 20.0;
        Assert.assertEquals(expected, transpose.getValue(0, 1), 0.001);
    }

    @Test
    public void testGetComponent() {
        // Arrange
        AbstractMatrix transpose = new TransposeMatrix(matrix, drawer);

        // Act & Assert
        Assert.assertTrue(transpose.getComponent() instanceof Matrix);
    }
}