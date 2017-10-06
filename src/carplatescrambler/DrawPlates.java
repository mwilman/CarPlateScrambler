/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carplatescrambler;

import javax.swing.JFrame;

/**
 *
 * @author Taxim
 */
public class DrawPlates {

    static String derzeitigesWortGUI = "FEHLER";

    public static void paint(String... args) {
        derzeitigesWortGUI = args[0];
        System.out.println(derzeitigesWortGUI);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(700, 200);
        f.add(new DrawPanel());
        f.setVisible(true);
    }
}
