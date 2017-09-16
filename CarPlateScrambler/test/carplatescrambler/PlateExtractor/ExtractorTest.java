package carplatescrambler.PlateExtractor;

import carplatescrambler.Models.Possibility;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ExtractorTest {
    private Extractor Extractor;
    

    @Test(expected = IllegalArgumentException.class)
    public void TestExtractorCheckPartialStringContainsDigitsCheck()
    {
        Extractor = new Extractor("123");
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestExtractorCheckPartialStringContainsOneChar()
    {
        Extractor = new Extractor("a");
    }
    @Test
    public void TestExtractorCheckPartialStringContainsÄCheck()
    {
        Extractor = new Extractor("häh?");

    }
    @Test
    public void TestExtractorCheckPartialStringIsVaild_ReturnsTrue()
    {
        Extractor = new Extractor("BIBER");
    }
    @Test
    public void TestExtractorCheckPartialStringLengthIsOverFiveDigits_ReturnsFalse()
    {
        Extractor = new Extractor("IOASDIOASJDOIJASIODAOFHIOASDFHIOAHSFDIOHAIOFSDAIOFH");

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
    @Test
    public void TestExtractorExtractAllBIB_ReturnsList()
    {
        List<Possibility> expected = new ArrayList<>();
        String StringToExtract = "BIB";
        
        
        expected.add(CreatePossibility("BI","B", ""));
        expected.add(CreatePossibility("B","IB", ""));
        expected.add(CreatePossibility("B","I", "B"));
        
        List<Possibility> actual;

        Extractor = new Extractor(StringToExtract);
        
        actual = Extractor.Extract();
        
        assertEquals(expected.get(0).getLocationPart(), actual.get(0).getLocationPart());
        assertEquals(expected.get(1).getLocationPart(), actual.get(1).getLocationPart());
        assertEquals(expected.get(2).getLocationPart(), actual.get(2).getLocationPart());
        
        assertEquals(expected.get(0).getMidPart(), actual.get(0).getMidPart());
        assertEquals(expected.get(1).getMidPart(), actual.get(1).getMidPart());
        assertEquals(expected.get(2).getMidPart(), actual.get(2).getMidPart());
        
        assertEquals(expected.get(0).getRestString(), actual.get(0).getRestString());
        assertEquals(expected.get(1).getRestString(), actual.get(1).getRestString());
        assertEquals(expected.get(2).getRestString(), actual.get(2).getRestString());
        
    }
    @Test
    public void TestExtractorExtractAllBIBER_ReturnsList()
    {
        List<Possibility> expected = new ArrayList<>();
        String StringToExtract = "BIBER";
        
        expected.add(CreatePossibility("BIB","ER", ""));
        expected.add(CreatePossibility("BI","BE", "R"));
        expected.add(CreatePossibility("BI","B", "ER"));
        expected.add(CreatePossibility("B","IB", "ER"));
        expected.add(CreatePossibility("B","I", "BER"));
        
        List<Possibility> actual;

        Extractor = new Extractor(StringToExtract);
        
        actual = Extractor.Extract();
        
        assertEquals(expected.get(0).getLocationPart(), actual.get(0).getLocationPart());
        assertEquals(expected.get(1).getLocationPart(), actual.get(1).getLocationPart());
        assertEquals(expected.get(2).getLocationPart(), actual.get(2).getLocationPart());
        assertEquals(expected.get(3).getLocationPart(), actual.get(3).getLocationPart());
        assertEquals(expected.get(4).getLocationPart(), actual.get(4).getLocationPart());
        
        assertEquals(expected.get(0).getMidPart(), actual.get(0).getMidPart());
        assertEquals(expected.get(1).getMidPart(), actual.get(1).getMidPart());
        assertEquals(expected.get(2).getMidPart(), actual.get(2).getMidPart());
        assertEquals(expected.get(3).getMidPart(), actual.get(3).getMidPart());
        assertEquals(expected.get(4).getMidPart(), actual.get(4).getMidPart());
        
        assertEquals(expected.get(0).getRestString(), actual.get(0).getRestString());
        assertEquals(expected.get(1).getRestString(), actual.get(1).getRestString());
        assertEquals(expected.get(2).getRestString(), actual.get(2).getRestString());
        assertEquals(expected.get(3).getRestString(), actual.get(3).getRestString());
        assertEquals(expected.get(4).getRestString(), actual.get(4).getRestString());
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
