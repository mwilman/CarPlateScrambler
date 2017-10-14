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

    private final List<String> FileContent;

    public PlateBuilder(String ScrabbleString) {
        this.ScrabbleString = ScrabbleString;
        IKuerzelliste file = new Kuerzelliste();
        FileContent = file.getFileContent();
    }

    public List<PlateSequence> scrabble() {

        carplatescrambler.PlateExtractor.Extractor extractor;
        if (ScrabbleString.substring(PositionInString).length() >= 5) {
            extractor = new Extractor(ScrabbleString.substring(PositionInString, PositionInString + 5));
            PositionInString = 5;
        } else {
            extractor = new Extractor(ScrabbleString.substring(PositionInString, ScrabbleString.length()));
            PositionInString = ScrabbleString.length();
        }

        List<Possibility> Possibilities = extractor.extract();

        List<PlateSequence> PlateSequences = buildPlateSequencesWithPossibilities(Possibilities);
        Clean(PlateSequences);
        return PlateSequences;
    }

    private List<PlateSequence> buildPlateSequencesWithPossibilities(List<Possibility> Possibilities) {
        List<PlateSequence> PlateSequences = new ArrayList<>();

        for (carplatescrambler.Models.Possibility Possibility : Possibilities) {

            if (validateLocation(Possibility.getLocationPart())) {
                if (Possibility.getRestString().length() == 0) {
                    PlateSequence PlateSequence = new PlateSequence();
                    PlateSequence.addToPlateSequence(buildPlate(Possibility));
                    PlateSequences.add(PlateSequence);
                } else if (Possibility.getRestString().length() >= 1) {
                    PlateSequence PlateSequence = new PlateSequence();
                    PlateSequence.addToPlateSequence(buildPlate(Possibility));

                    if (PositionInString >= ScrabbleString.length() && Possibility.getRestString().length() == 1) {
                        PlateSequence.removeAllPlates();
                    } else {
                        PlateBuilder PlateBuilder = new PlateBuilder(Possibility.getRestString() + ScrabbleString.substring(PositionInString));
                        List<PlateSequence> Extracted = PlateBuilder.scrabble();
                        if (Extracted.size() >= 1) {
                            PlateSequence.addToPlateSequence(Extracted.get(0).getPlateAt(0));

                            for (carplatescrambler.Models.PlateSequence aExtracted : Extracted) {
                                PlateSequence = new PlateSequence();
                                PlateSequence.addToPlateSequence(buildPlate(Possibility));
                                for (int k = 0; k < aExtracted.getPlateSize(); k++) {
                                    PlateSequence.addToPlateSequence(aExtracted.getPlateAt(k));
                                    PlateSequences.add(PlateSequence);
                                }

                            }
                        }
                    }
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
