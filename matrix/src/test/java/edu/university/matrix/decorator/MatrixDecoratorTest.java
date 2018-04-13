package edu.university.matrix.decorator;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.drawers.AbstractDrawer;
import edu.university.matrix.impl.LowerTriangularMatrix;
import edu.university.matrix.impl.Matrix;
import edu.university.matrix.impl.MinorMatrix;
import edu.university.matrix.impl.TransposeMatrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MatrixDecoratorTest {
    private AbstractMatrix matrix;
    private AbstractDrawer drawer;

    @Before
    public void setUp() {
        int size = 3;
        matrix = new Matrix(size, drawer);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix.setValue(i, j, i * i + j);
            }
        }
    }

    @Test
    public void testTransposeLowerTriangularMinor() {
        // Arrange
        AbstractMatrix m = new TransposeMatrix(matrix, drawer);
        m = new LowerTriangularMatrix(m, drawer);
        m = new MinorMatrix(drawer, m, 0, 2);

        // Act & Assert
        double expected = 2.0;
        Assert.assertEquals(expected, m.getValue(1, 0), 0.001);
    }

    @Test
    public void testTransposeMinor() {
        // Arrange
        AbstractMatrix m = new TransposeMatrix(matrix, drawer);
        m = new MinorMatrix(drawer, m, 1, 2);

        // Act & Assert
        double expected = 5.0;
        Assert.assertEquals(expected, m.getValue(0, 1), 0.001);
    }

    @Test
    public void testLowerTriangularMinor() {
        // Arrange
        AbstractMatrix m = new LowerTriangularMatrix(matrix, drawer);
        m = new MinorMatrix(drawer, m, 1, 2);

        // Act & Assert
        double expected = 6.0;
        Assert.assertEquals(expected, m.getValue(1, 1), 0.001);
        Assert.assertEquals(0.0, m.getValue(0, 1), 0.001);
    }

    @Test
    public void testLowerTriangularTranspose() {
        // Arrange
        AbstractMatrix m = new LowerTriangularMatrix(matrix, drawer);
        m = new TransposeMatrix(m, drawer);

        // Act & Assert
        double expected = 4.0;
        Assert.assertEquals(expected, m.getValue(0, 2), 0.001);
        Assert.assertEquals(0.0, m.getValue(2, 1), 0.001);
    }

    @Test
    public void testMinorLowerTriangular() {
        // Arrange
        AbstractMatrix m = new MinorMatrix(drawer, matrix, 0, 2);
        m = new LowerTriangularMatrix(m, drawer);

        // Act & Assert
        double expected = 4.0;
        Assert.assertEquals(expected, m.getValue(1, 0), 0.001);
        Assert.assertEquals(0.0, m.getValue(0, 1), 0.001);
    }

    @Test
    public void testUndecorate() {
        // Arrange
        AbstractMatrix m = new TransposeMatrix(matrix, drawer);
        m = new LowerTriangularMatrix(m, drawer);
        AbstractMatrix save = m;
        m = new MinorMatrix(drawer, m, 0, 2);

        // Act & Assert
        double expected = 2.0;
        Assert.assertEquals(expected, save.getValue(2, 0), 0.001);
    }
}
