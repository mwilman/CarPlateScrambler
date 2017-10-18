
package carplatescrambler.PlateExtractor;

import carplatescrambler.Models.Possibility;
import java.util.ArrayList;
import java.util.List;


public class Extractor {

    private String PartialString;

    public Extractor(String PartialString) {
        this.PartialString = PartialString;
    }
    
    public void setPartialString(String PartialString)
    {
        this.PartialString = PartialString;
    }
    public String getPartialString() {
        return PartialString;
    }
    
    public List<Possibility> extract()
    {
        if(!check())
        {
            throw new IllegalArgumentException("Der Teilstring ist ungültig.");
        }
        List<Possibility> ReturnList = new ArrayList<>();
        if(PartialString.length() >= 4)
        {
            Possibility pos;
            if ((pos = createPossibility(PartialString.substring(0, 3),PartialString.substring(3),"")) != null)
            {
                ReturnList.add(pos);
            }
            if ((pos = createPossibility(PartialString.substring(0, 2),PartialString.substring(2,4),PartialString.substring(4))) != null)
            {
                ReturnList.add(pos);
            }
            if ((pos = createPossibility(PartialString.substring(0, 2),PartialString.substring(2,3),PartialString.substring(3))) != null)
            {
                ReturnList.add(pos);
            }
            if ((pos = createPossibility(PartialString.substring(0, 1),PartialString.substring(1,3),PartialString.substring(3))) != null)
            {
                ReturnList.add(pos);
            }
            if ((pos = createPossibility(PartialString.substring(0, 1),PartialString.substring(1,2),PartialString.substring(2))) != null)
            {
                ReturnList.add(pos);
            }

        } else if (PartialString.length() == 3)
        {
            Possibility pos;
            if ((pos = createPossibility(PartialString.substring(0, 2),PartialString.substring(2,3),"")) != null)
            {
                ReturnList.add(pos);
            }

            if ((pos = createPossibility(PartialString.substring(0, 1),PartialString.substring(1,3),PartialString.substring(3))) != null)
            {
                ReturnList.add(pos);
            }

            if ((pos = createPossibility(PartialString.substring(0, 1),PartialString.substring(1,2),PartialString.substring(2))) != null)
            {
                ReturnList.add(pos);
            }
        } else if (PartialString.length() == 2)
        {
            Possibility pos;
            if ((pos = createPossibility(PartialString.substring(0, 1),PartialString.substring(1),"")) != null)
            {
                ReturnList.add(pos);
            }
        }
        return ReturnList;
    }
    
    
    private boolean check() {
        return !(PartialString.length() > 5)&& !(PartialString.length() == 1) && !PartialString.matches(".*\\d+.*");
    }
    
    
    private Possibility createPossibility(String LocationPart, String MidPart, String RestString)
    {
        if(MidPart.toUpperCase().contains("Ä") || MidPart.toUpperCase().contains("Ö") || MidPart.toUpperCase().contains("Ü"))
        {
            return null;
        } else {
            Possibility possibility = new Possibility();
            possibility.setLocationPart(LocationPart);
            possibility.setMidPart(MidPart);
            possibility.setRestString(RestString);
            return possibility;
        }
    }

   
}
