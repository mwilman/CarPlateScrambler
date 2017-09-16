
package carplatescrambler.PlateExtractor;

import carplatescrambler.PlateExtractor.Models.Possibility;
import java.util.ArrayList;
import java.util.List;


public class Extractor {

    private final String PartialString;

    Extractor(String PartialString) {
        this.PartialString = PartialString;
    }
    public List<Possibility> Extract()
    {
        List<Possibility> ReturnList = new ArrayList<>();
        if(PartialString.length() >= 4)
        {
            ReturnList.add(CreatePossibility(PartialString.substring(0, 3),PartialString.substring(3),""));
            ReturnList.add(CreatePossibility(PartialString.substring(0, 2),PartialString.substring(2,4),PartialString.substring(4)));
            ReturnList.add(CreatePossibility(PartialString.substring(0, 2),PartialString.substring(2,3),PartialString.substring(3)));
            ReturnList.add(CreatePossibility(PartialString.substring(0, 1),PartialString.substring(1,3),PartialString.substring(3)));
            ReturnList.add(CreatePossibility(PartialString.substring(0, 1),PartialString.substring(1,2),PartialString.substring(2)));

        } else if (PartialString.length() == 3)
        {
            ReturnList.add(CreatePossibility(PartialString.substring(0, 2),PartialString.substring(2,3),PartialString.substring(3,4)));
            ReturnList.add(CreatePossibility(PartialString.substring(0, 0),PartialString.substring(1,2),PartialString.substring(3)));
            ReturnList.add(CreatePossibility(PartialString.substring(0, 0),PartialString.substring(1,1),PartialString.substring(2)));
        } else if (PartialString.length() == 2)
        {
           ReturnList.add(CreatePossibility(PartialString.substring(0, 1),PartialString.substring(1),""));
        }
        return ReturnList;
    }
    
    
    public boolean Check() {
        if(PartialString.length() > 5)
        {
            throw new IllegalArgumentException("Der Teilstring ist über fünf Zeichen lang.");
        }
        
        return !(PartialString.length() == 1) && !PartialString.matches(".*\\d+.*") && !PartialString.contains("ä");
    }
    
    
    private Possibility CreatePossibility(String LocationPart, String MidPart, String RestString)
    {
        Possibility possibility = new Possibility();
        possibility.setLocationPart(LocationPart);
        possibility.setMidPart(MidPart);
        possibility.setRestString(RestString);
        
        return possibility;
    }
}
