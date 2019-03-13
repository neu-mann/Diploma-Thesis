
package view;

import model.MazeList;
import model.Population;
import model.Transfer;
import org.junit.Test;


/**
 * Test for class View.
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class ViewIT {
    
    public ViewIT() {
    }

    /**
     * Test of show method, of class View.
     */
    @Test
    public void testShow() {
        System.out.println("show");
        int[][] array = null;
        int wight = 100;
        int hight = 100;
        Population population = new Population();
        Transfer transfer = new Transfer();
        population.Generate(1, 100, 100);
        MazeList maze = population.getMaze(0);
        array = transfer.proceed(maze);
        View instance = new View();
        instance.show(array, wight, hight);
    }

    /**
     * Test of showText method, of class View.
     */
    @Test
    public void testShowText() {
        System.out.println("showText");
        String S = "";
        View instance = new View();
        instance.showText(S);
    }
    
}
