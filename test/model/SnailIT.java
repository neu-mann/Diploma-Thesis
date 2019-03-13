
package model;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class Snail.
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class SnailIT {

    public SnailIT() {
    }

    /**
     * Test of proceed method, of class Snail.
     */
    @Test
    public void testProceed() {
        System.out.println("proceed");
        int[][] array = null;
        int wight = 0;
        int hight = 0;
        Snail instance = new Snail();
        int[][] expResult = null;
        int[][] result = null;

        int I = 0;
        Population population = new Population();
        Transfer transfer = new Transfer();
        population.Generate(1, 100, 100);
        MazeList maze = population.getMaze(0);
        expResult = transfer.proceed(maze);
        result = instance.proceed(expResult, 100, 100);
        assertNotNull(result);

    }

}
