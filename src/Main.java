import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        load();
        save();
    }

    private static void load(){
        try (FileReader reader = new FileReader("collection.json")){
            JSONParser jsonParser = new JSONParser();
            JSONObject json = (JSONObject) jsonParser.parse(reader);
            ListeAlbums albums = new ListeAlbums(json);
            System.out.println(albums);
        }catch (IOException | ParseException e){
            System.out.println(e);
        }
    }

    private static void save(){
        try (FileWriter writer = new FileWriter("MesAlbum.json")){
            Album[] albums = new Album[2];
            albums[0] = new Album("album", "Bob", "Chatons avec Bob", 2023, 1);
            albums[1] = new Album("single", "George", "Comptine Épique", 2020, 2);
            ListeAlbums liste = new ListeAlbums(albums);
            JSONObject json = liste.donnerJson();
            writer.write(json.toJSONString());
        }catch (IOException e){

        }
    }
}