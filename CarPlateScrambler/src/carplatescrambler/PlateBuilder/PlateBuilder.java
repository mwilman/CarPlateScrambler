package carplatescrambler.PlateBuilder;

import carplatescrambler.Dao.FileDao;
import carplatescrambler.Dao.IFileDao;
import carplatescrambler.Models.PlateSequence;
import carplatescrambler.PlateExtractor.Extractor;
import carplatescrambler.Models.Possibility;
import java.util.ArrayList;
import java.util.List;

public class PlateBuilder {

    private String ScrabbleString;
    
    public PlateBuilder(String ScrabbleString) {
        this.ScrabbleString = ScrabbleString;
    }
    
    public List<PlateSequence> Scrabble()
    {
        Extractor Extractor = new Extractor(ScrabbleString);
        List<Possibility> Possibilities = Extractor.Extract();
        List<PlateSequence> PlateSequences = new ArrayList<>();
        
        
        for(int i=0; i<Possibilities.size(); i++)
        {
            
            if(ValidateLocation(Possibilities.get(i).getLocationPart()))
            {
                if( Possibilities.get(i).getRestString().length() == 0)
                {
                    PlateSequence PlateSequence = new PlateSequence();
                    PlateSequence.addToPlateSequence(BuildPlate(Possibilities.get(i)));
                    PlateSequences.add(PlateSequence);
                } else if(Possibilities.get(i).getRestString().length() > 1)
                {
                    //TODO
                }
            }
        }
        
        
        return PlateSequences;
    }
    
    private String BuildPlate(Possibility Pos)
    {
        return Pos.getLocationPart() + " - " + Pos.getMidPart() + " 123";
    }
    
    private boolean ValidateLocation(String LocationPart)
    {
        List<String> FileContent;
        IFileDao File = new FileDao();
        
        FileContent = File.getFileContent();
        
        if(FileContent.contains(LocationPart))
        {
            return true;
        }
        return false;
    }
}
