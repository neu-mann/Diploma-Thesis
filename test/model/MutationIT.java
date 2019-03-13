
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class Mutation.
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 * 
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class MutationIT {

    public MutationIT() {
    }

    /**
     * Test of checkSegment method, of class Mutation.
     */
    @Test
    public void testCheckSegment() {
        System.out.println("checkSegment");
        Element E = null;
        int[][] Arr = null;
        int wight = 100;
        int hight = 100;
        Mutation instance = new Mutation();
        Transfer transfer = new Transfer();
        MazeList mazeList = new MazeList();
        Intro intro = new Intro();
        mazeList.setHight(10);
        mazeList.setWight(10);
        mazeList = intro.randomIO(mazeList);
        mazeList = intro.routeFirst(mazeList);
        E = mazeList.GetElem(1);
        Arr = transfer.proceed(mazeList);
        MazeList result = instance.checkSegment(E, Arr, wight, hight);

    }

    /**
     * Test of findFirst method, of class Mutation.
     */
    @Test
    public void testFindFirst() {
        System.out.println("findFirst");
     MazeList L = null;
        int I = 2;
        Mutation instance = new Mutation();
        

        int expResult;
        MazeList mazeList = new MazeList();
        Intro intro = new Intro();
        mazeList.setHight(100);
        mazeList.setWight(100);
        mazeList = intro.randomIO(mazeList);
        mazeList = intro.routeFirst(mazeList);
        I = instance.findFirst(mazeList);
        MazeList result = instance.mute(mazeList, I);
        I = instance.findFirst(mazeList);
        result = instance.mute(result, I);
        I = instance.findFirst(mazeList);
        result = instance.mute(result, I);
        I = instance.findFirst(mazeList);
        result = instance.mute(result, I);  
        I = instance.findFirst(result);
        assertTrue(I >= -11);
    }

    /**
     * Test of findLast method, of class Mutation.
     */
    @Test
    public void testFindLast() {
        System.out.println("findLast");
     MazeList L = null;
        int I = 2;
        Mutation instance = new Mutation();
        

        int expResult;
        MazeList mazeList = new MazeList();
        Intro intro = new Intro();
        mazeList.setHight(100);
        mazeList.setWight(100);
        mazeList = intro.randomIO(mazeList);
        mazeList = intro.routeFirst(mazeList);
        I = instance.findFirst(mazeList);
        MazeList result = instance.mute(mazeList, I);
        I = instance.findFirst(mazeList);
        result = instance.mute(result, I);
        I = instance.findFirst(mazeList);
        result = instance.mute(result, I);
        I = instance.findFirst(mazeList);
        result = instance.mute(result, I);  
        I = instance.findLast(result);
        assertTrue(I >= -11);
    }

    /**
     * Test of findByOrder method, of class Mutation.
     */
    @Test
    public void testFindByOrder() {
        System.out.println("findByOrder");
        MazeList L = null;
        int I = 2;
        Mutation instance = new Mutation();
        

        int expResult;
        MazeList mazeList = new MazeList();
        Intro intro = new Intro();
        mazeList.setHight(100);
        mazeList.setWight(100);
        mazeList = intro.randomIO(mazeList);
        mazeList = intro.routeFirst(mazeList);
        I = instance.findFirst(mazeList);
        MazeList result = instance.mute(mazeList, I);
        I = instance.findFirst(mazeList);
        result = instance.mute(result, I);
        I = instance.findFirst(mazeList);
        result = instance.mute(result, I);
        I = instance.findFirst(mazeList);
        result = instance.mute(result, I);  
        I = instance.findByOrder(result, I);
        assertTrue(I >= -11);
    }

    /**
     * Test of mute method, of class Mutation.
     */
    @Test
    public void testMute() {
        System.out.println("mute");
        MazeList L = null;
        int I;
        Mutation instance = new Mutation();
        int expResult;

        
        
        MazeList mazeList = new MazeList();
        Intro intro = new Intro();
        mazeList.setHight(100);
        mazeList.setWight(100);
        mazeList = intro.randomIO(mazeList);
        mazeList = intro.routeFirst(mazeList);
        I = instance.findFirst(mazeList);
        expResult = mazeList.Size();        
        MazeList result = instance.mute(mazeList, I);
        assertEquals(expResult+4, result.Size());

    }

}
