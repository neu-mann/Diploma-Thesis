package model;

import java.util.Random;

/**
 * Class initialize maze with two points: input and output (method randomIO). Is
 * possible to connect points with line (method routeFirst). Is needed to use
 * both method if you prepare new maze.
 *
 * Its a part of engineering project prepared by author at Silesian University
 * of Technology, Gliwice
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class Intro {

    /**
     * Default constructor.
     *
     * @since V2.0 2016-01-22
     */
    public Intro() {
    }

    /**
     * Method is preparing random input and output on empty maze. Passed maze
     * should be empty, only size is required. Use this method as first before
     * 'routeFirst'.
     *
     * @param mazeDiag Empty mazeDiag class. Only size is required.
     * @return MazeList with two elements. First contain input into maze, second
     * contain output from maze.
     *
     * @since V2.0 2016-01-22
     */
    public MazeList randomIO(MazeList mazeDiag) {

//<<Local variables
        Random generator;       //Random generator
        int[] inputP;           //Table to keep input point coordinates
        int[] outputP;           //Table to keep output point coordinates
        int wight;              //To keep wight
        int hight;              //To keep hight
        Element segmentIn;      //First segment in maze with input point
        Element segmentOut;     //Last segment in maze with output point
        MazeList maze;          //Local maze
        boolean vertical;
        boolean asscending;
        int segmentDirection;
        int r;                  //To keep randm values from generator
        int serial1;
        int serial2;
//>>Local variables

//<<Initialize local variables
        maze = new MazeList(mazeDiag);
        generator = new Random();
        inputP = new int[2];
        outputP = new int[2];
        wight = maze.getWight();
        hight = maze.getHight();
        segmentIn = new Element();
        segmentIn.setSerial(1000);
        segmentOut = new Element();
        segmentOut.setSerial(100000);
        vertical = false;
        asscending = false;
        segmentDirection = 0;
        serial1 = -1;
        serial2 = -1;

//>>Initialize local variables
//<<Prepare input to maze
        r = generator.nextInt(3) + 1;
        //1. Random wall for input
        //if
        //1 - then top
        //2 - then right
        //3 - then bottm
        //4 - then left
        switch (r) {
            case 1: {
                inputP[0] = generator.nextInt(wight - 1);
                inputP[1] = hight - 1;
                vertical = true;
                asscending = false;
                break;
            }
            case 2: {
                inputP[0] = wight - 1;
                inputP[1] = generator.nextInt(hight - 1);
                vertical = false;
                asscending = false;
                break;
            }
            case 3: {
                inputP[0] = generator.nextInt(wight - 1);
                inputP[1] = 0;
                vertical = true;
                asscending = true;
                break;
            }
            case 4: {
                inputP[0] = 0;
                inputP[1] = generator.nextInt(hight - 1);
                vertical = false;
                asscending = true;
                break;
            }
        }
        segmentIn.setStartP(inputP);
        segmentIn.setVertical(vertical);
        segmentIn.setAscending(asscending);
        segmentIn.setSegmentDirection(r);
        maze.Add(segmentIn);
//>>Prepare input to maze

//<<Prepare output from maze
        r = generator.nextInt(3) + 1;

        //1. Random wall for input
        //if
        //1 - then top
        //2 - then right
        //3 - then bottm
        //4 - then left
        switch (r) {
            case 1: {
                outputP[0] = generator.nextInt(wight - 1);
                outputP[1] = hight - 1;
                vertical = true;
                asscending = true;
                segmentDirection = 3;
                break;
            }
            case 2: {
                outputP[0] = wight - 1;
                outputP[1] = generator.nextInt(hight - 1);
                vertical = false;
                asscending = true;
                segmentDirection = 4;
                break;
            }
            case 3: {
                outputP[0] = generator.nextInt(wight - 1);
                outputP[1] = 0;
                vertical = true;
                asscending = false;
                segmentDirection = 1;
                break;
            }
            case 4: {
                outputP[0] = 0;
                outputP[1] = generator.nextInt(hight - 1);
                vertical = false;
                asscending = false;
                segmentDirection = 2;
                break;
            }
        }
        segmentOut.setEndP(outputP);
        segmentOut.setVertical(vertical);
        segmentOut.setAscending(asscending);
        segmentOut.setSegmentDirection(segmentDirection);
        maze.Add(segmentOut);
//>>Prepare output from maze

        return maze;
    }

    /**
     * Method is preparing first random path from input to output. It is very
     * easy way. Passed maze should be initialize with 'randomIO' method.
     *
     * @param mazeDiag take over empty maze, initialized by 'randomIO' method.
     * @return MazeList easy path from input to output.
     *
     * @since V2.0 2016-01-22
     */
    public MazeList routeFirst(MazeList mazeDiag) {

//<<Local variables
        int tmp[];
        int position;
        int point1[];
        int point2[];
        int wight;
        int hight;
        Random generator;
        MazeList maze;
        Element elemBtw;
//>>Local variables

//<<Initialize local variables
        maze = new MazeList(mazeDiag);
        tmp = new int[2];
        point1 = new int[2];
        point2 = new int[2];
        wight = maze.getWight();
        hight = maze.getHight();
        generator = new Random();
        elemBtw = new Element();
        elemBtw.setSerial(10000);
//>>Initialize local variables

//<<Detect relation between input and output
        tmp[0] = maze.Get(0).getStartP()[0] - maze.Get(1).getEndP()[0];
        tmp[1] = maze.Get(0).getStartP()[1] - maze.Get(1).getEndP()[1];
        tmp[0] = Math.abs(tmp[0]);
        tmp[1] = Math.abs(tmp[1]);

        // 1 if input and putput in the same wall
        // 2 if input is in oposite to ouput
        // 3 if input is 90 angle to outpt
        if (tmp[0] == 0 || tmp[0] == wight - 1) {
            position = 1;
        } else {
            if (tmp[1] == 0 || tmp[1] == hight - 1) {
                position = 2;
            } else {
                position = 3;
            }
        }
//>>Detect relation between input and output

        switch (position) {
            case (1):
                point1[0] = generator.nextInt(wight - 2) + 1;
                point1[1] = maze.Get(0).getStartP()[1];
                maze.Get(0).setEndP(point1);

                point2[0] = point1[0];
                point2[1] = maze.Get(1).getEndP()[1];
                maze.Get(1).setStartP(point2);

                elemBtw.setStartP(point1);
                elemBtw.setEndP(point2);
                maze.Add(1, elemBtw);
                break;

            case (2):
                point1[0] = maze.Get(0).getStartP()[0];
                point1[1] = generator.nextInt(hight - 2) + 1;
                maze.Get(0).setEndP(point1);

                point2[0] = maze.Get(1).getEndP()[0];
                point2[1] = point1[1];
                maze.Get(1).setStartP(point2);

                elemBtw.setStartP(point1);
                elemBtw.setEndP(point2);
                maze.Add(1, elemBtw);
                break;
            case (3):
                if (maze.Get(0).getStartP()[0] == 0 || maze.Get(0).getStartP()[0] == wight - 1) {
                    point1[0] = maze.GetElem(1).getEndP()[0];
                    point1[1] = maze.GetElem(0).getStartP()[1];
                    point2[0] = maze.GetElem(1).getEndP()[0];
                    point2[1] = maze.GetElem(0).getStartP()[1];
                } else {
                    point1[0] = maze.GetElem(0).getStartP()[0];
                    point1[1] = maze.GetElem(1).getEndP()[1];
                    point2[0] = maze.GetElem(0).getStartP()[0];
                    point2[1] = maze.GetElem(1).getEndP()[1];
                }

                maze.Get(0).setEndP(point1);
                maze.Get(1).setStartP(point2);
                break;
        }

        return maze;
    }
}
