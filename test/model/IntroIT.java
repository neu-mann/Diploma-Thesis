
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class Intro.
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class IntroIT {

    public IntroIT() {
    }

    /**
     * Test of randomIO method, of class Intro.
     */
    @Test
    public void testRandomIO() {
        System.out.println("randomIO");
        MazeList mazeDiag = new MazeList();
        mazeDiag.setHight(10);
        mazeDiag.setWight(10);
        Intro instance = new Intro();
        MazeList result = instance.randomIO(mazeDiag);
        assertEquals(2, result.Size());

    }

    /**
     * Test of routeFirst method, of class Intro.
     */
    @Test
    public void testRouteFirst() {
        System.out.println("routeFirst");
        MazeList mazeDiag_before = new MazeList();
        mazeDiag_before.setHight(10);
        mazeDiag_before.setWight(10);
        Intro instance = new Intro();
        mazeDiag_before = instance.randomIO(mazeDiag_before);
        MazeList mazeDiag_after = instance.routeFirst(mazeDiag_before);
        assertArrayEquals(mazeDiag_before.GetElem(0).startP, mazeDiag_after.GetElem(0).startP);

    }

}
