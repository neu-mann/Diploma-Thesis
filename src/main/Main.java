package main;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import model.MazeList;
import model.Maze;
import java.util.Scanner;
import view.SwingView;
import view.View;

/**
 * Class contain controller of application.
 * 
 * Its a part of engineering project prepared by author at Silesian University
 * of Technology, Gliwice
 * 
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class Main {

    public static void main(String[] args) {
        String sizex;
        String sizey;
        MazeList mutedDiagram;
        int array[][];
        Scanner scanner;
        String fill;
        int nbrMutaion;
        Maze maze;
        SwingView swingView;
        View view;
        int param0;
        int param1;
        int param2;
        String param3;

//<<Init part
        fill = "";
        nbrMutaion = 20;
        scanner = new Scanner(System.in);
        maze = new Maze();
        swingView = new SwingView();
        view = new View();
        param0 = 0;
        param1 = 0;
        param2 = 0;
        param3 = "";
//Init part>>

//<<Body
        // number of parameters passed to the program
        int paramtersNumber = args.length;

        if (paramtersNumber > 0 && paramtersNumber < 4) {

            //to less parameters
            System.err.println("Za mało argumentów wywołania aplikacji");
            System.exit(1);
        }

        if (paramtersNumber == 4) {

            //bath mode
            try {
                param0 = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[0] + " musi byc liczbą");
                System.exit(1);
            }
            if (param0 < 4 || param0 > 100) {
                System.err.println("niewłaściwy zakres parametru 0");
                System.exit(1);
            }

            try {
                param1 = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[1] + " musi byc liczbą");
                System.exit(1);
            }
            if (param1 < 4 || param1 > 100) {
                System.err.println("niewłaściwy zakres parametru 1");
                System.exit(1);
            }

            try {
                param2 = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[2] + " musi byc liczbą");
                System.exit(1);
            }
            if (param2 < 20 || param2 > 90) {
                System.err.println("niewłaściwy zakres parametru 2");
                System.exit(1);
            }
            param3 = args[3];

            maze.create(param0, param1, param2, false);
            mutedDiagram = maze.getList(0);
            array = maze.getArray(0);
            saveFile(param3, array);
        }

        if (paramtersNumber == 0) {
            //Interactve mode
            //Read init data from user

            view.showText("Witaj w generatorze labiryntu. Będę od Ciebie potrzebował kilka danych zanim rozpocznę. \n");
            view.showText("Podaj szerokość labiryntu (mi n4, max 100):");
            sizex = scanner.nextLine();
            try {
                param0 = Integer.parseInt(sizex);
            } catch (NumberFormatException e) {
                System.err.println("Argument musi byc liczbą");
                System.exit(1);
            }
            if (param0 < 4 || param0 > 100) {
                System.err.println("niewłaściwy zakres parametru 1");
                System.exit(1);
            }

            view.showText("\nPodaj wysokość labiryntu (min 4, max 100): ");
            sizey = scanner.nextLine();
            try {
                param1 = Integer.parseInt(sizey);
            } catch (NumberFormatException e) {
                System.err.println("Argument musi byc liczbą");
                System.exit(1);
            }
            if (param1 < 4 || param1 > 100) {
                System.err.println("niewłaściwy zakres parametru 2");
                System.exit(1);
            }

            view.showText("\nPodaj stopień wypełnienia ścieżką główną (min 20, max 90): ");
            fill = scanner.nextLine();
            try {
                param2 = Integer.parseInt(fill);
            } catch (NumberFormatException e) {
                System.err.println("Argument musi byc liczbą");
                System.exit(1);
            }
            if (param2 < 20 || param2 > 90) {
                System.err.println("niewłaściwy zakres parametru 3");
                System.exit(1);
            }

            maze.create(param0, param1, param2, true);
            mutedDiagram = maze.getList(0);
            array = maze.getArray(0);
            swingView.show(array, param0, param1);
        }

//>>Body
    }

    // Method can save file into storage
    public static void saveFile(String nazwaPliku, int[][] dane) {

        //Temporary translation
        int i, j;

        // Create Path
        Path sciezka = Paths.get(nazwaPliku);
        ArrayList<String> out = new ArrayList<>();

        //Take row of data
        for (int[] seria : dane) {
            String s = Arrays.toString(seria);
            s = s.replace("[", "");
            s = s.replace("]", "");
            // put data to list
            out.add(s);
        }
        try {
            Files.write(sciezka, out);
        } catch (IOException ex) {
            System.err.println("Nie mogę zapisać pliku!");
        }
    }

}
