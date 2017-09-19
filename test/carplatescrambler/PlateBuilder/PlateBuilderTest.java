package carplatescrambler.PlateBuilder;


import carplatescrambler.Models.PlateSequence;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlateBuilderTest {
    
    
    @Test
    public void testPlateBuilderScrabbleTwoCharString_ReturnsPlate() {
        String ScrabbleString = "BI";
        String expected = "B - I 123";
        List<PlateSequence> actual;
        
        PlateBuilder plateBuilder = new PlateBuilder(ScrabbleString);
        
        actual = plateBuilder.scrabble();
        
        assertEquals(expected, actual.get(0).getPlateAt(0));
        
    }
    @Test
    public void testPlateBuilderScrabbleInvalidTwoCharString_ReturnsEmptyList()
    {
        String ScrabbleString = "TI";
        List<PlateSequence> actual;
        
        PlateBuilder plateBuilder = new PlateBuilder(ScrabbleString);
        
        actual = plateBuilder.scrabble();
        
        assertTrue(actual.isEmpty());
    }
    @Test
    public void testPlateBulderScrabbleValidThreeCharString_ListCotainsTwoPlates()
    {
        String ScrabbleString = "BIB";
        int expected = 2;
        List <PlateSequence> actual;
        
        PlateBuilder plateBuilder = new PlateBuilder(ScrabbleString);
        actual = plateBuilder.scrabble();
        
        assertEquals(expected, actual.size());
    }
    @Test
    public void testPlateBuilderScrabbleValidThreeCharString_ReturnsPlates()
    {
        String ScrabbleString = "BIB";
        List <PlateSequence> expected = new ArrayList<>();
        List <PlateSequence> actual;
        
        
        expected.add(createPlateSequence("BI - B 123"));
        expected.add(createPlateSequence("B - IB 123"));
        
        PlateBuilder plateBuilder = new PlateBuilder(ScrabbleString);
        actual = plateBuilder.scrabble();
        
        assertEquals(expected.get(0).getPlateAt(0), actual.get(0).getPlateAt(0));
        assertEquals(expected.get(1).getPlateAt(0), actual.get(1).getPlateAt(0));
        
    }
    @Test
    public void testPlateBuilderScrabbleValidFourCharString_ReturnsPlates()
    {
        String ScrabbleString = "BIBE";
        List <PlateSequence> expected = new ArrayList<>();
        List <PlateSequence> actual;
        
        
        expected.add(createPlateSequence("BI - BE 123"));
        
        PlateSequence Sequence = createPlateSequence("B - I 123");
        Sequence.addToPlateSequence("B - E 123");
        expected.add(Sequence);
        
        PlateBuilder plateBuilder = new PlateBuilder(ScrabbleString);
        actual = plateBuilder.scrabble();
        
        assertEquals(expected.get(0).getPlateAt(0), actual.get(0).getPlateAt(0));
        assertEquals(expected.get(1).getPlateAt(0), actual.get(1).getPlateAt(0));
        assertEquals(expected.get(1).getPlateAt(1), actual.get(1).getPlateAt(1));
        
    }
    @Test
    public void testPlateBuilderScrabbleValidBIBERString_ReturnsPlates()
    {
        String ScrabbleString = "BIBER";
        List <PlateSequence> expected = new ArrayList<>();
        List <PlateSequence> actual;
        
        PlateSequence sequence = createPlateSequence("BI - B 123");
        sequence.addToPlateSequence("E - R 123");
        expected.add(sequence);
        
        PlateSequence secondSequence = createPlateSequence("B - IB 123");
        secondSequence.addToPlateSequence("E - R 123");
        expected.add(secondSequence);
        
        PlateSequence thirdSequence = createPlateSequence("B - I 123");
        thirdSequence.addToPlateSequence("BE - R 123");
        expected.add(thirdSequence);
        
        PlateSequence fourthSequence = createPlateSequence("B - I 123");
        fourthSequence.addToPlateSequence("B - ER 123");
        expected.add(fourthSequence);
        
        PlateBuilder plateBuilder = new PlateBuilder(ScrabbleString);
        actual = plateBuilder.scrabble();
        
        assertEquals(expected.get(0).getPlateAt(0), actual.get(0).getPlateAt(0));
        assertEquals(expected.get(0).getPlateAt(1), actual.get(0).getPlateAt(1));
        assertEquals(expected.get(1).getPlateAt(0), actual.get(1).getPlateAt(0));
        assertEquals(expected.get(1).getPlateAt(1), actual.get(1).getPlateAt(1));
        assertEquals(expected.get(2).getPlateAt(0), actual.get(2).getPlateAt(0));
        assertEquals(expected.get(2).getPlateAt(1), actual.get(2).getPlateAt(1));
        assertEquals(expected.get(3).getPlateAt(0), actual.get(3).getPlateAt(0));
        assertEquals(expected.get(3).getPlateAt(1), actual.get(3).getPlateAt(1));
    }
   
    private PlateSequence createPlateSequence(String Plate)
    {
        PlateSequence plateSequence = new PlateSequence();
        plateSequence.addToPlateSequence(Plate);
        return plateSequence;
    }
}
