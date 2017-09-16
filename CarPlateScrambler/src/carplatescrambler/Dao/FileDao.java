/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carplatescrambler.Dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author cyx
 */
public class FileDao implements IFileDao {
    public String getFileContent()
    {
        try {
            return new String(Files.readAllBytes(Paths.get(getClass().getResource("kuerzelliste.txt").toURI())));
        } catch (URISyntaxException ex) {
            Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
}
