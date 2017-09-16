package carplatescrambler.PlateBuilder;


import org.junit.Test;
import static org.junit.Assert.*;

public class PlateBuilderTest {
    
    
    @Test
    public void PlateBuilderScrabbleTwoCharString_ReturnsPlate() {
        String ScrabbleString = "BI";
        String expected = "B - I 123";
        String actual;
        
        PlateBuilder PlateBuilder = new PlateBuilder(ScrabbleString);
        
        actual = PlateBuilder.Scrabble();
        
        assertEquals(expected, actual);
        
    }
    @Test
    public void PlateBuilderScrabbleInvalidTwoCharString_ReturnsEmptyString()
    {
        String ScrabbleString = "TI";
        String expected = "";
        String actual;
        
        PlateBuilder PlateBuilder = new PlateBuilder(ScrabbleString);
        
        actual = PlateBuilder.Scrabble();
        
        assertEquals(expected, actual);
    }
}
