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
        Scanner reader = new Scanner(System.in); 

        
        System.out.print("Geben Sie das gewünschte Wort ein (Beenden mit: BEENDEN): ");
        while(!"BEENDEN".equals(derzeitigesWort = reader.nextLine().toUpperCase()))
        {
            System.out.println("Wortlänge: " + derzeitigesWort.length() + "\n");

            PlateBuilder plateBuilder = new PlateBuilder(derzeitigesWort);
            List<PlateSequence> scrabble = plateBuilder.scrabble();
            System.out.println("Anzahl Kombinationsmöglichkeiten: "+scrabble.size()+"\n");

            scrabble.stream().forEach((plateSequence) -> {
                System.out.println(plateSequence.getPlateSequence()+"\n");
            });
            System.out.print("Geben Sie das gewünschte Wort ein (Beenden mit: BEENDEN): ");
        }
        
    }
}
