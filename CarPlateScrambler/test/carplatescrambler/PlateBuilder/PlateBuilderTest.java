package carplatescrambler.PlateBuilder;


import carplatescrambler.Models.PlateSequence;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlateBuilderTest {
    
    
    @Test
    public void PlateBuilderScrabbleTwoCharString_ReturnsPlate() {
        String ScrabbleString = "BI";
        String expected = "B - I 123";
        List<PlateSequence> actual;
        
        PlateBuilder PlateBuilder = new PlateBuilder(ScrabbleString);
        
        actual = PlateBuilder.Scrabble();
        
        assertEquals(expected, actual.get(0).getPlateAt(0));
        
    }
    @Test
    public void PlateBuilderScrabbleInvalidTwoCharString_ReturnsEmptyList()
    {
        String ScrabbleString = "TI";
        List<PlateSequence> actual;
        
        PlateBuilder PlateBuilder = new PlateBuilder(ScrabbleString);
        
        actual = PlateBuilder.Scrabble();
        
        assertTrue(actual.isEmpty());
    }
    @Test
    public void PlateBulderScrabbleValidThreeCharString_ListCotainsTwoPlates()
    {
        String ScrabbleString = "BIB";
        int expected = 2;
        List <PlateSequence> actual;
        
        PlateBuilder PlateBuilder = new PlateBuilder(ScrabbleString);
        actual = PlateBuilder.Scrabble();
        
        assertEquals(expected, actual.size());
    }
    @Test
    public void PlateBuilderScrabbleValidThreeCharString_ReturnsPlates()
    {
        String ScrabbleString = "BIB";
        List <PlateSequence> expected = new ArrayList<>();
        List <PlateSequence> actual;
        
        
        expected.add(CreatePlateSequence("BI - B 123"));
        expected.add(CreatePlateSequence("B - IB 123"));
        
        PlateBuilder PlateBuilder = new PlateBuilder(ScrabbleString);
        actual = PlateBuilder.Scrabble();
        
        assertEquals(expected.get(0).getPlateAt(0), actual.get(0).getPlateAt(0));
        assertEquals(expected.get(1).getPlateAt(0), actual.get(1).getPlateAt(0));
        
    }
    @Test
    public void PlateBuilderScrabbleValidFourCharString_ReturnsPlates()
    {
        String ScrabbleString = "BIBE";
        List <PlateSequence> expected = new ArrayList<>();
        List <PlateSequence> actual;
        
        
        expected.add(CreatePlateSequence("BI - BE 123"));
        
        PlateSequence Sequence = CreatePlateSequence("B - I 123");
        Sequence.addToPlateSequence("B - E 123");
        expected.add(Sequence);
        
        PlateBuilder PlateBuilder = new PlateBuilder(ScrabbleString);
        actual = PlateBuilder.Scrabble();
        
        assertEquals(expected.get(0).getPlateAt(0), actual.get(0).getPlateAt(0));
        assertEquals(expected.get(1).getPlateAt(0), actual.get(1).getPlateAt(0));
        assertEquals(expected.get(1).getPlateAt(1), actual.get(1).getPlateAt(1));
        
    }
    private PlateSequence CreatePlateSequence(String Plate)
    {
        PlateSequence PlateSequence = new PlateSequence();
        PlateSequence.addToPlateSequence(Plate);
        return PlateSequence;
    }
}
