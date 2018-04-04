package edu.university.matrix.impl;

import edu.university.matrix.IMatrix;
import edu.university.matrix.errorhandling.MatrixOperationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LowerTriangularMatrixTest {
    private IMatrix matrix;

    @Before
    public void setUp() {
        int size = 10;
        matrix = new Matrix(size);
        matrix.setValue(2, 1, 10.0);
    }

    @Test
    public void testGetN() {
        // Arrange
        IMatrix lowerTriangular = new LowerTriangularMatrix(matrix);

        // Act & Assert
        int expected = 10;
        Assert.assertEquals(expected, lowerTriangular.getN());
    }

    @Test
    public void testGetUpperValue() {
        // Arrange
        IMatrix lowerTriangular = new LowerTriangularMatrix(matrix);

        // Act & Assert
        double expected = 0.0;
        Assert.assertEquals(expected, lowerTriangular.getValue(1, 3), 0.001);
    }

    @Test
    public void testGetLowerValue() {
        // Arrange
        IMatrix lowerTriangular = new LowerTriangularMatrix(matrix);

        // Act & Assert
        double expected = 10.0;
        Assert.assertEquals(expected, lowerTriangular.getValue(2, 1), 0.001);
    }

    @Test
    public void testSetValue() {
        // Arrange
        IMatrix lowerTriangular = new LowerTriangularMatrix(matrix);

        // Act
        lowerTriangular.setValue(1, 1, 20.0);

        // Assert
        double expected = 20.0;
        Assert.assertEquals(expected, lowerTriangular.getValue(1, 1), 0.001);
    }

    @Test
    public void testGetComponent() {
        // Arrange
        IMatrix lowerTriangular = new LowerTriangularMatrix(matrix);

        // Act & Assert
        Assert.assertTrue(lowerTriangular.getComponent() instanceof Matrix);
    }

    @Test(expected = MatrixOperationException.class)
    public void testSetInUpperTriangular() {
        // Arrange
        IMatrix lowerTriangular = new LowerTriangularMatrix(matrix);

        // Act & Assert
        lowerTriangular.setValue(0, 1, 10.0);
    }
}