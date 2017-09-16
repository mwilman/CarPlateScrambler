/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carplatescrambler.PlateExtractor;

import carplatescrambler.PlateExtractor.Models.Possibility;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyx
 */
public class ExtractorTest {
    private Extractor Extractor;
    

    @Test
    public void TestExtractorPartialStringIsSet() {
        String expected = "BIBER";
        String actual;
        
        Extractor = new Extractor(expected);
        
        actual = Extractor.PartialString;
        
        assertEquals(expected, actual);
    }
    @Test
    public void TestExtractorPartialStringContainsDigitsCheck_ReturnsFalse()
    {
        boolean actual;
        
        Extractor = new Extractor("123");
        
        
        actual = Extractor.Check();
        assertFalse(actual);
    }
    @Test
    public void TestExtractorPartialStringContainsÄCheck_ReturnsFalse()
    {
        boolean actual;
        
        Extractor = new Extractor("häh?");
        
        actual = Extractor.Check();
        
        assertFalse(actual);
    }
    @Test
    public void TestExtractorPartialStringIsVaild_ReturnsTrue()
    {
        boolean actual;
        
        Extractor = new Extractor("BIBER");
        
        actual = Extractor.Check();
        
        assertTrue(actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestExtractorPartialStringLengthIsOverFiveDigits_ThrowsIllegalArgumentException()
    {
        Extractor = new Extractor("IOASDIOASJDOIJASIODAOFHIOASDFHIOAHSFDIOHAIOFSDAIOFH");
        
        Extractor.Check();
    }
    @Test
    public void TestExtractorExtractBIBER_ReturnsList()
    {
        List<Possibility> expected = new ArrayList<>();
        List<Possibility> actual;
        
        expected.add(CreatePossibility("BIB","ER",""));
        expected.add(CreatePossibility("BI","BE","R"));
        expected.add(CreatePossibility("BI", "B", "ER"));
        expected.add(CreatePossibility("B", "IB", "ER"));
        expected.add(CreatePossibility("B", "I", "BER"));
        
        
        Extractor = new Extractor("BIBER");
        
        actual = Extractor.Extract();
        
        assertSame(expected, actual);
    }
    
    private Possibility CreatePossibility(String LocationPart, String MidPart, String RestString)
    {
        Possibility pos = new Possibility();
        pos.setLocationPart(LocationPart);
        pos.setMidPart(MidPart);
        pos.setRestStringt(RestString);
        return pos;
    }
}
