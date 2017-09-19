package carplatescrambler.PlateBuilder;

import carplatescrambler.Dao.Kuerzelliste;
import carplatescrambler.Models.PlateSequence;
import carplatescrambler.PlateExtractor.Extractor;
import carplatescrambler.Models.Possibility;
import java.util.ArrayList;
import java.util.List;
import carplatescrambler.Dao.IKuerzelliste;

public class PlateBuilder {

    private final String ScrabbleString;
    
    public PlateBuilder(String ScrabbleString) {
        this.ScrabbleString = ScrabbleString;
    }
    
    public List<PlateSequence> scrabble()
    {
        Extractor Extractor = new Extractor(ScrabbleString);
        List<Possibility> Possibilities = Extractor.extract();
        
        List<PlateSequence> PlateSequences = buildPlateSequencesWithPossibilities(Possibilities);
 
        return PlateSequences;
    }
    
    
    private List<PlateSequence> buildPlateSequencesWithPossibilities(List<Possibility> Possibilities)
    {
        List<PlateSequence> PlateSequences = new ArrayList<>();
        Extractor Extractor = new Extractor(ScrabbleString);
        
        for(int i=0; i<Possibilities.size(); i++)
        {
            
            if(validateLocation(Possibilities.get(i).getLocationPart()))
            {
                if( Possibilities.get(i).getRestString().length() == 0)
                {
                    PlateSequence PlateSequence = new PlateSequence();
                    PlateSequence.addToPlateSequence(buildPlate(Possibilities.get(i)));
                    PlateSequences.add(PlateSequence);
                } else if(Possibilities.get(i).getRestString().length() > 1)
                {
                    //TODO Der Lesbarkeithalber, sollte das hier in Methoden aufgeteilt werden?
                    PlateSequence PlateSequence = new PlateSequence();
                    PlateSequence.addToPlateSequence(buildPlate(Possibilities.get(i)));
                    
                    PlateBuilder PlateBuilder = new PlateBuilder(Possibilities.get(i).getRestString());
                    List<PlateSequence> Extracted = PlateBuilder.scrabble();
                    if(Extracted.size() > 1)
                    {
                        PlateSequence.addToPlateSequence(Extracted.get(0).getPlateAt(0));
                        
                        for(int j=0; j < Extracted.size(); j++)
                        {
                            PlateSequence = new PlateSequence();
                            PlateSequence.addToPlateSequence(buildPlate(Possibilities.get(i)));
                            PlateSequence.addToPlateSequence(Extracted.get(j).getPlateAt(0));
                            PlateSequences.add(PlateSequence);
                        }
                    } else {
                        PlateSequence.addToPlateSequence(Extracted.get(0).getPlateAt(0));
                        PlateSequences.add(PlateSequence);
                    }  
                }
            }
        }
        return PlateSequences;
    }
    
    private String buildPlate(Possibility Pos)
    {
        return Pos.getLocationPart() + " - " + Pos.getMidPart() + " 123";
    }
    
    private boolean validateLocation(String LocationPart)
    {
        List<String> FileContent;
        IKuerzelliste File = new Kuerzelliste();
        
        FileContent = File.getFileContent();
        
        return FileContent.contains(LocationPart);
    }
}
