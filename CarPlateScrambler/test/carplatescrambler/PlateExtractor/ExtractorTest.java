/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carplatescrambler.PlateExtractor;

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
}
