package edu.university.arrays;

import edu.university.arrays.commands.Command;
import edu.university.arrays.commands.impl.DeleteElementCommand;
import edu.university.arrays.commands.impl.InsertElementCommand;
import edu.university.arrays.commands.impl.SetElementCommand;
import edu.university.arrays.commands.impl.UndoCommand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CommandsTest {
    @Test
    public void testInsertCommand() {
        // Arrange
        List<Double> array = new ArrayList<>();
        Command insertCommand = new InsertElementCommand(array, 0, 3.2);

        // Act
        CommandManager.getInstance().executeCommand(insertCommand);

        // Assert
        double expected = 3.2;
        Assert.assertEquals(expected, array.get(0), 0.001);
    }

    @Test
    public void testDeleteCommand() {
        // Arrange
        List<Double> array = new ArrayList<>();
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 0, 3.2));
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 1, 2.3));

        Command deleteCommand = new DeleteElementCommand(array, 0);

        // Act
        CommandManager.getInstance().executeCommand(deleteCommand);

        // Assert
        double expected = 2.3;
        Assert.assertEquals(expected, array.get(0), 0.001);
    }

    @Test
    public void testSetCommand() {
        // Arrange
        List<Double> array = new ArrayList<>();
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 0, 3.2));
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 1, 2.3));

        Command setCommand = new SetElementCommand(array, 0, 6.2);

        // Act
        CommandManager.getInstance().executeCommand(setCommand);

        // Assert
        double expected = 6.2;
        Assert.assertEquals(expected, array.get(0), 0.001);
    }

    @Test
    public void testSetAndUndoCommand() {
        // Arrange
        List<Double> array = new ArrayList<>();
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 0, 3.2));
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 1, 2.3));
        CommandManager.getInstance().executeCommand(new SetElementCommand(array, 0, 6.2));

        // Act
        CommandManager.getInstance().executeCommand(new UndoCommand());

        // Assert
        double expected = 3.2;
        Assert.assertEquals(expected, array.get(0), 0.001);
    }

    @Test
    public void testInsertAndUndoCommand() {
        // Arrange
        List<Double> array = new ArrayList<>();
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 0, 3.2));
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 1, 2.3));

        // Act
        CommandManager.getInstance().executeCommand(new UndoCommand());

        // Assert
        int expectedSize = 1;
        Assert.assertEquals(expectedSize, array.size());
    }

    @Test
    public void testDeleteAndUndoCommand() {
        // Arrange
        List<Double> array = new ArrayList<>();
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 0, 3.2));
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 1, 2.3));
        CommandManager.getInstance().executeCommand(new DeleteElementCommand(array, 0));

        // Act
        CommandManager.getInstance().executeCommand(new UndoCommand());

        // Assert
        int expectedSize = 2;
        Assert.assertEquals(expectedSize, array.size());
    }

    @Test
    public void testTwoUndoCommand() {
        // Arrange
        List<Double> array = new ArrayList<>();
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 0, 3.2));
        CommandManager.getInstance().executeCommand(new DeleteElementCommand(array, 0));
        CommandManager.getInstance().executeCommand(new InsertElementCommand(array, 0, 2.3));

        // Act
        CommandManager.getInstance().executeCommand(new UndoCommand());
        CommandManager.getInstance().executeCommand(new UndoCommand());

        // Assert
        double expected = 3.2;
        Assert.assertEquals(expected, array.get(0), 0.001);
    }
}
