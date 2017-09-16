package carplatescrambler.PlateBuilder;

import carplatescrambler.Dao.FileDao;
import carplatescrambler.Dao.IFileDao;
import carplatescrambler.PlateExtractor.Extractor;
import carplatescrambler.PlateExtractor.Models.Possibility;
import java.util.List;

public class PlateBuilder {

    private String ScrabbleString;
    public PlateBuilder(String ScrabbleString) {
        this.ScrabbleString = ScrabbleString;
    }
    
    public String Scrabble()
    {
        String Plate = "";
        
        Extractor Extractor = new Extractor(ScrabbleString);
        List<Possibility> Possibilities = Extractor.Extract();
        
        
        
        if(ValidateLocation(Possibilities.get(0).getLocationPart()))
        {
            Plate = Possibilities.get(0).getLocationPart() + " - " + Possibilities.get(0).getMidPart() + " 123";
        }

        return Plate;
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
