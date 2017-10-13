package carplatescrambler.Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Kuerzelliste implements IKuerzelliste {
    @Override
    public List<String> getFileContent()
    {
        try {
            InputStream stream = getClass().getResourceAsStream("/carplatescrambler/resources/kuerzelliste.txt");
            List<String> lines = new ArrayList<>();
            BufferedReader in = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException ex) {
            Logger.getLogger(Kuerzelliste.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
}
