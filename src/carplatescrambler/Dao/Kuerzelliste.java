package carplatescrambler.Dao;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Kuerzelliste implements IKuerzelliste {
    @Override
    public List<String> getFileContent()
    {
        try {
            File file = new File(getClass().getResource("/carplatescrambler/resources/kuerzelliste.txt").getFile());
            List<String> Lines = Files.readAllLines(file.toPath());

            return Lines;
        } catch (IOException ex) {
            Logger.getLogger(Kuerzelliste.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
}
