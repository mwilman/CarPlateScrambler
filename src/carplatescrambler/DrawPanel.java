/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carplatescrambler;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

class DrawPanel extends JPanel {

    int breiteKennzeichen = 150;
    int hoeheKennzeichen = 30;
    int zwischenAbstand = 10;
    int seitenabstand = 10;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setFont(new Font("Verdana", Font.BOLD, 18));

        for (int kennzeichenRow = 0; kennzeichenRow <= 3; kennzeichenRow++) {
            for (int kennzeichenColumn = 0; kennzeichenColumn <=3; kennzeichenColumn++) {
                generatePlate(g, "B-IB 123", kennzeichenColumn, kennzeichenRow);
            }
        }
    }

    public void generatePlate(Graphics g, String print, int kennzeichenColumn, int kennzeichenRow) {
        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + kennzeichenRow * 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString(print, seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 5*(kennzeichenRow+1));
    }
}
