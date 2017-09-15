/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carplatescrambler.PlateExtractor;
import java.lang.Exception;
/**
 *
 * @author cyx
 */
public class Extractor {

    String PartialString;

    Extractor(String PartialString) {
        this.PartialString = PartialString;
        
    }

    boolean Check() {
        if(PartialString.length() > 5)
        {
            throw new IllegalArgumentException("Der Teilstring ist über fünf Zeichen lang.");
        }
        if(PartialString.matches(".*\\d+.*"))
        {
            return false;
        }
        if(PartialString.contains("ä"))
        {
            return false;
        }
        return true;
    }
    
}
