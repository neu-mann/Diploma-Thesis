
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class Transfer.
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class TransferIT {

    public TransferIT() {
    }

    /**
     * Test of proceed method, of class Transfer.
     */
    @Test
    public void testProceed() {
        System.out.println("proceed");
        int[][] expResult = null;
        Population population = new Population();
        Transfer transfer = new Transfer();
        population.Generate(1, 100, 100);
        MazeList maze = population.getMaze(0);
        expResult = transfer.proceed(maze);
        assertNotNull(expResult);
    }

    /**
     * Test of transpose method, of class Transfer.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        int[][] expResult = null;
        int[][] result = null;
        Population population = new Population();
        Transfer transfer = new Transfer();
        population.Generate(1, 100, 100);
        MazeList maze = population.getMaze(0);
        expResult = transfer.proceed(maze);
        result = transfer.transpose(expResult, 100, 100);
        assertNotNull( result);

    }

}
