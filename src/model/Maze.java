package model;

import java.util.Random;
import java.util.Scanner;
import view.SwingView;
import view.View;

/**
 * This class is responsible for preparing final maze.
 *
 * Its a part of engineering project prepared by author at Silesian University
 * of Technology, Gliwice
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class Maze {

    public Maze() {
    }
    private Population population;

    public void create(int sizex, int sizey, float fill, Boolean interactive) {

        MazeList mazeDiagram;
        MazeList mutedDiagram;
        Element tmpE;
        int tmpP[];
        Intro intro;
        Transfer transfer;
        int array[][];
        Mutation mute;
        MazeList tmp;
        View view;
        int nbr;
        int elemToMutation;
        Random generator;
        int size;

        int sizePopulation;
        Scanner scanner;
        String word;
        //float fill;
        float quarter;
        int serial;
        int inc;
        int nbrMutaion;
        Snail snail;
        SwingView swingView;

//<<Init part
        mazeDiagram = new MazeList(sizex, sizey);
        mutedDiagram = new MazeList();
        tmpE = new Element();
        tmpP = new int[2];
        intro = new Intro();
        transfer = new Transfer();
        array = new int[sizex][sizey];
        mute = new Mutation();
        tmp = new MazeList();
        view = new View();
        generator = new Random();
        snail = new Snail();
        swingView = new SwingView();
        size = 0;
        word = "";
        serial = 0;
        inc = 0;
        tmpP[0] = 100;
        tmpP[1] = 100;
        tmpE.setStartP(tmpP);
        population = new Population();
        sizePopulation = 1;
        scanner = new Scanner(System.in);
        //fill = 50;
        quarter = 100;
        nbrMutaion = 20;

        int average = 0;
        int averageq = 10000;
        int counter = 0;
        int longest = 100;
        population.Generate(sizePopulation, sizex, sizey);

        //Show state after initialisation
        if (interactive) {
            for (MazeList M : population.getPopulation()) {
                view.showText("\n");
                array = transfer.proceed(M);
                view.show(array, sizex, sizey);
                view.showText("\n Serial: " + M.serial + "\n");
            }
        }

        while ((average < ((fill / 100) * sizex * sizey)) && (counter < 10000)) {

            average = 0;
            averageq = 0;
            counter++;

            //Make mutation of population
            for (MazeList M : population.getPopulation()) {
                mutedDiagram = M.getCopy();

                if (M.Size() > 0) {
                    for (int x = 0; x < nbrMutaion; x++) {
                        mutedDiagram.deBug();

                        elemToMutation = mute.findByOrder(mutedDiagram.getCopy(), generator.nextInt(M.Size()));
                        if (elemToMutation >= 0) {
                            mutedDiagram = mute.mute(mutedDiagram.getCopy(), elemToMutation);
                            mutedDiagram.deBug();
                        }
                        M.SetList(mutedDiagram);
                    }
                    M.setGeneration(M.getGeneration() + 1);
                }

                average += M.getLength();
                averageq += M.getDivision()[0];

            }

            average /= population.getSize();
            averageq /= population.getSize();

            //Show again after mutation
            if (interactive) {
                for (MazeList M : population.getPopulation()) {
                    array = transfer.proceed(M);
                    view.show(array, sizex, sizey);
                    view.showText("\n Pokolenie: " + M.getGeneration());
                    view.showText("\n Długość labiryntu: " + M.getLength());
                    view.showText("\n Procent w ćwiartce 1: " + M.getDivision()[0]);
                    view.showText("Procent w ćwiartce 2: " + M.getDivision()[1]);
                    view.showText("Procent w ćwiartce 3: " + M.getDivision()[2]);
                    view.showText("Procent w ćwiartce 4: " + M.getDivision()[3]);
                }
            }

            //Remove maize tahat not mute
            for (int x = 0; x < population.getSize(); x++) {

                if (population.getMaze(x).getLase() > 50) {
                    population.add(x, new MazeList(sizex, sizey));
                    population.getMaze(x).setSerial(population.getPopulation().getLast().getSerial() + 1);
                    if (interactive) {
                        view.showText("\n Labirynt o numerze seryjnym: " + population.getMaze(x + 1).getSerial());
                        view.showText("nie portafi dalej mutować. Zastępuję go nowym, i pracuję dalej.");
                    }
                    population.Remove(x + 1);
                } else {
                    if (population.getMaze(x).getLastSize() == population.getLength(x)) {
                        population.getMaze(x).setLase(population.getMaze(x).getLase() + 1);
                    } else {
                        population.getMaze(x).setLase(0);
                    }

                    population.getMaze(x).setLastSize(population.getLength(x));
                }
            }

        }

        if (counter >= 10000) {
            if (interactive) {
                view.showText("\n Nie potrafię wygenerować żądanego labiryntu. Zmień proszę parametry.");
            }
        } else {
            if (interactive) {
                view.showText("\n Zakończyłem pracę z sukcesem.\n");
            }

            //Make snails
            for (MazeList M : population.getPopulation()) {
                array = transfer.proceed(M);
                array = snail.proceed(array, sizex, sizey);
                if (interactive) {
                    view.show(array, sizex, sizey);
                }
            }
        }

//>>Body
    }

    public int[][] getArray(int I) {

        Transfer transfer;
        Snail snail;
        int[][] array;
        transfer = new Transfer();
        snail = new Snail();

        array = transfer.proceed(population.getMaze(I));
        array = snail.proceed(array, population.getMaze(I).getWight(), population.getMaze(I).getHight());
        return array;
    }

    public MazeList getList(int I) {

        return population.getMaze(I);
    }

}
