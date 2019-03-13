package model;

/**
 * Class can keep populations of specimens (individual mazes). In genetic
 * algorithm "1+1" we use only one maze in population. In genetic algorithm
 * "µ+λ" population can be much bigger. Is possible to use this class to keep
 * bigger population.
 *
 * Selection or crossbreeding is out of this class.
 *
 * Its a part of engineering project prepared by author at Silesian University
 * of Technology, Gliwice
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
import java.util.LinkedList;

public class Population {

    private LinkedList<MazeList> population;   //list with whole population
    private Intro intro;                       //auxilairy calss for initialize population

    /**
     * Default constructor.
     *
     * @since V2.0 2016-01-22
     */
    public Population() {
        this.population = new LinkedList();
        this.intro = new Intro();
    }

    /**
     * Generate new population.
     *
     * @param nbr Set number of mazes in population.
     * @param sizeX Set height of each maze.
     * @param sizeY Set wight of each maze.
     *
     * @since V2.0 2016-01-22
     */
    public void Generate(int nbr, int sizeX, int sizeY) {
        int serial = this.population.size();
        for (int i = 1; i <= nbr; i++) {
            population.add(new MazeList(sizeX, sizeY));
            population.getLast().serial = serial + i;
        }

    }

    /**
     * Return list of mazes.
     *
     * @return MazeList
     *
     * @since V2.0 2016-01-22
     */
    public LinkedList<MazeList> getPopulation() {
        return this.population;
    }

    /**
     * Return information how many mazes are in population.
     *
     * @return int
     *
     * @since V2.0 2016-01-22
     */
    public int getSize() {
        return this.population.size();
    }

    /**
     * Remove indicate maze from population.
     *
     * @param I Maze to be removed.
     *
     * @since V2.0 2016-01-22
     */
    public void Remove(int I) {
        this.population.remove(I);
    }

    /**
     * Add new maze to population.
     *
     * @param index Place to insert maze in population.
     * @param M Maze to be add.
     *
     * @since V2.0 2016-01-22
     */
    public void add(int index, MazeList M) {
        this.population.add(index, M);
    }

    /**
     * Get length of indicated maze in population.
     *
     * @param index Number of maze to be checked.
     * @return int Size of maze.
     *
     * @since V2.0 2016-01-22
     */
    public int getLength(int index) {
        return this.population.get(index).getLength();
    }

    /**
     * Get size of indicated maze in population.
     *
     * @param index Number of maze to be checked.
     * @return int Size of maze.
     *
     * @since V2.0 2016-01-22
     */
    public int getSize(int index) {
        return this.population.get(index).Size();
    }

    /**
     * Get maze from population.
     *
     * @param index Number of maze to be returned.
     * @return MazeList Maze requested by user..
     *
     * @since V2.0 2016-01-22
     */
    public MazeList getMaze(int index) {
        return this.population.get(index);
    }

    /**
     * Exchange maze existing in population into new one..
     *
     * @param index Number of maze to be exchange.
     * @param M Number of maze to exchange.
     *
     * @since V2.0 2016-01-22
     */
    public void setMaze(int index, MazeList M) {
        this.population.add(index, M);
        this.population.remove(index + 1);
    }

    /**
     * Get number of longest maze in population.
     *
     * @return int Number of longest maze..
     *
     * @since V2.0 2016-01-22
     */
    public int getLongest() {
        int ret = 0;
        for (MazeList M : this.population) {

            if (M.getLength() > ret) {
                ret = M.getLength();
            }
        }
        return ret;
    }

    /**
     * Get number of biggest maze in population.
     *
     * @return int Number of biggest maze..
     *
     * @since V2.0 2016-01-22
     */
    public int getBiger() {
        int ret = 0;
        for (MazeList M : this.population) {

            if (M.Size() > ret) {
                ret = M.Size();
            }
        }
        return ret;
    }

    /**
     * Method return 4 element int table with information about percentage
     * filling maze by elements. Information are prepared for each quarter of
     * maze. It is in table: position 0 - for left bottom q, position 1 - for
     * left top q. position 2 - for right top q, position 3 - for right bottom
     * q.
     *
     * @param index Indicate maze to check.
     *
     * @return int[] Table with information about filling for each quarter.
     *
     * @since V2.0 2016-01-22
     */
    public int[] getDivision(int index) {

        //1 quarter - left bottom
        //2 quarter - left top
        //3 quarter - rght top
        //4 quarter - right bottom
        int sizex = this.population.get(index).getWight();
        int sizey = this.population.get(index).getHight();
        Transfer transfer = new Transfer();
        int array[][] = new int[sizex][sizey];
        int ret[] = new int[4];

        array = transfer.proceed(this.getMaze(index));

        //check 1 quarter
        for (int x = 0; x < sizex / 2; x++) {
            for (int y = 0; y < sizey / 2; y++) {
                if (array[x][y] != 0) {
                    ret[0]++;
                }
            }
        }

        //check 3 quarter
        for (int x = 0; x < sizex / 2; x++) {
            for (int y = (sizey / 2); y < sizey; y++) {
                if (array[x][y] != 0) {
                    ret[1]++;
                }
            }
        }

        //check 3 quarter
        for (int x = (sizex / 2); x < sizex; x++) {
            for (int y = (sizey / 2); y < sizey; y++) {
                if (array[x][y] != 0) {
                    ret[2]++;
                }
            }
        }

        //check 4 quarter
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

}
