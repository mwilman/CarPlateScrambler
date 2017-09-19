package carplatescrambler;

import carplatescrambler.Dao.Kuerzelliste;
import carplatescrambler.Models.PlateSequence;
import carplatescrambler.PlateBuilder.PlateBuilder;
import java.util.List;

public class CarPlateScrambler {

    static List<String> kuerzelliste;
    static String derzeitigesWort;

    public static void main(String[] args) {
        Kuerzelliste kuerzellisteFile = new Kuerzelliste();
        kuerzelliste = kuerzellisteFile.getFileContent();
        String kuerzelliste_String = kuerzelliste.toString();
        String inFrageKommendeKuerzel = "";

        //Wort festlegen
        derzeitigesWort = "BIBER";
        System.out.println("Wortlänge: " + derzeitigesWort.length() + "\n");

        //Gibt es ein Kuerzel welches auf die ersten Buchstaben gemappt werden kann (B oder BI)
        System.out.println("Passende Anfangs-Kuerzel: ");

        for (int i = 1; i < derzeitigesWort.length() - 1; i++) {
            if (kuerzelliste_String.contains(derzeitigesWort.substring(0, i))) {
                inFrageKommendeKuerzel += derzeitigesWort.substring(0, i) + "\n";
            }
        }
        System.out.println(inFrageKommendeKuerzel);
        
        PlateBuilder plateBuilder = new PlateBuilder(derzeitigesWort);
        List<PlateSequence> Scrabble = plateBuilder.scrabble();

        for (PlateSequence plateSequence : Scrabble) {
            System.out.println(plateSequence.getPlateSequence());
        }
    }
}
