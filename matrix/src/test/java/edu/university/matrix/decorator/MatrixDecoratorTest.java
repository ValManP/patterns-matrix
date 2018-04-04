package edu.university.matrix.decorator;

import edu.university.matrix.IMatrix;
import edu.university.matrix.impl.LowerTriangularMatrix;
import edu.university.matrix.impl.Matrix;
import edu.university.matrix.impl.MinorMatrix;
import edu.university.matrix.impl.TransposeMatrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MatrixDecoratorTest {
    private IMatrix matrix;

    @Before
    public void setUp() {
        int size = 3;
        matrix = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix.setValue(i, j, i * i + j);
            }
        }
    }

    @Test
    public void testTransposeLowerTriangularMinor() {
        // Arrange
        IMatrix m = new TransposeMatrix(matrix);
        m = new LowerTriangularMatrix(m);
        m = new MinorMatrix(m, 0, 2);

        // Act & Assert
        double expected = 2.0;
        Assert.assertEquals(expected, m.getValue(1, 0), 0.001);
    }

    @Test
    public void testTransposeMinor() {
        // Arrange
        IMatrix m = new TransposeMatrix(matrix);
        m = new MinorMatrix(m, 1, 2);

        // Act & Assert
        double expected = 5.0;
        Assert.assertEquals(expected, m.getValue(0, 1), 0.001);
    }

    @Test
    public void testLowerTriangularMinor() {
        // Arrange
        IMatrix m = new LowerTriangularMatrix(matrix);
        m = new MinorMatrix(m, 1, 2);

        // Act & Assert
        double expected = 6.0;
        Assert.assertEquals(expected, m.getValue(1, 1), 0.001);
        Assert.assertEquals(0.0, m.getValue(0, 1), 0.001);
    }

    @Test
    public void testLowerTriangularTranspose() {
        // Arrange
        IMatrix m = new LowerTriangularMatrix(matrix);
        m = new TransposeMatrix(m);

        // Act & Assert
        double expected = 4.0;
        Assert.assertEquals(expected, m.getValue(0, 2), 0.001);
        Assert.assertEquals(0.0, m.getValue(2, 1), 0.001);
    }

    @Test
    public void testMinorLowerTriangular() {
        // Arrange
        IMatrix m = new MinorMatrix(matrix, 0, 2);
        m = new LowerTriangularMatrix(m);

        // Act & Assert
        double expected = 4.0;
        Assert.assertEquals(expected, m.getValue(1, 0), 0.001);
        Assert.assertEquals(0.0, m.getValue(0, 1), 0.001);
    }

    @Test
    public void testUndecorate() {
        // Arrange
        IMatrix m = new TransposeMatrix(matrix);
        m = new LowerTriangularMatrix(m);
        IMatrix save = m;
        m = new MinorMatrix(m, 0, 2);

        // Act & Assert
        double expected = 2.0;
        Assert.assertEquals(expected, save.getValue(2, 0), 0.001);
    }
}
