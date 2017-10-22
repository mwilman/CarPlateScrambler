package carplatescrambler;

import carplatescrambler.Models.PlateSequence;
import carplatescrambler.PlateBuilder.PlateBuilder;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

class DrawPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setFont(new Font("Verdana", Font.BOLD, 18));
        String derzeitigesWort = GUI.searchword;
        PlateBuilder builder = new PlateBuilder(derzeitigesWort);
        List<PlateSequence> scrabble = builder.scrabble();

        List<String> sequence = scrabble.get(0).getPlateSequence();
        for (int kennzeichenRow = 0; kennzeichenRow <= 3; kennzeichenRow++) {
            for (int kennzeichenColumn = 0; kennzeichenColumn <= 3; kennzeichenColumn++) {
                if ((kennzeichenRow * 4) + kennzeichenColumn < sequence.size()) {
                    generatePlate(g, sequence.get((kennzeichenRow * 4) + kennzeichenColumn), kennzeichenColumn, kennzeichenRow);
                }
            }
        }
    }

    private void generatePlate(Graphics g, String print, int kennzeichenColumn, int kennzeichenRow) {
        int seitenabstand = 10;
        int zwischenAbstand = 10;
        int hoeheKennzeichen = 30;
        int breiteKennzeichen = 150;
        g.drawRect(10 + (seitenabstand * kennzeichenColumn) + (kennzeichenColumn * breiteKennzeichen), zwischenAbstand + (kennzeichenRow * hoeheKennzeichen + kennzeichenRow * 5), breiteKennzeichen, hoeheKennzeichen);
        g.drawString(print, seitenabstand + (seitenabstand * kennzeichenColumn) + 5 + (kennzeichenColumn * breiteKennzeichen), hoeheKennzeichen * (kennzeichenRow + 1) + 5 * (kennzeichenRow + 1));
    }
}
