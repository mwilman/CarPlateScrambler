package carplatescrambler;

import carplatescrambler.Dao.Kuerzelliste;
import carplatescrambler.Models.PlateSequence;
import carplatescrambler.PlateBuilder.PlateBuilder;
import java.util.List;
import java.util.Scanner;

public class CarPlateScrambler {

    static List<String> kuerzelliste;
    static String derzeitigesWort;

    public static void main(String[] args) {
        Kuerzelliste kuerzellisteFile = new Kuerzelliste();
        kuerzelliste = kuerzellisteFile.getFileContent();

        //Wort festlegen
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Geben Sie das gewünschte Wort ein: ");
        derzeitigesWort = reader.nextLine().toUpperCase(); // Scans the next token of the input as an int.
        System.out.println("Wortlänge: " + derzeitigesWort.length() + "\n");

        PlateBuilder plateBuilder = new PlateBuilder(derzeitigesWort);
        List<PlateSequence> Scrabble = plateBuilder.scrabble();

        for (PlateSequence plateSequence : Scrabble) {
            System.out.println(plateSequence.getPlateSequence());
        }
    }
}
