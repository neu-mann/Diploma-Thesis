package view;

import javax.swing.*;
import java.awt.*;

/**
 * Class is using to showing final maze for user. It base on swing library.
 * It is used only in interactive mode.
 * 
 * Its a part of engineering project prepared by author
 * at Silesian University of Technology, Gliwice 
 *
 * @version 2.0 2016-01-22
 * @author Mariusz Nowak
 */
public class SwingView extends JFrame {

    private JLabel label;
    private JPanel jPanel1;
    private static SwingView sv;

    /**
     * Default constructor.
     *
     * @since V2.0 2016-01-22
     */
    public SwingView() {
        super("Labirynt");
        label = new JLabel();
        jPanel1 = new JPanel();
        jPanel1.setLayout(null);
        jPanel1.setBackground(Color.gray);
    }

    /**
     * Parametric constructor. Initialize all component to show on screen.
     *
     * @param array Array with final maze to showing.
     * @param wight Wight of array.
     * @param hight Hight of array.
     *
     *
     * @since V2.0 2016-01-22
     */
    private void init(int array[][], int wight, int hight) {

        for (int y = 0; y < hight; y++) {
            for (int x = 0; x < wight; x++) {
                switch (array[x][y]) {
                    case (-1):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/-1.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (0):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/0.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (3):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/3.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (5):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/5.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (7):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/7.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (9):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/9.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (11):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/11.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (13):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/13.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (15):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/15.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (17):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/17.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (19):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/19.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (21):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/21.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (23):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/23.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (25):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/25.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (27):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/27.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (29):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/29.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                    case (31):
                        label = new JLabel();
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/31.jpg")));
                        label.setBounds(x * 20, (hight - y - 1) * 20, 20, 20);
                        jPanel1.add(label);
                        break;
                }
            }
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(jPanel1);
        pack();
        setSize(600, 600);

        setVisible(true);
    }

    /**
     * Method used for showing maze on screen.
     * It use Swing library.
     * 
     * @param array Array with final maze to showing.
     * @param wight Wight of array.
     * @param hight Hight of array.
     *
     *
     * @since V2.0 2016-01-22
     */
    public void show(int array[][], int wight, int hight) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                init(array, wight, hight);
            }
        });
    }

}
