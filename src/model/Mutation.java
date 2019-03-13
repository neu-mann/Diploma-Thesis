package model;

import java.util.LinkedList;
import java.util.Random;

/**
 * Class can prepare mutation on ArrayList.
 *
 * Its a part of engineering project prepared by author at Silesian University
 * of Technology, Gliwice
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class Mutation {

    /**
     * Check segment to be able for mutation.
     *
     * @param E Element for check.
     * @param Arr Array with maze. Is needed to analyze sorroundings of
     * elements.
     * @param wight Wight of maze
     * @param hight Hight of maze
     * @return MazeList Here you can receive vector that is limit of mutation.
     *
     * @since V2.0 2016-01-22
     */
    public MazeList checkSegment(Element E, int Arr[][], int wight, int hight) {
        //<<Local variables
        int tmpDir;
        Element e;              //element of maze list
        Transfer transfer;      //to transfer maze from list into array
        int array[][];          //to keep array represetation of maze
        int counter;            //counter of empty cels
        MazeList ret;           //return value. Should contain basic information for mutation.
        Element segmentLower;   //to keep information about mutable segment on lower side
        Element segmentHigher;  //to keep information about mutable segment on higher side
        int[] startPL;           //start piont of mutable segment
        int[] endPL;             //end piont of mutable segment
        int[] startPH;           //start piont of mutable segment
        int[] endPH;             //end piont of mutable segment
        boolean found;          //To keep information when segment able to mutation
        //>>Local variables

        //<<Init local variables
        e = new Element(E);
        tmpDir = e.getsegmentDirection();
        transfer = new Transfer();
        //array = new int[L.getWight()][L.getWight()];
        array = Arr.clone();
        counter = 0;
        ret = new MazeList();
        segmentLower = new Element();
        segmentHigher = new Element();
        startPL = new int[2];
        endPL = new int[2];
        startPH = new int[2];
        endPH = new int[2];
        found = false;
        //>>Init local variables

        //If segment is too short then we return null
        if (e.getLength() < 2) {
            return null;
        }

        //array = transfer.proceed(L);
        //In case of direction
        switch (tmpDir) {
            //if direction is from top to bottom
            case (1):
                //check left (from top to bottom)↓
                counter = 0;
                found = false;
                if (e.getStartP()[0] > 0) {                                    //if segment is not touching left wall 
                    for (int i = e.getStartP()[1]; i >= e.getEndP()[1]; i--) {//count cels on the left
                        if (array[e.getStartP()[0] - 1][i] == 0) {
                            counter++;
                            if (counter == 2 && found == false) {             //if we found minimum 2 cels then is posible to mute
                                startPL[0] = e.getStartP()[0] - 1;
                                startPL[1] = i + 1;
                                segmentLower.setStartP(startPL);
                                segmentLower.setVertical(true);
                                segmentLower.setSegmentDirection(1);
                                found = true;
                            }
                        } else {
                            counter = 0;
                            found = false;
                        }
                        if (found) {
                            endPL[0] = startPL[0];
                            endPL[1] = i;
                            segmentLower.setEndP(endPL);
                        }
                    }
                }

                //check right (from top to bottom)↓ 
                counter = 0;
                found = false;
                if (e.getStartP()[0] < wight - 1) {                //if segment is not touching right wall 
                    for (int i = e.getStartP()[1]; i >= e.getEndP()[1]; i--) {//count cels on the left
                        if (array[e.getStartP()[0] + 1][i] == 0) {
                            counter++;
                            if (counter == 2 && found == false) {             //if we found minimum 2 cels then is posible to mute
                                startPH[0] = e.getStartP()[0] + 1;
                                startPH[1] = i + 1;
                                segmentHigher.setStartP(startPH);
                                segmentHigher.setVertical(true);
                                segmentHigher.setSegmentDirection(1);
                                found = true;
                            }
                        } else {
                            counter = 0;
                            found = false;
                        }
                        if (found) {
                            endPH[0] = startPH[0];
                            endPH[1] = i;
                            segmentHigher.setEndP(endPH);
                        }
                    }
                }
                if (segmentLower.getLength() > 1) {
                    ret.Add(segmentLower);
                }
                if (segmentHigher.getLength() > 1) {
                    ret.Add(segmentHigher);
                }

                return ret;

            //if direction is from right to left
            case (2):
                //check upper (from right to left)←

                counter = 0;
                found = false;
                if (e.getStartP()[1] < hight - 1) {                                    //if segment is not touching top wall 
                    for (int i = e.getStartP()[0]; i >= e.getEndP()[0]; i--) {//count cels on the left
                        if (array[i][e.getStartP()[1] + 1] == 0) {
                            counter++;
                            if (counter == 2 && found == false) {             //if we found minimum 2 cels then is posible to mute
                                startPL[0] = i + 1;
                                startPL[1] = e.getStartP()[1] + 1;
                                segmentLower.setStartP(startPL);
                                segmentLower.setVertical(true);
                                segmentLower.setSegmentDirection(2);
                                found = true;
                            }
                        } else {
                            counter = 0;
                            found = false;
                        }
                        if (found) {
                            endPL[0] = i;
                            endPL[1] = startPL[1];
                            segmentLower.setEndP(endPL);
                        }
                    }
                }

                //check lower (from right to left)←
                counter = 0;
                found = false;
                if (e.getStartP()[1] > 0) {                                    //if segment is not touching bottom wall 
                    for (int i = e.getStartP()[0]; i >= e.getEndP()[0]; i--) {//count cels on the left
                        if (array[i][e.getStartP()[1] - 1] == 0) {
                            counter++;
                            if (counter == 2 && found == false) {             //if we found minimum 2 cels then is posible to mute
                                startPL[0] = i + 1;
                                startPL[1] = e.getStartP()[1] - 1;
                                segmentHigher.setStartP(startPL);
                                segmentHigher.setVertical(true);
                                segmentHigher.setSegmentDirection(2);
                                found = true;
                            }
                        } else {
                            counter = 0;
                            found = false;
                        }
                        if (found) {
                            endPL[0] = i;
                            endPL[1] = startPL[1];
                            segmentHigher.setEndP(endPL);
                        }
                    }
                }
                if (segmentLower.getLength() > 1) {
                    ret.Add(segmentLower);
                }
                if (segmentHigher.getLength() > 1) {
                    ret.Add(segmentHigher);
                }

                return ret;

            //if direction is from bottom to top
            case (3):

                //check left  (from bottom to top)↑
                counter = 0;
                found = false;
                if (e.getStartP()[0] > 0) {                                    //if segment is not touching left wall 
                    for (int i = e.getStartP()[1]; i < e.getEndP()[1]; i++) {//count cels on the left
                        if (array[e.getStartP()[0] - 1][i] == 0) {
                            counter++;
                            if (counter == 2 && found == false) {             //if we found minimum 2 cels then is posible to mute
                                startPL[0] = e.getStartP()[0] - 1;
                                startPL[1] = i - 1;
                                segmentLower.setStartP(startPL);
                                segmentLower.setVertical(true);
                                segmentLower.setSegmentDirection(3);
                                found = true;
                            }
                        } else {
                            counter = 0;
                            found = false;
                        }
                        if (found) {
                            endPL[0] = startPL[0];
                            endPL[1] = i;
                            segmentLower.setEndP(endPL);
                        }
                    }
                }

                //check right  (from bottom to top)↑
                counter = 0;
                found = false;
                if (e.getStartP()[0] < wight - 1) {                //if segment is not touching right wall 
                    for (int i = e.getStartP()[1]; i < e.getEndP()[1]; i++) {//count cels on the right
                        if (array[e.getStartP()[0] + 1][i] == 0) {
                            counter++;
                            if (counter == 2 && found == false) {             //if we found minimum 2 cels then is posible to mute
                                startPH[0] = e.getStartP()[0] + 1;
                                startPH[1] = i - 1;
                                segmentHigher.setStartP(startPH);
                                segmentHigher.setVertical(true);
                                segmentHigher.setSegmentDirection(3);
                                found = true;
                            }
                        } else {
                            counter = 0;
                            found = false;
                        }
                        if (found) {
                            endPH[0] = startPH[0];
                            endPH[1] = i;
                            segmentHigher.setEndP(endPH);
                        }
                    }
                }
                if (segmentLower.getLength() > 1) {
                    ret.Add(segmentLower);
                }
                if (segmentHigher.getLength() > 1) {
                    ret.Add(segmentHigher);
                }

                return ret;

            //if direction is from left to right
            case (4):
                //check upper ( from left to right)→

                counter = 0;
                found = false;
                if (e.getStartP()[1] < hight - 1) {                                    //if segment is not touching top wall 
                    for (int i = e.getStartP()[0]; i <= e.getEndP()[0]; i++) {//count cels on the left
                        if (array[i][e.getStartP()[1] + 1] == 0) {
                            counter++;
                            if (counter == 2 && found == false) {             //if we found minimum 2 cels then is posible to mute
                                startPL[0] = i - 1;
                                startPL[1] = e.getStartP()[1] + 1;
                                segmentLower.setStartP(startPL);
                                segmentLower.setVertical(true);
                                segmentLower.setSegmentDirection(2);
                                found = true;
                            }
                        } else {
                            counter = 0;
                            found = false;
                        }
                        if (found) {
                            endPL[0] = i;
                            endPL[1] = startPL[1];
                            segmentLower.setEndP(endPL);
                        }
                    }
                }

                //check lower ( from left to right)→
                counter = 0;
                found = false;
                if (e.getStartP()[1] > 0) {                                    //if segment is not touching bottom wall 
                    for (int i = e.getStartP()[0]; i <= e.getEndP()[0]; i++) {//count cels on the left
                        if (array[i][e.getStartP()[1] - 1] == 0) {
                            counter++;
                            if (counter == 2 && found == false) {             //if we found minimum 2 cels then is posible to mute
                                startPL[0] = i - 1;
                                startPL[1] = e.getStartP()[1] - 1;
                                segmentHigher.setStartP(startPL);
                                segmentHigher.setVertical(true);
                                segmentHigher.setSegmentDirection(2);
                                found = true;
                            }
                        } else {
                            counter = 0;
                            found = false;
                        }
                        if (found) {
                            endPL[0] = i;
                            endPL[1] = startPL[1];
                            segmentHigher.setEndP(endPL);
                        }
                    }
                }
                if (segmentLower.getLength() > 1) {
                    ret.Add(segmentLower);
                }
                if (segmentHigher.getLength() > 1) {
                    ret.Add(segmentHigher);
                }

                return ret;

        }

        return null;
    }

    /**
     * Return number of first segment able to mutation.
     *
     * @param L MazeList to find element.
     * @return int Number of segment for mutation.
     *
     * @since V2.0 2016-01-22
     */
    public int findFirst(MazeList L) {

        LinkedList<Element> localList;
        localList = L.getList();
        Transfer transf;
        int array[][];
        int ret;
        MazeList tmp = new MazeList();

        transf = new Transfer();
        array = new int[L.getWight()][L.getHight()];
        array = transf.proceed(L);
        ret = 0;

        for (Element E : localList) {

            tmp = this.checkSegment(E, array, L.getWight(), L.getHight());
            if ((tmp != null) && (tmp.Size() > 0)) {
                return ret;
            }
            ret++;

        }

        return -11;
    }

    /**
     * Return number of last segment able to mutation.
     *
     * @param L MazeList to find element.
     * @return int Number of segment for mutation.
     *
     * @since V2.0 2016-01-22
     */
    public int findLast(MazeList L) {

        LinkedList<Element> localList;
        localList = L.getList();
        Transfer transf;
        int array[][];
        int ret;
        MazeList tmp = new MazeList();

        transf = new Transfer();
        array = new int[L.getWight()][L.getHight()];
        array = transf.proceed(L);
        ret = 0;

        for (int i = localList.size() - 1; i >= 0; i--) {

            tmp = this.checkSegment(localList.get(i), array, L.getWight(), L.getHight());
            if ((tmp != null) && (tmp.Size() > 0)) {
                return i;
            }
        }

        return -11;
    }

    /**
     * Return number of segment able to mutation. Method is seeking "I" number
     * of segment able to mutation.
     *
     * @param L MazeList to find element.
     * @param I Next element able to mutation.
     * @return int Number of segment for mutation..
     *
     * @since V2.0 2016-01-22
     */
    public int findByOrder(MazeList L, int I) {

        LinkedList<Element> localList;
        localList = L.getList();
        Transfer transf;
        int array[][];
        int ret;
        MazeList tmp = new MazeList();
        int number;

        transf = new Transfer();
        array = new int[L.getWight()][L.getHight()];
        array = transf.proceed(L);
        ret = 0;
        number = 0;

        for (int i = localList.size() - 1; i >= 0; i--) {

            tmp = this.checkSegment(localList.get(i), array, L.getWight(), L.getHight());
            if ((tmp != null) && (tmp.Size() > 0)) {
                number++;
            }

            if (number == I) {
                return i;
            }
        }

        return -11;
    }

    /**
     * Make mutation if indicated element.
     *
     * @param L MazeList with maze diagram.
     * @param I Number of element for mutation.
     * @return MazeList with maze after mutation.
     *
     * @since V2.0 2016-01-22
     */
    public MazeList mute(MazeList L, int I) {

        //<<Local Variables
        MazeList localList;
        MazeList posibilityList;
        int wight;
        int hight;
        int array[][];
        int point1[];
        int point2[];
        int point3[];
        Element baseElement;
        Random generator;
        Transfer transfer;
        int direction;
        int serial1;
        int serial2;
        int serial3;
        Element elem1;
        Element elem2;
        Element elem3;
        Element elem4;
        int selector;
         //Local variables >>

        //<<Init Local variables
        localList = new MazeList(L);
        wight = localList.getWight();
        hight = localList.getHight();
        array = new int[wight][hight];
        transfer = new Transfer();
        baseElement = new Element();
        point1 = new int[2];
        point2 = new int[2];
        point3 = new int[2];
        generator = new Random();
        direction = 0;
        serial1 = 0;
        serial2 = 0;
        serial3 = 0;
        elem1 = new Element();
        elem2 = new Element();
        elem3 = new Element();
        elem4 = new Element();
        selector = 0;
        //Init Local variables>>
        array = transfer.proceed(localList);
        posibilityList = this.checkSegment(localList.GetElem(I), array, wight, hight);

        //Choose side of mutation     
        if ((posibilityList != null) && (posibilityList.Size() > 0)) {

            baseElement = posibilityList.GetElem(0);
            if (posibilityList.Size() > 1) {

                baseElement = posibilityList.GetElem(generator.nextInt(2));
            }
            selector = localList.GetElem(I).getsegmentDirection();
        }

        switch (selector) {
            case (1): {

                //Random first point
                point1[0] = baseElement.getStartP()[0];
                point1[1] = baseElement.getStartP()[1] - generator.nextInt(baseElement.getStartP()[1] - baseElement.getEndP()[1]);
                //Random third point
                point3[0] = point1[0];
                point3[1] = point1[1] - generator.nextInt(point1[1] - baseElement.getEndP()[1]) - 1;

                if (point1[0] > localList.GetElem(I).getStartP()[0]) {
                    direction = 4;
                } else {
                    direction = 2;
                }
                //Random second point
                point2[1] = point3[1];
                if (direction == 4) {
                    if (this.checkDepth(array, point3, point1, direction, wight) - point1[0] > 0) {
                        point2[0] = point1[0] + generator.nextInt(this.checkDepth(array, point3, point1, direction, wight) - point1[0]);
                    } else {
                        point2[0] = point1[0];
                    }
                }

                if (direction == 2) {
                    if (point1[0] - this.checkDepth(array, point3, point1, direction, 0) > 0) {
                        point2[0] = point1[0] - generator.nextInt(point1[0] - this.checkDepth(array, point3, point1, direction, 0));
                    } else {
                        point2[0] = point1[0];
                    }
                }

                //Start mutation
                serial1 = localList.GetElem(I).getSerial();
                if (I + 1 < localList.Size()) {
                    serial2 = localList.GetElem(I + 1).getSerial();
                } else {
                    serial2 = serial1 + 10000;
                }
                serial2 = (serial2 - serial1) / 5;
                serial3 = serial2 + serial1;
                ///change existing element and copy last point
                elem4.endP[0] = localList.GetElem(I).endP[0];
                elem4.endP[1] = localList.GetElem(I).endP[1];
                localList.GetElem(I).endP[1] = point1[1];

                ///add first element
                elem1.startP[0] = localList.GetElem(I).endP[0];
                elem1.startP[1] = localList.GetElem(I).endP[1];
                elem1.endP[0] = point2[0];
                elem1.endP[1] = point1[1];
                elem1.serial = serial3;
                localList.Add(I + 1, elem1);

                ///add second element
                elem2.startP[0] = elem1.endP[0];
                elem2.startP[1] = elem1.endP[1];
                elem2.endP[0] = point2[0];
                elem2.endP[1] = point3[1];
                elem2.serial = elem1.serial + serial2;
                localList.Add(I + 2, elem2);

                ///add third element
                elem3.startP[0] = elem2.endP[0];
                elem3.startP[1] = elem2.endP[1];
                elem3.endP[0] = elem1.startP[0];
                elem3.endP[1] = point3[1];
                elem3.serial = elem2.serial + serial2;
                localList.Add(I + 3, elem3);

                ///add fourth element
                elem4.startP[0] = elem3.endP[0];
                elem4.startP[1] = elem3.endP[1];
                elem4.serial = elem3.serial + serial2;
                localList.Add(I + 4, elem4);

                break;
            }

            case (2): {
                //Random first point
                point1[1] = baseElement.getStartP()[1];
                point1[0] = baseElement.getStartP()[0] - generator.nextInt(baseElement.getStartP()[0] - baseElement.getEndP()[0]);
                //Random third point
                point3[1] = point1[1];
                point3[0] = point1[0] - generator.nextInt(point1[0] - baseElement.getEndP()[0]) - 1;

                if (point1[1] > localList.GetElem(I).getStartP()[1]) {
                    direction = 3;//from bottom to top
                } else {
                    direction = 1;//from top to bottom
                }
                //Random second point
                point2[0] = point3[0];
                if (direction == 1) {
                    if (point1[1] - this.checkDepth(array, point3, point1, direction, 0) > 0) // mało elegancko ale skutecznie
                    {
                        point2[1] = point1[1] - generator.nextInt(point1[1] - this.checkDepth(array, point3, point1, direction, 0)) - 1;
                    } else {
                        point2[1] = point1[1];
                    }
                }

                if (direction == 3) {
                    if ((this.checkDepth(array, point3, point1, direction, hight) - point1[1]) > 0) {
                        point2[1] = point1[1] + generator.nextInt(this.checkDepth(array, point3, point1, direction, hight) - point1[1]);
                    } else {
                        point2[1] = point1[1];
                    }
                }

                //Start mutation
                serial1 = localList.GetElem(I).getSerial();
                if (I + 1 < localList.Size()) {
                    serial2 = localList.GetElem(I + 1).getSerial();
                } else {
                    serial2 = serial1 + 10000;
                }
                serial2 = (serial2 - serial1) / 5;
                serial3 = serial2 + serial1;
                ///change existing element and copy last point
                elem4.endP[0] = localList.GetElem(I).endP[0];
                elem4.endP[1] = localList.GetElem(I).endP[1];
                localList.GetElem(I).endP[0] = point1[0];

                ///add first element
                elem1.startP[0] = localList.GetElem(I).endP[0];
                elem1.startP[1] = localList.GetElem(I).endP[1];
                elem1.endP[0] = localList.GetElem(I).endP[0];
                elem1.endP[1] = point2[1];
                elem1.serial = serial3;
                localList.Add(I + 1, elem1);

                ///add second element
                elem2.startP[0] = elem1.endP[0];
                elem2.startP[1] = elem1.endP[1];
                elem2.endP[0] = point3[0];
                elem2.endP[1] = point2[1];
                elem2.serial = elem1.serial + serial2;
                localList.Add(I + 2, elem2);

                ///add third element
                elem3.startP[0] = elem2.endP[0];
                elem3.startP[1] = elem2.endP[1];
                elem3.endP[0] = point3[0];
                elem3.endP[1] = elem1.startP[1];
                elem3.serial = elem2.serial + serial2;
                localList.Add(I + 3, elem3);

                ///add fourth element
                elem4.startP[0] = elem3.endP[0];
                elem4.startP[1] = elem3.endP[1];
                elem4.serial = elem3.serial + serial2;
                localList.Add(I + 4, elem4);

                break;
            }

            case (3): {

                //Random first point
                point1[0] = baseElement.getStartP()[0];
                point1[1] = baseElement.getStartP()[1] + generator.nextInt(baseElement.getEndP()[1] - baseElement.getStartP()[1]);
                //Random third point
                point3[0] = point1[0];
                point3[1] = point1[1] + generator.nextInt(baseElement.getEndP()[1] - point1[1]) + 1;

                if (point1[0] > localList.GetElem(I).getStartP()[0]) {
                    direction = 4;
                } else {
                    direction = 2;
                }
                //Random second point
                point2[1] = point3[1];
                if (direction == 4) {
                    if (this.checkDepth(array, point1, point3, direction, wight) - point1[0] > 0) {
                        point2[0] = point1[0] + generator.nextInt(this.checkDepth(array, point1, point3, direction, wight) - point1[0]);
                    } else {
                        point2[0] = point1[0];
                    }
                }

                if (direction == 2) {
                    if ((point1[0] - this.checkDepth(array, point1, point3, direction, 0)) > 0) {
                        point2[0] = point1[0] - generator.nextInt(point1[0] - this.checkDepth(array, point1, point3, direction, 0));
                    } else {
                        point2[0] = point1[0];
                    }
                }

                //Start mutation
                serial1 = localList.GetElem(I).getSerial();
                if (I + 1 < localList.Size()) {
                    serial2 = localList.GetElem(I + 1).getSerial();
                } else {
                    serial2 = serial1 + 10000;
                }
                serial2 = (serial2 - serial1) / 5;
                serial3 = serial2 + serial1;
                ///change existing element and copy last point
                elem4.endP[0] = localList.GetElem(I).endP[0];
                elem4.endP[1] = localList.GetElem(I).endP[1];
                localList.GetElem(I).endP[1] = point1[1];

                ///add first element
                elem1.startP[0] = localList.GetElem(I).endP[0];
                elem1.startP[1] = localList.GetElem(I).endP[1];
                elem1.endP[0] = point2[0];
                elem1.endP[1] = point1[1];
                elem1.serial = serial3;
                localList.Add(I + 1, elem1);

                ///add second element
                elem2.startP[0] = elem1.endP[0];
                elem2.startP[1] = elem1.endP[1];
                elem2.endP[0] = point2[0];
                elem2.endP[1] = point3[1];
                elem2.serial = elem1.serial + serial2;
                localList.Add(I + 2, elem2);

                ///add third element
                elem3.startP[0] = elem2.endP[0];
                elem3.startP[1] = elem2.endP[1];
                elem3.endP[0] = elem1.startP[0];
                elem3.endP[1] = point3[1];
                elem3.serial = elem2.serial + serial2;
                localList.Add(I + 3, elem3);

                ///add fourth element
                elem4.startP[0] = elem3.endP[0];
                elem4.startP[1] = elem3.endP[1];
                elem4.serial = elem3.serial + serial2;
                localList.Add(I + 4, elem4);

                break;
            }
            case (4): {
                //Random first point
                point1[1] = baseElement.getStartP()[1];
                point1[0] = baseElement.getStartP()[0] + generator.nextInt(baseElement.getEndP()[0] - baseElement.getStartP()[0]);
                //Random third point
                point3[1] = point1[1];
                point3[0] = point1[0] + generator.nextInt(baseElement.getEndP()[0] - point1[0]) + 1;

                if (point1[1] > localList.GetElem(I).getStartP()[1]) {
                    direction = 3;//from bottom to top
                } else {
                    direction = 1;//from top to bottom
                }
                //Random second point
                point2[0] = point3[0];
                if (direction == 1) {
                    if (point1[1] - this.checkDepth(array, point1, point3, direction, 0) > 0) // mało elegancko ale skutecznie
                    {
                        point2[1] = point1[1] - generator.nextInt(point1[1] - this.checkDepth(array, point1, point3, direction, 0)) - 1;
                    } else {
                        point2[1] = point1[1];
                    }
                }

                if (direction == 3) {
                    if (this.checkDepth(array, point1, point3, direction, hight) - point1[1] > 0) {
                        point2[1] = point1[1] + generator.nextInt(this.checkDepth(array, point1, point3, direction, hight) - point1[1]);
                    } else {
                        point2[1] = point1[1];
                    }
                }

                //Start mutation
                serial1 = localList.GetElem(I).getSerial();
                if (I + 1 < localList.Size()) {
                    serial2 = localList.GetElem(I + 1).getSerial();
                } else {
                    serial2 = serial1 + 10000;
                }
                serial2 = (serial2 - serial1) / 5;
                serial3 = serial2 + serial1;
                ///change existing element and copy last point
                elem4.endP[0] = localList.GetElem(I).endP[0];
                elem4.endP[1] = localList.GetElem(I).endP[1];
                localList.GetElem(I).endP[0] = point1[0];

                ///add first element
                elem1.startP[0] = localList.GetElem(I).endP[0];
                elem1.startP[1] = localList.GetElem(I).endP[1];
                elem1.endP[0] = localList.GetElem(I).endP[0];
                elem1.endP[1] = point2[1];
                elem1.serial = serial3;
                localList.Add(I + 1, elem1);

                ///add second element
                elem2.startP[0] = elem1.endP[0];
                elem2.startP[1] = elem1.endP[1];
                elem2.endP[0] = point3[0];
                elem2.endP[1] = point2[1];
                elem2.serial = elem1.serial + serial2;
                localList.Add(I + 2, elem2);

                ///add third element
                elem3.startP[0] = elem2.endP[0];
                elem3.startP[1] = elem2.endP[1];
                elem3.endP[0] = point3[0];
                elem3.endP[1] = elem1.startP[1];
                elem3.serial = elem2.serial + serial2;
                localList.Add(I + 3, elem3);

                ///add fourth element
                elem4.startP[0] = elem3.endP[0];
                elem4.startP[1] = elem3.endP[1];
                elem4.serial = elem3.serial + serial2;
                localList.Add(I + 4, elem4);

                break;
            }

        }
        return localList;//strongly temporary return value
    }

    /**
     * Method is checking possible depth of mutation.
     *
     * @param array Maze as array. Is needed to analyze surround of element
     * @param point1 Start point of segment to check.
     * @param point2 End Point of segment to check.
     * @param direction Direction (or side) of element to analyze.
     * @param max Maximum size of maze to explore.
     * @return int Depth of mutation in indicated direction.
     *
     * @since V2.0 2016-01-22
     */
    private int checkDepth(int[][] array, int[] point1, int[] point2, int direction, int max) {

        int ret = -1;
        boolean found = false;
        int i;
        int j;

        switch (direction) {
            case (1): {

                for (i = point1[1]; i >= max; i--) {
                    for (j = point1[0]; j <= point2[0]; j++) {
                        if ((array[j][i] != 0) && !found) {
                            ret = i + 1;
                            found = true;
                        }
                    }
                }
                if (!found) {
                    ret = i + 1;
                }

                break;
            }
            case (2): {
                for (i = point1[0]; i >= max; i--) {
                    for (j = point1[1]; j <= point2[1]; j++) {
                        if ((array[i][j] != 0) && !found) {
                            ret = i + 1;
                            found = true;
                        }
                    }
                }
                if (!found) {
                    ret = i + 1;
                    break;
                }
            }

            case (3): {
                //Zdebugowane
                for (i = point1[1]; i < max; i++) {
                    for (j = point1[0]; j <= point2[0]; j++) {
                        if ((array[j][i] != 0) && !found) {
                            ret = i - 1;
                            found = true;
                        }
                    }
                }
                if (!found) {
                    ret = i - 1;
                }
                break;
            }
            case (4): {

                //Zdebuggowane
                for (i = point1[0]; i < max; i++) {
                    for (j = point1[1]; j <= point2[1]; j++) {
                        if ((array[i][j] != 0) && !found) {
                            ret = i - 1;
                            found = true;
                        }
                    }
                }
                if (!found) {
                    ret = i - 1;
                }

            }
            break;
        }

        return ret;
    }
}
