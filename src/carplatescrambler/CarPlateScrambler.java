package carplatescrambler;

import carplatescrambler.Dao.Kuerzelliste;
import carplatescrambler.Models.PlateSequence;
import carplatescrambler.PlateBuilder.PlateBuilder;
import java.util.List;
import java.util.Scanner;

class CarPlateScrambler {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); 

        
        System.out.print("Geben Sie das gewünschte Wort ein (Beenden mit: BEENDEN): ");
        String derzeitigesWort;
        while(!"BEENDEN".equals(derzeitigesWort = reader.nextLine().toUpperCase()))
        {
            if(derzeitigesWort.matches("^[öÖäÄüÜa-zA-Z]*$"))
            {
                System.out.println("Wortlänge: " + derzeitigesWort.length() + "\n");

                PlateBuilder plateBuilder = new PlateBuilder(derzeitigesWort);
                List<PlateSequence> scrabble = plateBuilder.scrabble();
                System.out.println("Anzahl Kombinationsmöglichkeiten: "+scrabble.size()+"\n");

                scrabble.forEach((plateSequence) -> System.out.println(plateSequence.getPlateSequence()+"\n"));
            } else {
                System.err.println("FEHLER: Bitte keine Sonderzeichen oder Zahlen eingeben!");
            }
            System.out.print("Geben Sie das gewünschte Wort ein (Beenden mit: BEENDEN): ");
        }
        
    }
}
