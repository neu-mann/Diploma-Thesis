
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class Maze.
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class MazeIT {

    public MazeIT() {
    }

    /**
     * Test of create method, of class Maze.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        int sizex = 10;
        int sizey = 10;
        float fill = 50.0F;
        Maze instance = new Maze();
        instance.create(sizex, sizey, fill, false);

    }

    /**
     * Test of getArray method, of class Maze.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        int I = 0;
        Maze instance = new Maze();
        instance.create(50, 10, 50, false);
        int[][] result = instance.getArray(I);
        assertNotNull(result);

    }

    /**
     * Test of getList method, of class Maze.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        int I = 0;
        Maze instance = new Maze();
        instance.create(50, 10, 50, false);
        MazeList result = instance.getList(I);
        assertNotNull(result);
    }

}
