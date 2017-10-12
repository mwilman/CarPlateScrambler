
package carplatescrambler;

import javax.swing.JFrame;

public class DrawPlates {

    static String derzeitigesWortGUI = "FEHLER";

    public static void paint(String... args) {
        derzeitigesWortGUI = args[0];
        System.out.println("Eingegebenes Wort: "+derzeitigesWortGUI);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(700, 200);
        f.add(new DrawPanel());
        f.setVisible(true);
    }
}
