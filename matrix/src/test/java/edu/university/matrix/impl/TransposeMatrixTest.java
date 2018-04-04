package edu.university.matrix.impl;

import edu.university.matrix.IMatrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransposeMatrixTest {
    private IMatrix matrix;

    @Before
    public void setUp() {
        int size = 10;
        matrix = new Matrix(size);
        matrix.setValue(1, 8, 10.0);
    }

    @Test
    public void testGetN() {
        // Arrange
        IMatrix transpose = new TransposeMatrix(matrix);

        // Act & Assert
        int expected = 10;
        Assert.assertEquals(expected, transpose.getN());
    }

    @Test
    public void testGetValue() {
        // Arrange
        IMatrix transpose = new TransposeMatrix(matrix);

        // Act & Assert
        double expected = 10.0;
        Assert.assertEquals(expected, transpose.getValue(8, 1), 0.001);
    }

    @Test
    public void testSetValue() {
        // Arrange
        IMatrix transpose = new TransposeMatrix(matrix);

        // Act
        transpose.setValue(0, 1, 20.0);

        // Assert
        double expected = 20.0;
        Assert.assertEquals(expected, transpose.getValue(0, 1), 0.001);
    }

    @Test
    public void testGetComponent() {
        // Arrange
        IMatrix transpose = new TransposeMatrix(matrix);

        // Act & Assert
        Assert.assertTrue(transpose.getComponent() instanceof Matrix);
    }
}