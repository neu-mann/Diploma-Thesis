package model;

/**
 * Class contain all data about one segment of maze. Each maze is list of
 * "Elements".
 *
 * Its a part of engineering project prepared by author at Silesian University
 * of Technology, Gliwice
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class Element {

    private int length;         //Length of element. It's number of squers from StartPoint to EndPoint
    int[] startP;       //Coordination of StartPoint
    int[] endP;         //Coordination of EndPoint
    boolean vertical;   //True if StartPoint and EndPoint are in vertical line
    boolean ascending;  //True if EndPoint - StartPoint > 0
    int serial;         //Serial number of Element
    private int segmentDirection;    //segmentDirection indicate relation between "startP" and "endP"        
    //1 - if direction is from top to bottom
    //2 - if direction is from right to left
    //3 - if direction is from bottom to top
    //4 - if direction is from left to right

    /**
     * Default constructor.
     *
     * @since V2.0 2016-01-22
     */
    public Element() {
        this.length = 0;
        this.startP = new int[2];
        this.endP = new int[2];
        this.vertical = false;
        this.ascending = false;
        this.serial = 0;
        this.segmentDirection = 0;
    }

    /**
     * Parametric constructor.
     *
     * @param length set length of segment
     * @param start set start point of segment. int table with two element.
     * First coordinate: 'x', second coordinate: 'y' .
     * @param end set end point of segment. The same as start
     * @since V2.0 2016-01-22
     */
    public Element(int length, int[] start, int[] end) {

        this.length = length;
        this.startP = start;
        this.endP = end;
        this.serial = 0;
        this.segmentDirection = 0;
    }

    /**
     * Copying constructor.
     *
     * @param E element to be copied into new object
     * @since V2.0 2016-01-22
     */
    public Element(Element E) {
        this.length = E.length;
        this.startP = E.startP;
        this.endP = E.endP;
        this.vertical = E.vertical;
        this.ascending = E.ascending;
        this.serial = E.serial;
        this.segmentDirection = E.segmentDirection;
    }

    /**
     * Use this method to get length of segment.
     *
     * @return int with length.
     * @since V2.0 2016-01-22
     */
    public int getLength() {
        //Code is maybe not optimal but clear for analyse.

        int dir = this.getsegmentDirection();
        switch (dir) {
            case (1): {
                return this.startP[1] - this.endP[1] + 1;
            }
            case (2): {
                return this.startP[0] - this.endP[0] + 1;
            }
            case (3): {
                return this.endP[1] - this.startP[1] + 1;
            }
            case (4): {
                return this.endP[0] - this.startP[0] + 1;
            }
        }

        return -1;
    }

    /**
     * @deprecated You can use this method to force length of segment
     * independent from reality . Using is not recommended!
     * @param length put int with length of segment.
     * @since V2.0 2016-01-22
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Use this method to get coordinates of start point of segment.
     *
     * @return int table with two element. First coordinate: 'x', second
     * coordinate: 'y' .
     * @since V2.0 2016-01-22
     */
    public int[] getStartP() {
        return startP;
    }

    /**
     * Use this method to set coordinates of start point of segment.
     *
     * @param startP int table with two element. First coordinate: 'x', second
     * coordinate: 'y' .
     * @since V2.0 2016-01-22
     */
    public void setStartP(int[] startP) {
        this.startP[0] = startP[0];
        this.startP[1] = startP[1];
    }

    /**
     * Use this method to get coordinates of end point of segment.
     *
     * @return int table with two element. First coordinate: 'x', second
     * coordinate: 'y' .
     * @since V2.0 2016-01-22
     */
    public int[] getEndP() {
        return endP;
    }

    /**
     * Use this method to set coordinates of end point of segment.
     *
     * @param endP int table with two element. First coordinate: 'x', second
     * coordinate: 'y' .
     * @since V2.0 2016-01-22
     */
    public void setEndP(int[] endP) {
        this.endP[0] = endP[0];
        this.endP[1] = endP[1];
    }

    /**
     * You can use this method if you want to check that segment is vertical. It
     * means that y coordinate is same for start and end of segment.
     *
     * @return indicator of verticality. True if segment is vertical.
     * @since V2.0 2016-01-22
     */
    public boolean isVertical() {
        return this.vertical;
    }

    /**
     * @deprecated You can use this method to force verticality of segment
     * independent from reality . Using is not recommended!
     * @param vertical put true if you wont to force ascending.
     * @since V2.0 2016-01-22
     */
    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    /**
     * Each segment has own serial number. By this method is possible to check
     * this number.
     *
     * @return int method get you serial number of segment.
     * @since V2.0 2016-01-22
     */
    public int getSerial() {
        return serial;
    }

    /**
     * Each segment has own serial number. is possible to force new serial with
     * this method. Remember that serial should be unique.
     *
     * @param serial new value of segments serial number.
     * @since V2.0 2016-01-22
     */
    public void setSerial(int serial) {
        this.serial = serial;
    }

    /**
     * Use if you wont to know segment direction according to board. Possible
     * values: 1 - if direction is from top to bottom 2 - if direction is from
     * right to left 3 - if direction is from bottom to top 4 - if direction is
     * from left to tight
     *
     *
     * @return int with direction of segment.
     * @since V2.0 2016-01-22
     */
    public int getsegmentDirection() {

        //If segment is vertical
        if (this.startP[0] == this.endP[0]) {
            //start point is higher then end point
            if (this.startP[1] >= this.endP[1]) {
                return 1;
            } else {
                //start point is lower then end point
                return 3;
            }
            //If segment is horisontal
        } else {
            //start point is higher then end point
            if (this.startP[0] >= this.endP[0]) {
                return 2;
            } else {
                //start point is lower then end point
                return 4;
            }
        }
    }

    /**
     * @deprecated Set segment direction according to board. Possible values: 1
     * - if direction is from top to bottom 2 - if direction is from right to
     * left 3 - if direction is from bottom to top 4 - if direction is from left
     * to tight Using is not recommended!
     * @param segmentDirection Set direction of segment.
     * @since V2.0 2016-01-22
     */
    public void setSegmentDirection(int segmentDirection) {
        this.segmentDirection = segmentDirection;
    }

    /**
     * You can use this method if you want to check that segment is ascending.
     * It means that: - if segment is horizontal then end of segment is on the
     * right side. - if segment is vertical then end of segment is higher then
     * start.
     *
     * @return indicator of direction. True if segment is ascending
     * @since V2.0 2016-01-22
     */
    public boolean isAscending() {
        return ascending;
    }

    /**
     * @deprecated You can use this method to force direction of segment
     * independent from reality . Using is not recommended!
     * @param ascending put true if you wont to force ascending.
     * @since V2.0 2016-01-22
     */
    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    /**
     * Make copy of passed parameter into Element.
     *
     * @param E Element to be copied to local variables.
     * @since V2.0 2016-01-22
     */
    public void Copy(Element E) {
        this.length = E.length;
        this.startP = E.startP;
        this.endP = E.endP;
        this.vertical = E.vertical;
        this.ascending = E.ascending;
        this.serial = E.serial;
        this.segmentDirection = E.segmentDirection;
    }

}
