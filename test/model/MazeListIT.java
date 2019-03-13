
package model;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class MazeList.
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class MazeListIT {

    public MazeListIT() {
    }

    /**
     * Test of Add method, of class MazeList.
     */
    @Test
    public void testAdd_Element() {
        System.out.println("Add");
        Element E = null;
        MazeList instance = new MazeList();
        instance.Add(E);
    }

    /**
     * Test of Add method, of class MazeList.
     */
    @Test
    public void testAdd_int_Element() {
        System.out.println("Add");
        int i = 0;
        Element E = null;
        MazeList instance = new MazeList();
        instance.Add(i, E);

    }

    /**
     * Test of Get method, of class MazeList.
     */
    @Test
    public void testGet() {
        System.out.println("Get");
        int i = 0;
        Intro intro = new Intro();
        MazeList instance = new MazeList();
        instance.setHight(10);
        instance.setWight(10);
        instance = intro.randomIO(instance);
        instance = intro.routeFirst(instance);
        Element expResult = null;
        Element result = instance.Get(i);
        assertNotNull(result);
    }

    /**
     * Test of GetElem method, of class MazeList.
     */
    @Test
    public void testGetElem() {
        System.out.println("GetElem");
        int i = 0;
        MazeList instance = new MazeList();
        Intro intro = new Intro();
        instance.setHight(10);
        instance.setWight(10);
        instance = intro.randomIO(instance);
        instance = intro.routeFirst(instance);
        Element result = instance.GetElem(i);
        assertNotNull(result);

    }

    /**
     * Test of SetElem method, of class MazeList.
     */
    @Test
    public void testSetElem() {
        System.out.println("SetElem");
        int pos = 0;
        Element E = new Element();
        Intro intro = new Intro();
        MazeList instance = new MazeList();
        instance.setHight(10);
        instance.setWight(10);
        instance = intro.randomIO(instance);
        instance = intro.routeFirst(instance);
        instance.SetElem(pos, E);
    }

    /**
     * Test of Clear method, of class MazeList.
     */
    @Test
    public void testClear() {
        System.out.println("Clear");
        MazeList instance = new MazeList();
        instance.Clear();
    }

    /**
     * Test of Size method, of class MazeList.
     */
    @Test
    public void testSize() {
        System.out.println("Size");
        MazeList instance = new MazeList();
        int expResult = 0;
        int result = instance.Size();
        assertEquals(expResult, result);

    }

    /**
     * Test of getHight method, of class MazeList.
     */
    @Test
    public void testGetHight() {
        System.out.println("getHight");
        MazeList instance = new MazeList();
        int expResult = 0;
        int result = instance.getHight();
        assertEquals(expResult, result);

    }

    /**
     * Test of setHight method, of class MazeList.
     */
    @Test
    public void testSetHight() {
        System.out.println("setHight");
        int hight = 0;
        MazeList instance = new MazeList();
        instance.setHight(hight);

    }

    /**
     * Test of getWight method, of class MazeList.
     */
    @Test
    public void testGetWight() {
        System.out.println("getWight");
        MazeList instance = new MazeList();
        int expResult = 0;
        int result = instance.getWight();
        assertEquals(expResult, result);

    }

    /**
     * Test of setWight method, of class MazeList.
     */
    @Test
    public void testSetWight() {
        System.out.println("setWight");
        int wight = 0;
        MazeList instance = new MazeList();
        instance.setWight(wight);

    }

    /**
     * Test of getList method, of class MazeList.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        MazeList instance = new MazeList();

        Intro intro = new Intro();
        instance.setHight(10);
        instance.setWight(10);
        instance = intro.randomIO(instance);
        instance = intro.routeFirst(instance);
        LinkedList<Element> result = instance.getList();
        assertNotNull(result);

    }

    /**
     * Test of getCopy method, of class MazeList.
     */
    @Test
    public void testGetCopy() {
        System.out.println("getCopy");
        MazeList instance = new MazeList();
        Intro intro = new Intro();
        instance.setHight(10);
        instance.setWight(10);
        instance = intro.randomIO(instance);
        instance = intro.routeFirst(instance);
        MazeList result = instance.getCopy();
        assertEquals(instance.getLength(), result.getLength());
    }

    /**
     * Test of deBug method, of class MazeList.
     */
    @Test
    public void testDeBug() {
        System.out.println("deBug");
        MazeList instance = new MazeList();
        instance.deBug();

    }

    /**
     * Test of getLength method, of class MazeList.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        MazeList instance = new MazeList();
        int expResult = 0;
        int result = instance.getLength();
        assertEquals(expResult, result);

    }

    /**
     * Test of SetList method, of class MazeList.
     */
    @Test
    public void testSetList() {
        System.out.println("SetList");

        Intro intro = new Intro();
        MazeList instance = new MazeList();
        MazeList list = new MazeList();
        list.setHight(10);
        list.setWight(10);
        list = intro.randomIO(list);
        list = intro.routeFirst(list);
        instance.SetList(list);

    }

    /**
     * Test of getSerial method, of class MazeList.
     */
    @Test
    public void testGetSerial() {
        System.out.println("getSerial");
        MazeList instance = new MazeList();
        int expResult = 0;
        int result = instance.getSerial();
        assertEquals(expResult, result);

    }

    /**
     * Test of setSerial method, of class MazeList.
     */
    @Test
    public void testSetSerial() {
        System.out.println("setSerial");
        int serial = 0;
        MazeList instance = new MazeList();
        instance.setSerial(serial);

    }

    /**
     * Test of getDivision method, of class MazeList.
     */
    @Test
    public void testGetDivision() {
        System.out.println("getDivision");

        Intro intro = new Intro();
        MazeList instance = new MazeList();
        instance.setHight(100);
        instance.setWight(100);
        instance = intro.randomIO(instance);
        instance = intro.routeFirst(instance);

        int[] result = instance.getDivision();
        assertEquals(4, result.length);

    }

    /**
     * Test of getLastSize method, of class MazeList.
     */
    @Test
    public void testGetLastSize() {
        System.out.println("getLastSize");
        MazeList instance = new MazeList();
        int expResult = 0;
        int result = instance.getLastSize();
        assertEquals(expResult, result);

    }

    /**
     * Test of setLastSize method, of class MazeList.
     */
    @Test
    public void testSetLastSize() {
        System.out.println("setLastSize");
        int lastSize = 0;
        MazeList instance = new MazeList();
        instance.setLastSize(lastSize);

    }

    /**
     * Test of getLase method, of class MazeList.
     */
    @Test
    public void testGetLase() {
        System.out.println("getLase");
        MazeList instance = new MazeList();
        int expResult = 0;
        int result = instance.getLase();
        assertEquals(expResult, result);

    }

    /**
     * Test of setLase method, of class MazeList.
     */
    @Test
    public void testSetLase() {
        System.out.println("setLase");
        int lase = 0;
        MazeList instance = new MazeList();
        instance.setLase(lase);

    }

    /**
     * Test of getGeneration method, of class MazeList.
     */
    @Test
    public void testGetGeneration() {
        System.out.println("getGeneration");
        MazeList instance = new MazeList();
        int expResult = 0;
        int result = instance.getGeneration();
        assertEquals(expResult, result);

    }

    /**
     * Test of setGeneration method, of class MazeList.
     */
    @Test
    public void testSetGeneration() {
        System.out.println("setGeneration");
        int generation = 0;
        MazeList instance = new MazeList();
        instance.setGeneration(generation);

    }

}
