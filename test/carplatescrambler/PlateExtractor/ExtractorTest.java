package carplatescrambler.PlateExtractor;

import carplatescrambler.Models.Possibility;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class ExtractorTest {
    private Extractor extractor;
    
    @Test
    public void testExtractorSetPartialString()
    {
        String expected = "TEST";
        String actual;
        
        extractor = new Extractor("BIBER");
        extractor.setPartialString(expected);
        
        actual = extractor.getPartialString();
        
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testExtractorCheckPartialStringContainsDigitsCheck()
    {
        extractor = new Extractor("123");
        extractor.extract();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testExtractorCheckPartialStringContainsOneChar()
    {
        extractor = new Extractor("a");
        extractor.extract();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testExtractorCheckPartialStringContainsÄCheck()
    {
        extractor = new Extractor("häh?");
        extractor.extract();

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testExtractorCheckPartialStringLengthIsOverFiveDigits()
    {
        extractor = new Extractor("IOASDIOASJDOIJASIODAOFHIOASDFHIOAHSFDIOHAIOFSDAIOFH");
        extractor.extract();

    }
    
    @Test
    public void testExtractorExtractBIBER_ReturnsListNotNull()
    {
        List<Possibility> actual;
        extractor = new Extractor("BIBER");
        
        actual = extractor.extract();
        
        assertNotNull(actual);
    }
    
    @Test
    public void testExtractorExtractLocationBI_ReturnsListLocation()
    {
        String expected = "B";
        String StringToExtract = "BI";
        
        List<Possibility> actual;
        
        extractor = new Extractor(StringToExtract);
        
        actual = extractor.extract();
        
        assertEquals(expected, actual.get(0).getLocationPart());
        
    }
    
    @Test
    public void testExtractorExtractMidPartBI_ReturnsListLocation()
    {
        String expected = "I";
        String StringToExtract = "BI";
        
        List<Possibility> actual;
        
        extractor = new Extractor(StringToExtract);
        
        actual = extractor.extract();
        
        assertEquals(expected, actual.get(0).getMidPart());
        
    }
    
    @Test
    public void testExtractorExtractRestStringBI_ReturnsListRestStringEmpty()
    {
        String expected = "";
        String StringToExtract = "BI";
        
        List<Possibility> actual;
        

        extractor = new Extractor(StringToExtract);
        
        actual = extractor.extract();
        
        assertEquals(expected, actual.get(0).getRestString());
        
    }
    
    @Test
    public void testExtractorExtractAllBIB_ReturnsList()
    {
        List<Possibility> expected = new ArrayList<>();
        String StringToExtract = "BIB";
        
        
        expected.add(createPossibility("BI","B", ""));
        expected.add(createPossibility("B","IB", ""));
        expected.add(createPossibility("B","I", "B"));
        
        List<Possibility> actual;

        extractor = new Extractor(StringToExtract);
        
        actual = extractor.extract();
        
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
    public void testExtractorExtractAllBIBER_ReturnsList()
    {
        List<Possibility> expected = new ArrayList<>();
        String StringToExtract = "BIBER";
        
        expected.add(createPossibility("BIB","ER", ""));
        expected.add(createPossibility("BI","BE", "R"));
        expected.add(createPossibility("BI","B", "ER"));
        expected.add(createPossibility("B","IB", "ER"));
        expected.add(createPossibility("B","I", "BER"));
        
        List<Possibility> actual;

        extractor = new Extractor(StringToExtract);
        
        actual = extractor.extract();
        
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
    
    private Possibility createPossibility(String LocationPart, String MidPart, String RestString)
    {
        Possibility pos = new Possibility();
        pos.setLocationPart(LocationPart);
        pos.setMidPart(MidPart);
        pos.setRestString(RestString);
        return pos;
    }
}
