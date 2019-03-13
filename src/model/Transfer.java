package model;

import java.util.LinkedList;

/**
 * This class is used to Transfer data from MazeList into array. We take
 * following convention to indicate cells in array: 0 - Cell is not used 1 -
 * Cell is in maze area 2 - Cell has top wall 4 - Cell has right wall 8 - Cell
 * has bottom wall 16 - Cell has left wall. * Is possible to use some of numbers
 * for one cell. E. g.
 *
 * 21 - Cell has left and right wall and is part of maze 10 - Cell has top and
 * bottom wall but is not a part of maze
 *
 * Its a part of engineering project prepared by author at Silesian University
 * of Technology, Gliwice
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class Transfer {

    //<<Local variables
    private MazeList maze;          //Local list
    private int array[][];          //Localmaze as array
    //>>Local variables

    /**
     * Default constructor.
     *
     * @since V2.0 2016-01-22
     */
    public Transfer() {
        this.maze = new MazeList();  // create local mazeList
        array = new int[maze.getWight()][maze.getHight()]; //Create local array

    }

    /**
     * Parametric constructor.
     *
     * @param L Take over mazeList to transferring
     *
     * @since V2.0 2016-01-22
     */
    public Transfer(MazeList L) {

        int wight;
        int hight;

        this.maze = new MazeList(L);    // create local mazeList
        wight = maze.getWight();
        hight = maze.getHight();

        array = new int[wight][hight]; //Create local array

        //init array with zeros
        for (int x = 0; x < wight; x++) {
            for (int y = 0; y < hight; y++) {
                this.array[x][y] = 0;
            }
        }
    }

    /**
     * Use this method to transfer maze from MazeList to array.
     *
     * @param L Put here mazeList to transfer.
     * @return int[][] Take return value with maze as array.
     * @since V2.0 2016-01-22
     */
    public int[][] proceed(MazeList L) {

        int wight;
        int hight;
        int tmp;
        int i;
        LinkedList<Element> localList;

        this.maze = new MazeList(L);
        wight = maze.getWight();
        hight = maze.getHight();
        localList = maze.getList();

        array = new int[wight][hight]; //Create local array

        //init array with zeros
        for (int x = 0; x < wight; x++) {
            for (int y = 0; y < hight; y++) {
                this.array[x][y] = 0;
            }
        }

        //Each segmnet convert into array
        for (Element E : localList) {

            switch (E.getsegmentDirection()) {
                case (1):
                    i = E.getStartP()[1];
                    if (this.array[E.getStartP()[0]][i] == 0) {
                        this.array[E.getStartP()[0]][i] = 23;
                    } else {
                        this.array[E.getStartP()[0]][i] -= 8;
                    }
                    i--;

                    for (; i >= E.getEndP()[1]; i--) {
                        this.array[E.getStartP()[0]][i] = 21;
                    }
                    this.array[E.getStartP()[0]][i + 1] = 29; //Other value to last positions
                    break;

                case (2):
                    i = E.getStartP()[0];
                    if (this.array[i][E.getStartP()[1]] == 0) {
                        this.array[i][E.getStartP()[1]] = 15;
                    } else {
                        this.array[i][E.getStartP()[1]] -= 16;
                    }
                    i--;

                    for (; i >= E.getEndP()[0]; i--) {
                        this.array[i][E.getStartP()[1]] = 11;
                    }
                    //this.array[i + 1][E.getStartP()[1]] = 27;//Other value to last positions
                    this.array[E.getEndP()[0]][E.getStartP()[1]] = 27;//Other value to last positions
                    break;

                case (3):
                    i = E.getStartP()[1];
                    if (this.array[E.getStartP()[0]][i] == 0) {
                        this.array[E.getStartP()[0]][i] = 29;
                    } else {
                        this.array[E.getStartP()[0]][i] -= 2;
                    }
                    i++;

                    for (; i <= E.getEndP()[1]; i++) {
                        this.array[E.getStartP()[0]][i] = 21;
                    }
                    this.array[E.getStartP()[0]][i - 1] = 23;//Other value to last positions
                    break;

                case (4):
                    i = E.getStartP()[0];
                    if (this.array[i][E.getStartP()[1]] == 0) {
                        this.array[i][E.getStartP()[1]] = 27;
                    } else {
                        this.array[i][E.getStartP()[1]] -= 4;
                    }
                    i++;

                    for (; i <= E.getEndP()[0]; i++) {
                        this.array[i][E.getStartP()[1]] = 11;
                    }
                    this.array[E.getEndP()[0]][E.getStartP()[1]] = 15;//Other value to last positions
                    break;
            }

        }
        return this.array;

    }

    /**
     * This method make mirror reflection on x coordinate. Is possible use this
     * method before sending maze to another systems.
     *
     * @param array[][] Array to transposing
     * @param sizeX put here width of maze
     * @param sizeY put here hight of maze
     * @return int[][] take here maze after transformation.
     * @since V2.0 2016-01-22
     */
    public int[][] transpose(int array[][], int sizeX, int sizeY) {

        int x, y;
        int[][] tmp_array = new int[sizeY][sizeX];

        for (x = 0; x < sizeX; x++) {
            for (y = 0; y < sizeY; y++) {
                tmp_array[sizeY - y - 1][x] = this.array[x][y];
            }

        }

        return tmp_array;
    }
}
