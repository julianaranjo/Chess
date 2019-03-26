package Source;

import java.awt.Dimension;

import javax.swing.JFrame;

/**********************************************************************
 * GUI Class for the Chess Game
 *
 * @author Tyler Dys, Matt Jones, Julia Naranjo
 * @version 3/25/2019
 *********************************************************************/
public class ChessGUI {

    /******************************************************************
     * Main method for initializing the program's GUI
     *
     * @param args optional arguments
     *****************************************************************/
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ChessPanel panel = new ChessPanel();
        frame.getContentPane().add(panel);

        frame.setResizable(true);
        frame.setPreferredSize(new Dimension(800, 637));
        frame.pack();
        frame.setVisible(true);
    }
}
