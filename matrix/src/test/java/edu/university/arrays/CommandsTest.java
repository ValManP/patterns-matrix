package edu.university.arrays;

import edu.university.arrays.commands.Command;
import edu.university.arrays.commands.impl.DeleteElementCommand;
import edu.university.arrays.commands.impl.InsertElementCommand;
import edu.university.arrays.commands.impl.SetElementCommand;
import edu.university.arrays.commands.impl.UndoCommand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandsTest {
    private ArrayManager manager;

    @Before
    public void setUp() throws Exception {
        manager = new ArrayManager();
    }

    @Test
    public void testInsertCommand() {
        // Arrange
        Command insertCommand = new InsertElementCommand(manager, 0, 3.2);

        // Act
        manager.executeCommand(insertCommand);

        // Assert
        double expected = 3.2;
        Assert.assertEquals(expected, manager.getArray().get(0), 0.001);
    }

    @Test
    public void testDeleteCommand() {
        // Arrange
        manager.executeCommand(new InsertElementCommand(manager, 0, 3.2));
        manager.executeCommand(new InsertElementCommand(manager, 1, 2.3));

        Command deleteCommand = new DeleteElementCommand(manager, 0);

        // Act
        manager.executeCommand(deleteCommand);

        // Assert
        double expected = 2.3;
        Assert.assertEquals(expected, manager.getArray().get(0), 0.001);
    }

    @Test
    public void testSetCommand() {
        // Arrange
        manager.executeCommand(new InsertElementCommand(manager, 0, 3.2));
        manager.executeCommand(new InsertElementCommand(manager, 1, 2.3));

        Command setCommand = new SetElementCommand(manager, 0, 6.2);

        // Act
        manager.executeCommand(setCommand);

        // Assert
        double expected = 6.2;
        Assert.assertEquals(expected, manager.getArray().get(0), 0.001);
    }

    @Test
    public void testSetAndUndoCommand() {
        // Arrange
        manager.executeCommand(new InsertElementCommand(manager, 0, 3.2));
        manager.executeCommand(new InsertElementCommand(manager, 1, 2.3));
        manager.executeCommand(new SetElementCommand(manager, 0, 6.2));

        // Act
        manager.executeCommand(new UndoCommand(manager));

        // Assert
        double expected = 3.2;
        Assert.assertEquals(expected, manager.getArray().get(0), 0.001);
    }

    @Test
    public void testInsertAndUndoCommand() {
        // Arrange
        manager.executeCommand(new InsertElementCommand(manager, 0, 3.2));
        manager.executeCommand(new InsertElementCommand(manager, 1, 2.3));

        // Act
        manager.executeCommand(new UndoCommand(manager));

        // Assert
        int expectedSize = 1;
        Assert.assertEquals(expectedSize, manager.getArray().size());
    }

    @Test
    public void testDeleteAndUndoCommand() {
        // Arrange
        manager.executeCommand(new InsertElementCommand(manager, 0, 3.2));
        manager.executeCommand(new InsertElementCommand(manager, 1, 2.3));
        manager.executeCommand(new DeleteElementCommand(manager, 0));

        // Act
        manager.executeCommand(new UndoCommand(manager));

        // Assert
        int expectedSize = 2;
        Assert.assertEquals(expectedSize, manager.getArray().size());
    }

    @Test
    public void testTwoUndoCommand() {
        // Arrange
        manager.executeCommand(new InsertElementCommand(manager, 0, 3.2));
        manager.executeCommand(new DeleteElementCommand(manager, 0));
        manager.executeCommand(new InsertElementCommand(manager, 0, 2.3));

        // Act
        manager.executeCommand(new UndoCommand(manager));
        manager.executeCommand(new UndoCommand(manager));

        // Assert
        double expected = 3.2;
        Assert.assertEquals(expected, manager.getArray().get(0), 0.001);
    }
}
