package edu.university.matrix.impl;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.drawers.AbstractDrawer;
import edu.university.matrix.errorhandling.MatrixOperationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LowerTriangularMatrixTest {
    private AbstractMatrix matrix;
    private AbstractDrawer drawer;

    @Before
    public void setUp() {
        int size = 10;
        matrix = new Matrix(size, drawer);
        matrix.setValue(2, 1, 10.0);
    }

    @Test
    public void testGetN() {
        // Arrange
        AbstractMatrix lowerTriangular = new LowerTriangularMatrix(matrix, drawer);

        // Act & Assert
        int expected = 10;
        Assert.assertEquals(expected, lowerTriangular.getN());
    }

    @Test
    public void testGetUpperValue() {
        // Arrange
        AbstractMatrix lowerTriangular = new LowerTriangularMatrix(matrix, drawer);

        // Act & Assert
        double expected = 0.0;
        Assert.assertEquals(expected, lowerTriangular.getValue(1, 3), 0.001);
    }

    @Test
    public void testGetLowerValue() {
        // Arrange
        AbstractMatrix lowerTriangular = new LowerTriangularMatrix(matrix, drawer);

        // Act & Assert
        double expected = 10.0;
        Assert.assertEquals(expected, lowerTriangular.getValue(2, 1), 0.001);
    }

    @Test
    public void testSetValue() {
        // Arrange
        AbstractMatrix lowerTriangular = new LowerTriangularMatrix(matrix, drawer);

        // Act
        lowerTriangular.setValue(1, 1, 20.0);

        // Assert
        double expected = 20.0;
        Assert.assertEquals(expected, lowerTriangular.getValue(1, 1), 0.001);
    }

    @Test
    public void testGetComponent() {
        // Arrange
        AbstractMatrix lowerTriangular = new LowerTriangularMatrix(matrix, drawer);

        // Act & Assert
        Assert.assertTrue(lowerTriangular.getComponent() instanceof Matrix);
    }

    @Test(expected = MatrixOperationException.class)
    public void testSetInUpperTriangular() {
        // Arrange
        AbstractMatrix lowerTriangular = new LowerTriangularMatrix(matrix, drawer);

        // Act & Assert
        lowerTriangular.setValue(0, 1, 10.0);
    }
}