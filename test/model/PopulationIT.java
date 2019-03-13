
package model;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class Population.
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class PopulationIT {

    public PopulationIT() {
    }

    /**
     * Test of Generate method, of class Population.
     */
    @Test
    public void testGenerate() {
        System.out.println("Generate");
        int nbr = 0;
        int sizeX = 0;
        int sizeY = 0;
        Population instance = new Population();
        instance.Generate(nbr, sizeX, sizeY);
    }

    /**
     * Test of getPopulation method, of class Population.
     */
    @Test
    public void testGetPopulation() {
        System.out.println("getPopulation");
        Population instance = new Population();
        instance.Generate(1, 100, 100);
        LinkedList<MazeList> result = instance.getPopulation();
        assertNotNull(result);
    }

    /**
     * Test of getSize method, of class Population.
     */
    @Test
    public void testGetSize_0args() {
        System.out.println("getSize");
        Population instance = new Population();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of Remove method, of class Population.
     */
    @Test
    public void testRemove() {
        System.out.println("Remove");
        int I = 0;
        Population instance = new Population();
        instance.Generate(4, 100, 100);
        LinkedList<MazeList> result = instance.getPopulation();
        instance.Remove(2);
    }

    /**
     * Test of add method, of class Population.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int index = 0;
        MazeList M = null;
        Population instance = new Population();
        instance.add(index, M);
    }

    /**
     * Test of getLength method, of class Population.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        int I = 0;
        Population instance = new Population();
        instance.Generate(4, 100, 100);
        LinkedList<MazeList> result = instance.getPopulation();
        I = instance.getLength(2);
        assertTrue(I > 2);
    }

    /**
     * Test of getSize method, of class Population.
     */
    @Test
    public void testGetSize_int() {
        System.out.println("getSize");
        int I = 0;
        Population instance = new Population();
        instance.Generate(4, 100, 100);
        LinkedList<MazeList> result = instance.getPopulation();
        I = instance.getSize(2);
        assertTrue(I >= 2);
    }

    /**
     * Test of getMaze method, of class Population.
     */
    @Test
    public void testGetMaze() {
        System.out.println("setMaze");
        MazeList maze = null;
        Population instance = new Population();
        instance.Generate(4, 100, 100);
        LinkedList<MazeList> result = instance.getPopulation();
        maze = instance.getMaze(2);
        assertEquals(instance.getMaze(2), maze);
    }

    /**
     * Test of setMaze method, of class Population.
     */
    @Test
    public void testSetMaze() {
        System.out.println("setMaze");
        MazeList maze = null;
        Population instance = new Population();
        instance.Generate(4, 100, 100);
        LinkedList<MazeList> result = instance.getPopulation();
        maze = instance.getMaze(2);
        instance.setMaze(3, maze);
        assertEquals(instance.getMaze(2), instance.getMaze(3));

    }

    /**
     * Test of getLongest method, of class Population.
     */
    @Test
    public void testGetLongest() {
        System.out.println("getLongest");
        Population instance = new Population();
        int expResult = 0;
        int result = instance.getLongest();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBiger method, of class Population.
     */
    @Test
    public void testGetBiger() {
        System.out.println("getBiger");
        Population instance = new Population();
        int expResult = 0;
        int result = instance.getBiger();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDivision method, of class Population.
     */
    @Test
    public void testGetDivision() {
        System.out.println("getDivision");
        int index = 0;
        Population instance = new Population();
        int[] expResult = null;

        System.out.println("setMaze");
        MazeList maze = null;
        instance.Generate(4, 100, 100);
        maze = instance.getMaze(1);
        expResult = maze.getDivision();
        assertNotNull(expResult);
    }

}
