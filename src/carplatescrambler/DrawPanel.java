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
        int kennzeichenColumn = 0;
        int kennzeichenRow = 0;
        setFont(new Font("Verdana", Font.BOLD, 18));

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand, breiteKennzeichen, hoeheKennzeichen);
        g.drawString("B-IB 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen + 5);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand, breiteKennzeichen, hoeheKennzeichen);
        g.drawString("E-R 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen + 5);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand, breiteKennzeichen, hoeheKennzeichen);
        g.drawString("T-E 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen + 5);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand, breiteKennzeichen, hoeheKennzeichen);
        g.drawString("S-T 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen + 5);
        kennzeichenColumn++;

        kennzeichenColumn = 0;
        kennzeichenRow++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("MAX-IM 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 10);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("I-ST 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 10);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("TO-LL 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 10);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("J-A 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 10);
        kennzeichenColumn++;

        kennzeichenColumn = 0;
        kennzeichenRow++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + kennzeichenRow * 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("MAX-IM 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 15);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + kennzeichenRow * 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("I-ST 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 15);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + kennzeichenRow * 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("TO-LL 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 15);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + kennzeichenRow * 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("J-A 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 15);
        kennzeichenColumn++;

        kennzeichenColumn = 0;
        kennzeichenRow++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + kennzeichenRow * 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("MAX-IM 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 20);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + kennzeichenRow * 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("I-ST 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 20);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + kennzeichenRow * 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("TO-LL 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 20);
        kennzeichenColumn++;

        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + kennzeichenRow * 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString("J-A 123", seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 20);
        kennzeichenColumn++;

    }
}
