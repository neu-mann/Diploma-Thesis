package model;

/**
 * Class can prepare dead ends for maze. Is needed to use only method "proceed".
 * We call dead ends as "snail" because on the big area algorithm make kind of
 * wortex.
 *
 * Its a part of engineering project prepared by author at Silesian University
 * of Technology, Gliwice
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class Snail {

    /**
     * Default constructor.
     *
     * @since V2.0 2016-01-22
     */
    public Snail() {
    }

    /**
     * Use this method to prepare dead ends on maze.
     *
     * @param array[][] Array to proceeding
     * @param wight put here width of maze
     * @param hight put here hight of maze
     * @return int[][] take here maze after proceeding.
     *
     * @since V2.0 2016-01-22
     */
    public int[][] proceed(int array[][], int wight, int hight) {

        boolean black;

        //store input and output
        for (int y = 0; y < hight; y++) {
            for (int x = 0; x < wight; x++) {

                if (array[x][y] == 15 || array[x][y] == 23 || array[x][y] == 27 || array[x][y] == 29) {
                    array[x][y] = -1;
                }
            }
        }

        //Find places to put snail.
        //We find from top to bottom and from left to right.
        //This snail is clockwise
        for (int y = hight - 1; y >= 0; y--) {
            black = false;
            for (int x = 0; x < wight; x++) {

                if ((array[x][y] > 0) && (black == false)) {
                    black = true;
                }

                if ((array[x][y] == 0) && (black == true)) {
                    black = false;
                    toRight(array, wight, hight, x - 1, y, 1);
                }
            }
        }

        //Find places to put snail.
        //We seek from bottom to top and from right to left.
        //This snail is clockwise
        for (int y = 0; y < hight; y++) {
            black = false;
            for (int x = wight - 1; x >= 0; x--) {

                if ((array[x][y] > 0) && (black == false)) {
                    black = true;
                }

                if ((array[x][y] == 0) && (black == true)) {
                    black = false;
                    toLeft(array, wight, hight, x + 1, y, 2);
                }
            }
        }

        return array;
    }

    /**
     * Fill free space from left to right.
     *
     * @param array[][] Array to proceeding
     * @param wight Put here width of maze
     * @param hight Put here hight of maze
     * @param x X Coordinate of start point
     * @param y Y Coordinate of start point
     * @param dir Indicate that maze is searching from top top bottom (1) or
     * from bottom to top (2).
     *
     * @since V2.0 2016-01-22
     */
    private void toRight(int array[][], int wight, int hight, int x, int y, int dir) {

        int i;
        //open cell into right
        array[x][y] -= 4;

        for (i = x + 1; i < wight; i++) {

            if (array[i][y] == 0) {
                array[i][y] = 11;
            } else {
                break;
            }
        }
        //close last cell
        array[i - 1][y] += 4;
        //if(dir ==1)
        toDown(array, wight, hight, i - 1, y, dir);
    }

    /**
     * Fill free space from top to bottom.
     *
     * @param array[][] Array to proceeding
     * @param wight Put here width of maze
     * @param hight Put here hight of maze
     * @param x X Coordinate of start point
     * @param y Y Coordinate of start point
     * @param dir Indicate that maze is searching from top top bottom (1) or
     * from bottom to top (2).
     *
     * @since V2.0 2016-01-22
     */
    private void toDown(int array[][], int wight, int hight, int x, int y, int dir) {

        int i;
        //Open cell into bottom
        array[x][y] -= 8;

        for (i = y - 1; i >= 0; i--) {

            if (array[x][i] == 0) {
                array[x][i] = 21;
            } else {
                break;
            }
        }
        //close last cell
        array[x][i + 1] += 8;
        if (dir == 1) {
            toLeft(array, wight, hight, x, i + 1, dir);
        }
    }

    /**
     * Fill free space from right to left.
     *
     * @param array[][] Array to proceeding
     * @param wight Put here width of maze
     * @param hight Put here hight of maze
     * @param x X Coordinate of start point
     * @param y Y Coordinate of start point
     * @param dir Indicate that maze is searching from top top bottom (1) or
     * from bottom to top (2).
     *
     * @since V2.0 2016-01-22
     */
    private void toLeft(int array[][], int wight, int hight, int x, int y, int dir) {

        int i;
        //open cell into left
        array[x][y] -= 16;

        for (i = x - 1; i >= 0; i--) {

            if (array[i][y] == 0) {
                array[i][y] = 11;
            } else {
                break;
            }
        }
        //cloce last cell
        array[i + 1][y] += 16;
        //if(dir ==1)
        toTop(array, wight, hight, i + 1, y, dir);
    }

    /**
     * Fill free space from bottom to top.
     *
     * @param array[][] Array to proceeding
     * @param wight Put here width of maze
     * @param hight Put here hight of maze
     * @param x X Coordinate of start point
     * @param y Y Coordinate of start point
     * @param dir Indicate that maze is searching from top top bottom (1) or
     * from bottom to top (2).
     *
     * @since V2.0 2016-01-22
     */
    private void toTop(int array[][], int wight, int hight, int x, int y, int dir) {

        int i;
        //Open cell into top
        array[x][y] -= 2;

        for (i = y + 1; i < hight; i++) {

            if (array[x][i] == 0) {
                array[x][i] = 21;
            } else {
                break;
            }
        }
        //Close last cell
        array[x][i - 1] += 2;
        if (dir == 2) {
            toRight(array, wight, hight, x, i - 1, dir);
        }
    }

}
