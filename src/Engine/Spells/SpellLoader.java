package Engine.Spells;

import JSON.JSONObject;
import com.oracle.javafx.jmx.json.JSONReader;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by chase on 10/11/14.
 */
public class SpellLoader {

    File file;

    public SpellLoader(){
        file = new File("../Spells");
    }

    public Spell[] loadSpells(){
        if(!file.isDirectory()){
           return null;
        }
        for(File f : file.listFiles()){
            try {
                String text = new String(Files.readAllBytes(Paths.get(f.toURI())), StandardCharsets.UTF_8);
                JSONObject object = new JSONObject(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
