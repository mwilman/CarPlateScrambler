/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carplatescrambler.PlateExtractor.Models;

/**
 *
 * @author cyx
 */
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
