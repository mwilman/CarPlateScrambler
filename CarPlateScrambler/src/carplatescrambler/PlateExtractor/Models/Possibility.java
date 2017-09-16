
package carplatescrambler.PlateExtractor.Models;


public class Possibility {
    private String LocationPart;
    private String MidPart;
    private String RestString;
    
    
    public String getLocationPart()
    {
        return LocationPart;
    }
    public void setLocationPart(String LocationPart)
    {
        this.LocationPart = LocationPart;
    }
    
    public String getMidPart()
    {
        return MidPart;
    }
    public void setMidPart(String MidPart)
    {
        this.MidPart = MidPart;
    }
    public String getRestString()
    {
        return this.RestString;
    }
    public void setRestStringt(String RestString)
    {
        this.RestString = RestString;
    }
}
