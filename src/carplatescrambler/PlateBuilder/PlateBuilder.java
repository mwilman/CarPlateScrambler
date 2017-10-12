package carplatescrambler.PlateBuilder;

import carplatescrambler.Dao.Kuerzelliste;
import carplatescrambler.Models.PlateSequence;
import carplatescrambler.PlateExtractor.Extractor;
import carplatescrambler.Models.Possibility;
import java.util.ArrayList;
import java.util.List;
import carplatescrambler.Dao.IKuerzelliste;

public class PlateBuilder {

    private final String ScrabbleString;
    private int PositionInString = 0;
    private Extractor Extractor;

    List<String> FileContent;
    IKuerzelliste File = new Kuerzelliste();

    public PlateBuilder(String ScrabbleString) {
        this.ScrabbleString = ScrabbleString;
        FileContent = File.getFileContent();
    }

    public List<PlateSequence> scrabble() {

        if (ScrabbleString.substring(PositionInString).length() >= 5) {
            Extractor = new Extractor(ScrabbleString.substring(PositionInString, PositionInString + 5));
            PositionInString = 5;
        } else {
            Extractor = new Extractor(ScrabbleString.substring(PositionInString, ScrabbleString.length()));
            PositionInString = ScrabbleString.length();
        }

        List<Possibility> Possibilities = Extractor.extract();

        List<PlateSequence> PlateSequences = buildPlateSequencesWithPossibilities(Possibilities);
        Clean(PlateSequences);
        return PlateSequences;
    }

    private List<PlateSequence> buildPlateSequencesWithPossibilities(List<Possibility> Possibilities) {
        List<PlateSequence> PlateSequences = new ArrayList<>();

        for (int i = 0; i < Possibilities.size(); i++) {

            if (validateLocation(Possibilities.get(i).getLocationPart())) {
                if (Possibilities.get(i).getRestString().length() == 0) {
                    PlateSequence PlateSequence = new PlateSequence();
                    PlateSequence.addToPlateSequence(buildPlate(Possibilities.get(i)));
                    PlateSequences.add(PlateSequence);
                } else if (Possibilities.get(i).getRestString().length() >= 1) {
                    //TODO Der Lesbarkeithalber, sollte das hier in Methoden aufgeteilt werden?
                    PlateSequence PlateSequence = new PlateSequence();
                    PlateSequence.addToPlateSequence(buildPlate(Possibilities.get(i)));

                    // if(ScrabbleString.substring(PositionInString).length() >= 1)
                    //{
                    if (PositionInString >= ScrabbleString.length() && Possibilities.get(i).getRestString().length() == 1) {
                        PlateSequence.removeAllPlates();
                    } else {
                        PlateBuilder PlateBuilder = new PlateBuilder(Possibilities.get(i).getRestString() + ScrabbleString.substring(PositionInString));
                        List<PlateSequence> Extracted = PlateBuilder.scrabble();
                        if (Extracted.size() > 1) {
                            PlateSequence.addToPlateSequence(Extracted.get(0).getPlateAt(0));

                            for (int j = 0; j < Extracted.size(); j++) {
                                PlateSequence = new PlateSequence();
                                PlateSequence.addToPlateSequence(buildPlate(Possibilities.get(i)));
                                for (int k = 0; k < Extracted.get(j).getPlateSize(); k++) {
                                    PlateSequence.addToPlateSequence(Extracted.get(j).getPlateAt(k));
                                    PlateSequences.add(PlateSequence);
                                }

                            }
                        } else if (Extracted.size() == 1 && !Extracted.isEmpty()) {
                            for (int k = 0; k < Extracted.get(0).getPlateSize(); k++) {
                                PlateSequence.addToPlateSequence(Extracted.get(0).getPlateAt(k));
                                PlateSequences.add(PlateSequence);
                            }

                        }
                    }
                    //}
                }
            }
        }
        return PlateSequences;
    }

    private String buildPlate(Possibility Pos) {
        return Pos.getLocationPart() + " - " + Pos.getMidPart() + " 123";
    }

    private boolean validateLocation(String LocationPart) {
        return FileContent.contains(LocationPart);
    }

    private void Clean(List<PlateSequence> PlateSequences) {
        for (int i = 0; i < PlateSequences.size(); i++) {
            if (i < PlateSequences.size() - 1 && PlateSequences.get(i).equals(PlateSequences.get(i + 1))) {
                PlateSequences.remove(i + 1);
            }
        }
    }
}
