package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class Element.
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class ElementIT {

    public ElementIT() {
    }

    /**
     * Test of getLength method, of class Element.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Element instance = new Element();
        //Set points to element 10 cells length
        //Expected result 12.
        //See comments in class Element  
        int[] startP;
        startP = new int[2];
        startP[0] = 1;
        startP[1] = 1;
        instance.setStartP(startP);
        int[] endP;
        endP = new int[2];
        endP[0] = 1;
        endP[1] = 10;
        instance.setEndP(endP);

        int expResult = 10;
        int result = instance.getLength();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLength method, of class Element.
     */
    @Test
    public void testSetLength() {
        System.out.println("setLength");
        int length = 0;
        Element instance = new Element();
        instance.setLength(length);
    }

    /**
     * Test of getStartP method, of class Element.
     */
    @Test
    public void testGetStartP() {
        System.out.println("getStartP");
        Element instance = new Element();
        int[] startP;
        startP = new int[2];
        startP[0] = 1;
        startP[1] = 1;
        instance.setStartP(startP);
        int[] expResult;
        expResult = startP.clone();
        int[] result = instance.getStartP();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setStartP method, of class Element.
     */
    @Test
    public void testSetStartP() {
        System.out.println("setStartP");
        int[] startP;
        startP = new int[2];
        startP[0] = 0;
        startP[1] = 0;
        Element instance = new Element();
        instance.setStartP(startP);
    }

    /**
     * Test of getEndP method, of class Element.
     */
    @Test
    public void testGetEndP() {
        System.out.println("getEndP");
        Element instance = new Element();

        int[] endP;
        endP = new int[2];
        endP[0] = 2;
        endP[1] = 2;
        instance.setEndP(endP);
        int[] expResult;
        expResult = endP.clone();
        int[] result = instance.getEndP();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setEndP method, of class Element.
     */
    @Test
    public void testSetEndP() {
        System.out.println("setEndP");
        int[] endP = null;
        endP = new int[2];
        endP[0] = 0;
        endP[1] = 0;
        Element instance = new Element();
        instance.setEndP(endP);
    }

    /**
     * Test of isVertical method, of class Element.
     */
    @Test
    public void testIsVertical() {
        System.out.println("isVertical");
        Element instance = new Element();
        instance.setVertical(true);
        boolean expResult = true;
        boolean result = instance.isVertical();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVertical method, of class Element.
     */
    @Test
    public void testSetVertical() {
        System.out.println("setVertical");
        boolean vertical = false;
        Element instance = new Element();
        instance.setVertical(vertical);
    }

    /**
     * Test of getSerial method, of class Element.
     */
    @Test
    public void testGetSerial() {
        System.out.println("getSerial");
        Element instance = new Element();
        instance.setSerial(999);
        int expResult = 999;
        int result = instance.getSerial();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSerial method, of class Element.
     */
    @Test
    public void testSetSerial() {
        System.out.println("setSerial");
        int serial = 32000;
        Element instance = new Element();
        instance.setSerial(serial);
    }

    /**
     * Test of getsegmentDirection method, of class Element.
     */
    @Test
    public void testGetsegmentDirection() {
        System.out.println("getsegmentDirection");
        Element instance = new Element();

        //Set points to create vertical, ascending element
        //Expected result 4.
        //See comments in class Element  
        int[] startP;
        startP = new int[2];
        startP[0] = 1;
        startP[1] = 1;
        instance.setStartP(startP);
        int[] endP;
        endP = new int[2];
        endP[0] = 10;
        endP[1] = 1;
        instance.setEndP(endP);

        int expResult = 4;
        int result = instance.getsegmentDirection();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSegmentDirection method, of class Element.
     */
    @Test
    public void testSetSegmentDirection() {
        System.out.println("setSegmentDirection");
        int segmentDirection = 0;
        Element instance = new Element();
        instance.setSegmentDirection(segmentDirection);
    }

    /**
     * Test of isAscending method, of class Element.
     */
    @Test
    public void testIsAscending() {
        System.out.println("isAscending");
        Element instance = new Element();
        instance.setAscending(true);
        boolean expResult = true;
        boolean result = instance.isAscending();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAscending method, of class Element.
     */
    @Test
    public void testSetAscending() {
        System.out.println("setAscending");
        boolean ascending = false;
        Element instance = new Element();
        instance.setAscending(ascending);
    }

    /**
     * Test of Copy method, of class Element.
     */
    @Test
    public void testCopy() {
        System.out.println("Copy");
        Element E = new Element();
        int[] endP;
        endP = new int[2];
        endP[0] = 100;
        endP[1] = 50;
        E.setEndP(endP);
        int expResult = 50;
        Element instance = new Element();
        instance.Copy(E);
        assertEquals(expResult, instance.getEndP()[1]);
    }

}
