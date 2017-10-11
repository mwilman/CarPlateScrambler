package carplatescrambler.Models;

import java.util.ArrayList;
import java.util.List;

public class PlateSequence {
    
    private List<String> PlateSequence = new ArrayList<>();
    
    public List<String> getPlateSequence()
    {
        return this.PlateSequence;
    }
    
    public void setPlateSequence(List<String> PlateSequence)
    {
        this.PlateSequence = PlateSequence;
    }
    public void removeAllPlates()
    {
        PlateSequence.clear();
    }
    public void addToPlateSequence(String Plate)
    {
        PlateSequence.add(Plate);
    }
    
    public String getPlateAt(int Position)
    {
        return PlateSequence.get(Position);
    }
}
