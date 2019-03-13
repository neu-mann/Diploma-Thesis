package model;

import java.util.LinkedList;

/**
 * Class contain list of Elements. It's represent structure of maze.
 *
 * Its a part of engineering project prepared by author at Silesian University
 * of Technology, Gliwice
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class MazeList {

    private Element elem;               //base element of list
    private LinkedList<Element> list;   //list with whole maze
    private int hight;
    private int width;
    private Intro intro;
    public int serial;
    private int lastSize;
    private int lase;
    private int generation;

    /**
     * Default constructor.
     *
     * @since V2.0 2016-01-22
     */
    public MazeList() {
        intro = new Intro();
        this.list = new LinkedList();
        this.hight = 0;
        this.width = 0;
        this.serial = 0;
        this.lastSize = 0;
        this.lase = 0;
        this.generation = 0;
    }

    /**
     * Parametric constructor.
     *
     * @param sizeX set hight of maze
     * @param sizeY set width of maze
     *
     * @since V2.0 2016-01-22
     */
    public MazeList(int sizeX, int sizeY) {
        MazeList tmp;
        this.hight = sizeY;
        this.width = sizeX;
        this.serial = 0;
        this.list = new LinkedList();
        intro = new Intro();
        tmp = intro.randomIO(this);
        tmp = intro.routeFirst(tmp);
        this.list = tmp.getList();
        this.lastSize = 0;
        this.lase = 0;
        this.generation = 0;
    }

    /**
     * Copying constructor.
     *
     * @param L element to be copied into new object
     * @since V2.0 2016-01-22
     */
    public MazeList(MazeList L) {

        this.hight = L.hight;
        this.width = L.width;
        this.serial = L.serial;
        list = new LinkedList();
        for (int i = 0; i < L.Size(); i++) {
            this.list.add(L.Get(i));
        }
        this.lastSize = L.lastSize;
        this.lase = L.lase;
        this.generation = L.generation;

    }

    /**
     * Add new element at the end of list (maze).
     *
     * @param E Complete element with coordinates.
     * @since V2.0 2016-01-22
     */
    public void Add(Element E) {
        list.add(E);
    }

    /**
     * Add new element at the place indicated as first parameter.
     *
     * @param i Position to put new element.
     * @param E Complete element with coordinates.
     * @since V2.0 2016-01-22
     */
    public void Add(int i, Element E) {
        list.add(i, E);
    }

    /**
     * Get element from maze indicated by passed parameter .
     *
     * @param i number of element to take from maze.
     * @return Element
     * @since V2.0 2016-01-22
     */
    public Element Get(int i) {
        return list.get(i);
    }

    /**
     * Get element from maze indicated by passed parameter .
     *
     * @param i number of element to take from maze.
     * @return Element
     * @since V2.0 2016-01-22
     */
    public Element GetElem(int i) {
        return list.get(i);
    }

    /**
     * Add new element at the place indicated as first parameter.
     *
     * @param pos Position to put new element.
     * @param E Complete element with coordinates.
     * @since V2.0 2016-01-22
     */
    public void SetElem(int pos, Element E) {
        list.set(pos, E);
    }

    /**
     * Clear whole maze. Remove all elements.
     *
     * @since V2.0 2016-01-22
     */
    public void Clear() {
        list.clear();
    }

    /**
     * Return size of maze. There are number of segments in maze.
     *
     * @return Take size of maze as number of elements.
     * @since V2.0 2016-01-22
     */
    public int Size() {
        return list.size();

    }

    /**
     * Return hight of maze.
     *
     * @return int Take high of maze.
     * @since V2.0 2016-01-22
     */
    public int getHight() {
        return hight;
    }

    /**
     * Set hight of maze.
     *
     * @param hight New value of hight
     * @since V2.0 2016-01-22
     */
    public void setHight(int hight) {
        this.hight = hight;
    }

    /**
     * Return wight of maze.
     *
     * @return int Take wight of maze.
     * @since V2.0 2016-01-22
     */
    public int getWight() {
        return width;
    }

    /**
     * Set wight of maze.
     *
     * @param wight New value of hight
     * @since V2.0 2016-01-22
     */
    public void setWight(int wight) {
        this.width = wight;
    }

    /**
     * Return whole list of elements.
     *
     * @return LinkedList Its list of elements.
     * @since V2.0 2016-01-22
     */
    public LinkedList<Element> getList() {
        return list;
    }

    /**
     * Method make copy of MazeList.
     *
     * @return MazeList.
     * @since V2.0 2016-01-22
     */
    public MazeList getCopy() {

        MazeList tmp = new MazeList();
        tmp.hight = this.hight;
        tmp.width = this.width;
        tmp.serial = this.serial;
        for (int i = 0; i < this.list.size(); i++) {
            tmp.list.add(this.list.get(i));
        }
        tmp.lastSize = this.lastSize;
        tmp.lase = this.lase;
        tmp.generation = this.generation;
        return tmp;
    }

    /**
     * You can use this method to remove bugs from maze like short elements.
     *
     * @since V2.0 2016-01-22
     */
    public void deBug() {

        int indexBefore;
        int directionBefore;

        indexBefore = -1;
        directionBefore = -1;

//        for (Element E : this.list) {
//            
//            if (directionBefore == E.getsegmentDirection()) {
//                //E.setSerial(this.list.get(indexBefore).getSerial());
//                //E.setStartP(this.list.get(indexBefore).getStartP());
//                //this.list.remove(indexBefore);
//                this.list.get(indexBefore).setEndP(E.getEndP());
//                this.list.remove(E);
//            }
//            directionBefore = E.getsegmentDirection();
//            indexBefore = this.list.indexOf(E);  
//        }
        for (int i = 0; i < this.list.size(); i++) {

            if (this.list.get(i).getLength() <= 1) {
                this.list.remove(i);
            }
        }

        for (int i = 0; i < this.list.size(); i++) {

            if (directionBefore == this.list.get(i).getsegmentDirection()) {
                this.list.get(indexBefore).setEndP(this.list.get(i).getEndP());
                this.list.remove(i);

            }
            if (i < this.list.size()) {
                directionBefore = this.list.get(i).getsegmentDirection();
            }

            indexBefore = i;

        }

    }

    /**
     * Method return length of all element in maze.
     *
     * @return int Sum of maze.
     * @since V2.0 2016-01-22
     */
    public int getLength() {

        LinkedList<Element> localList;
        localList = this.getList();
        Transfer transf;
        int array[][];
        int ret;
        MazeList tmp = new MazeList();
        Mutation mut;

        transf = new Transfer();
        array = new int[this.getWight()][this.getHight()];
        array = transf.proceed(this);
        ret = 0;
        mut = new Mutation();

        for (Element E : localList) {

            ret += E.getLength() - 1;

        }

        return ret;
    }

    /**
     * Method return length of all element in maze.
     *
     * @param L MazeList to set in class.
     * @since V2.0 2016-01-22
     */
    public void SetList(MazeList L) {

        list = new LinkedList();
        for (int i = 0; i < L.Size(); i++) {
            this.list.add(L.Get(i));
        }

    }

    /**
     * Method return serial number of maze.
     *
     * @return int Serial of maze.
     * @since V2.0 2016-01-22
     */
    public int getSerial() {
        return serial;
    }

    /**
     * You can use this method when you want to set new serial in maze.
     *
     * @param serial Insert new serial of maze.
     * @since V2.0 2016-01-22
     */
    public void setSerial(int serial) {
        this.serial = serial;
    }

    /**
     * Method count how many percent of maze is putted to each quarters of
     * board. You can use this method to build most interested maze.
     *
     * @return int [] Four element table with percentage filling of each
     * quarter. there are in table: 0 - left bottom 1 - left top 2 - right top 3
     * - right bottom
     * @since V2.0 2016-01-22
     */
    public int[] getDivision() {

        //Quarters
        // - 1 - left bottom
        // - 2 - left top
        // - 3 - right top
        // - 4 - right bottom
        int sizex = this.getWight();
        int sizey = this.getHight();
        Transfer transfer = new Transfer();
        int array[][] = new int[sizex][sizey];
        int ret[] = new int[4];

        array = transfer.proceed(this);

        //Check 1 quarter
        for (int x = 0; x < sizex / 2; x++) {
            for (int y = 0; y < sizey / 2; y++) {
                if (array[x][y] != 0) {
                    ret[0]++;
                }
            }
        }

        //Check 3 quarter
        for (int x = 0; x < sizex / 2; x++) {
            for (int y = (sizey / 2); y < sizey; y++) {
                if (array[x][y] != 0) {
                    ret[1]++;
                }
            }
        }

        //Check 3 quarter
        for (int x = (sizex / 2); x < sizex; x++) {
            for (int y = (sizey / 2); y < sizey; y++) {
                if (array[x][y] != 0) {
                    ret[2]++;
                }
            }
        }

        //Check 4 quarter
        for (int x = (sizex / 2); x < sizex; x++) {
            for (int y = 0; y < sizey / 2; y++) {
                if (array[x][y] != 0) {
                    ret[3]++;
                }
            }
        }

        //Change for percent
        float sum = 0;
        float one, two, three, four;

        sum = ret[0] + ret[1] + ret[2] + ret[3];

        one = ret[0] / sum;
        two = ret[1] / sum;
        three = ret[2] / sum;
        four = ret[3] / sum;

        ret[0] = (int) (one * 100);
        ret[1] = (int) (two * 100);
        ret[2] = (int) (three * 100);
        ret[3] = (int) (four * 100);

        return ret;
    }

    /**
     * Method return size of maze before las mutation. Parameter "lastSise" is
     * not updated automatically. Only method setLastSize can change it.
     *
     * @see MazeList#setLastSize(int)
     *
     * @return int Serial of maze.
     * @since V2.0 2016-01-22
     */
    public int getLastSize() {
        return lastSize;
    }

    /**
     * Method set size of maze before las mutation. Parameter "lastSise" is not
     * updated automatically. Only this method can change it. You can use it to
     * store size of mutation before mutation.
     *
     *
     * @param lastSize Copy here last size of maze.
     *
     * @since V2.0 2016-01-22
     */
    public void setLastSize(int lastSize) {
        this.lastSize = lastSize;
    }

    /**
     * Method return lase of maze.
     *
     * @return int Lase of maze.
     * @since V2.0 2016-01-22
     */
    public int getLase() {
        return lase;
    }

    /**
     * You can use it to set lase of maze.
     *
     * @param lase of maze.
     * @since V2.0 2016-01-22
     */
    public void setLase(int lase) {
        this.lase = lase;
    }

    /**
     * Return number of generation of maze.
     *
     * @return int value with number of generation.
     * @since V2.0 2016-01-22
     */
    public int getGeneration() {
        return generation;
    }

    /**
     * Set generation of maze. You can use it to control number of mutation on
     * maze.
     *
     * @param generation int free parameter to use by programmer.
     * @since V2.0 2016-01-22
     */
    public void setGeneration(int generation) {
        this.generation = generation;
    }

}
