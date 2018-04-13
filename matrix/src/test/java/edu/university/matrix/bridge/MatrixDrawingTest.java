package edu.university.matrix.bridge;

import edu.university.matrix.AbstractMatrix;
import edu.university.matrix.draw.api.IDrawAPI;
import edu.university.matrix.draw.api.impl.ConsoleDrawAPI;
import edu.university.matrix.draw.api.impl.GraphicalContextDrawAPI;
import edu.university.matrix.draw.api.impl.HTMLDrawAPI;
import edu.university.matrix.drawers.AbstractDrawer;
import edu.university.matrix.drawers.impl.MatrixDrawer;
import edu.university.matrix.impl.Matrix;
import org.junit.Assert;
import org.junit.Test;

public class MatrixDrawingTest {
    private AbstractMatrix matrix;

    @Test
    public void testDrawMatrixInConsole() {
        // Arrange
        int n = 10;
        IDrawAPI drawAPI = new ConsoleDrawAPI();
        AbstractDrawer drawer = new MatrixDrawer(drawAPI);
        AbstractMatrix matrix = new Matrix(n, drawer);

        // Act
        matrix.draw();

        // Assert
        Assert.assertNotNull(matrix);
    }

    @Test
    public void testDrawMatrixInGraphicalContext() {
        // Arrange
        int n = 10;
        IDrawAPI drawAPI = new GraphicalContextDrawAPI();
        AbstractDrawer drawer = new MatrixDrawer(drawAPI);
        AbstractMatrix matrix = new Matrix(n, drawer);

        // Act
        matrix.draw();

        // Assert
        Assert.assertNotNull(matrix);
    }

    @Test
    public void testDrawMatrixInHTML() {
        // Arrange
        int n = 10;
        IDrawAPI drawAPI = new HTMLDrawAPI();
        AbstractDrawer drawer = new MatrixDrawer(drawAPI);
        AbstractMatrix matrix = new Matrix(n, drawer);

        // Act
        matrix.draw();

        // Assert
        Assert.assertNotNull(matrix);
    }
}
