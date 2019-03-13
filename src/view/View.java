package view;

import static java.lang.System.out;

/**
 * Class is using to showing diagnostic information for user on console. It is
 * used only in interactive mode.
 *
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 * 
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class View {

    /**
     * Default constructor.
     *
     * @since V2.0 2016-01-22
     */
    public View() {
    }

    /**
     * Method used for showing maze on console. It use character representation
     * on console. Unicode is using.
     *
     * @param array Array with final maze to showing.
     * @param wight Wight of array.
     * @param hight Hight of array.
     *
     *
     * @since V2.0 2016-01-22
     */
    public void show(int array[][], int wight, int hight) {

        for (int y = hight - 1; y >= 0; y--) {
            out.println();
            for (int x = 0; x < wight; x++) {
                switch (array[x][y]) {
                    case (-1):
                        System.out.printf("\u2593");
                        break;
                    case (0):
                        System.out.printf("\u2591");
                        break;
                    case (3):
                        System.out.printf("\u2566");
                        break;
                    case (5):
                        System.out.printf("\u2563");
                        break;
                    case (7):
                        System.out.printf("\u2557");
                        break;
                    case (9):
                        System.out.printf("\u2569");
                        break;
                    case (11):
                        System.out.printf("\u2550");
                        break;
                    case (13):
                        System.out.printf("\u255D");
                        break;
                    case (15):
                        System.out.printf("\u2561");
                        break;
                    case (17):
                        System.out.printf("\u2560");
                        break;
                    case (19):
                        System.out.printf("\u2554");
                        break;
                    case (21):
                        System.out.printf("\u2551");
                        break;
                    case (23):
                        System.out.printf("\u2565");
                        break;
                    case (25):
                        System.out.printf("\u255A");
                        break;
                    case (27):
                        System.out.printf("\u255E");
                        break;
                    case (29):
                        System.out.printf("\u2568");
                        break;
                }
            }
        }
        System.out.printf("\n");
    }

    public void showText(String S) {

        
         System.out.println(S);                 
                 
    }

}
