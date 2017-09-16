package carplatescrambler.PlateExtractor;

import carplatescrambler.PlateExtractor.Models.Possibility;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ExtractorTest {
    private Extractor Extractor;
    

    @Test
    public void TestExtractorCheckPartialStringContainsDigitsCheck_ReturnsFalse()
    {
        boolean actual;
        
        Extractor = new Extractor("123");
        
        
        actual = Extractor.Check();
        assertFalse(actual);
    }
    @Test
    public void TestExtractorCheckPartialStringContainsOneChar_ReturnsFalse()
    {
        boolean actual;
        
        Extractor = new Extractor("a");
        
        
        actual = Extractor.Check();
        assertFalse(actual);
    }
    @Test
    public void TestExtractorCheckPartialStringContainsÄCheck_ReturnsFalse()
    {
        boolean actual;
        
        Extractor = new Extractor("häh?");
        
        actual = Extractor.Check();
        
        assertFalse(actual);
    }
    @Test
    public void TestExtractorCheckPartialStringIsVaild_ReturnsTrue()
    {
        boolean actual;
        
        Extractor = new Extractor("BIBER");
        
        actual = Extractor.Check();
        
        assertTrue(actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestExtractorCheckPartialStringLengthIsOverFiveDigits_ThrowsIllegalArgumentException()
    {
        Extractor = new Extractor("IOASDIOASJDOIJASIODAOFHIOASDFHIOAHSFDIOHAIOFSDAIOFH");
        
        Extractor.Check();
    }
    @Test
    public void TestExtractorExtractBIBER_ReturnsListNotNull()
    {
        List<Possibility> actual;
        Extractor = new Extractor("BIBER");
        
        actual = Extractor.Extract();
        
        assertNotNull(actual);
    }
    
    
    @Test
    public void TestExtractorExtractLocationBI_ReturnsListLocation()
    {
        String expected = "B";
        String StringToExtract = "BI";
        
        List<Possibility> actual;
        
        Extractor = new Extractor(StringToExtract);
        
        actual = Extractor.Extract();
        
        assertEquals(expected, actual.get(0).getLocationPart());
        
    }
    @Test
    public void TestExtractorExtractMidPartBI_ReturnsListLocation()
    {
        String expected = "I";
        String StringToExtract = "BI";
        
        List<Possibility> actual;
        
        Extractor = new Extractor(StringToExtract);
        
        actual = Extractor.Extract();
        
        assertEquals(expected, actual.get(0).getMidPart());
        
    }
    @Test
    public void TestExtractorExtractRestStringBI_ReturnsListRestStringEmpty()
    {
        String expected = "";
        String StringToExtract = "BI";
        
        List<Possibility> actual;
        

        Extractor = new Extractor(StringToExtract);
        
        actual = Extractor.Extract();
        
        assertEquals(expected, actual.get(0).getRestString());
        
    }
    private Possibility CreatePossibility(String LocationPart, String MidPart, String RestString)
    {
        Possibility pos = new Possibility();
        pos.setLocationPart(LocationPart);
        pos.setMidPart(MidPart);
        pos.setRestString(RestString);
        return pos;
    }
}
