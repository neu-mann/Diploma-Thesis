package main;

import org.junit.Test;

/**
 * Test for class Main
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class MainIT {

    public MainIT() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = new String[4];
        args[0] = "10";
        args[1] = "20";
        args[2] = "50";
        args[3] = "c:\\test21.csv";
        Main.main(args);

    }

}
