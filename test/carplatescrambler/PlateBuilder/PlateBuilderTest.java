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
    @Test
    public void testPlateBuilderScrabbleValidBIBERSEString_ReturnsPlates()
    {
        String ScrabbleString = "BIBERSE";
        List <PlateSequence> expected = new ArrayList<>();
        List <PlateSequence> actual;
        
        PlateSequence sequence = createPlateSequence("BI - BE 123");
        sequence.addToPlateSequence("RS - E 123");
        expected.add(sequence);
        
        PlateSequence secondSequence = createPlateSequence("BI - BE 123");
        secondSequence.addToPlateSequence("R - SE 123");
        expected.add(secondSequence);
        
        PlateSequence thirdSequence = createPlateSequence("BI - B 123");
        thirdSequence.addToPlateSequence("ER - SE 123");
        expected.add(thirdSequence);
        
        PlateSequence fourthSequence = createPlateSequence("BI - B 123");
        fourthSequence.addToPlateSequence("E - R 123");
        fourthSequence.addToPlateSequence("S - E 123");
        expected.add(fourthSequence);
        
        PlateSequence fifthSequence = createPlateSequence("B - IB 123");
        fifthSequence.addToPlateSequence("ER - SE 123");
        expected.add(fifthSequence);
        
         PlateSequence sixthSequence = createPlateSequence("B - IB 123");
        sixthSequence.addToPlateSequence("E - R 123");
        sixthSequence.addToPlateSequence("S - E 123");
        expected.add(sixthSequence);
        
        PlateSequence seventhSequence = createPlateSequence("B - I 123");
        seventhSequence.addToPlateSequence("BER - SE 123");
        expected.add(seventhSequence);
        
        PlateSequence eighthSequence = createPlateSequence("B - I 123");
        eighthSequence.addToPlateSequence("BE - R 123");
        eighthSequence.addToPlateSequence("S - E 123");
        expected.add(eighthSequence);
        
        PlateSequence ninethSequence = createPlateSequence("B - I 123");
        ninethSequence.addToPlateSequence("B - ER 123");
        ninethSequence.addToPlateSequence("S - E 123");
        expected.add(ninethSequence);
        
        PlateSequence tenthSequence = createPlateSequence("B - I 123");
        tenthSequence.addToPlateSequence("B - E 123");
        tenthSequence.addToPlateSequence("RS - E 123");
        expected.add(tenthSequence);
        
        PlateSequence eleventhSequence = createPlateSequence("B - I 123");
        eleventhSequence.addToPlateSequence("B - E 123");
        eleventhSequence.addToPlateSequence("R - SE 123");
        expected.add(eleventhSequence);
        
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
        assertEquals(expected.get(3).getPlateAt(2), actual.get(3).getPlateAt(2));
        assertEquals(expected.get(4).getPlateAt(0), actual.get(4).getPlateAt(0));
        assertEquals(expected.get(4).getPlateAt(1), actual.get(4).getPlateAt(1));
        assertEquals(expected.get(5).getPlateAt(0), actual.get(5).getPlateAt(0));
        assertEquals(expected.get(5).getPlateAt(1), actual.get(5).getPlateAt(1));
        assertEquals(expected.get(5).getPlateAt(2), actual.get(5).getPlateAt(2));
        assertEquals(expected.get(6).getPlateAt(0), actual.get(6).getPlateAt(0));
        assertEquals(expected.get(6).getPlateAt(1), actual.get(6).getPlateAt(1));
        assertEquals(expected.get(7).getPlateAt(0), actual.get(7).getPlateAt(0));
        assertEquals(expected.get(7).getPlateAt(1), actual.get(7).getPlateAt(1));
        assertEquals(expected.get(7).getPlateAt(2), actual.get(7).getPlateAt(2));
        assertEquals(expected.get(8).getPlateAt(0), actual.get(8).getPlateAt(0));
        assertEquals(expected.get(8).getPlateAt(1), actual.get(8).getPlateAt(1));
        assertEquals(expected.get(8).getPlateAt(2), actual.get(8).getPlateAt(2));
        assertEquals(expected.get(9).getPlateAt(0), actual.get(9).getPlateAt(0));
        assertEquals(expected.get(9).getPlateAt(1), actual.get(9).getPlateAt(1));
        assertEquals(expected.get(9).getPlateAt(2), actual.get(9).getPlateAt(2));
        assertEquals(expected.get(10).getPlateAt(0), actual.get(10).getPlateAt(0));
        assertEquals(expected.get(10).getPlateAt(1), actual.get(10).getPlateAt(1));
        assertEquals(expected.get(10).getPlateAt(2), actual.get(10).getPlateAt(2));
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
    public void testPlateBuilderScrabbleInvalidThreeCharString_ReturnsEmptyList()
    {
        String ScrabbleString = "TIM";
        List<PlateSequence> actual;
        
        PlateBuilder plateBuilder = new PlateBuilder(ScrabbleString);
        
        actual = plateBuilder.scrabble();
        
        assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testPlateBuilderScrabbleInvalidFourCharString_ReturnsEmptyList()
    {
        String ScrabbleString = "TIMO";
        List<PlateSequence> actual;
        
        PlateBuilder plateBuilder = new PlateBuilder(ScrabbleString);
        
        actual = plateBuilder.scrabble();
        
        assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testPlateBuilderScrabbleStringAUTO_ReturnsList()
    {
        String ScrabbleString = "AUTO";
        List<PlateSequence> expected = new ArrayList();
        List<PlateSequence> actual;
        
        PlateSequence sequence = createPlateSequence("AU - TO 123");
        expected.add(sequence);
        
        PlateBuilder plateBuilder = new PlateBuilder(ScrabbleString);
        
        actual = plateBuilder.scrabble();
        
        assertEquals(expected.get(0).getPlateAt(0), actual.get(0).getPlateAt(0));
    }

    private PlateSequence createPlateSequence(String Plate)
    {
        PlateSequence plateSequence = new PlateSequence();
        plateSequence.addToPlateSequence(Plate);
        return plateSequence;
    }
}
