package carplatescrambler;

import carplatescrambler.Dao.Kuerzelliste;
import carplatescrambler.Models.PlateSequence;
import carplatescrambler.PlateBuilder.PlateBuilder;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CarPlateScrambler {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); 

        
        System.out.print("Geben Sie das gewünschte Wort ein (Beenden mit: BEENDEN): ");
        String derzeitigesWort;
        while(!"BEENDEN".equals(derzeitigesWort = reader.nextLine().toUpperCase()))
        {
            Pattern p = Pattern.compile("[^öÖäÄüÜa-zA-Z]*$");
            Matcher m = p.matcher(derzeitigesWort);
            if(!m.find())
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
