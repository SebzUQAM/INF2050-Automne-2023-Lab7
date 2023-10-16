import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class ListeAlbums {

    private Album[] collection;

    public ListeAlbums(JSONObject json) {
        JSONArray collection = (JSONArray) json.get("collection");
        this.collection = new Album[collection.size()];
        for(int i=0;i<this.collection.length;i++){
            this.collection[i] = new Album((JSONObject) collection.get(i));
        }
    }

    public ListeAlbums(Album[] albums) {
        collection = albums;
    }

    private int donnerNombreTypeAlbum(){
        int numbreAlbum = 0;
        for(int i=0;i< collection.length;i++){
            if(collection[i].getType().equalsIgnoreCase("album")){
                numbreAlbum++;
            }
        }
        return numbreAlbum;
    }

    private int donnerNombreTypeSingle(){
        return collection.length - donnerNombreTypeAlbum();
    }

    private Album[] donnerAlbumsDepuis2003(){
        ArrayList<Album> albums = new ArrayList<>();
        for(int i=0;i< collection.length;i++){
            if(collection[i].getPublication() >= 2003){
                albums.add(collection[i]);
            }
        }
        Album[] resultat = new Album[albums.size()];
        albums.toArray(resultat);
        return resultat;
    }

    private Album[] donnerAlbumsAvecNote5(){
        ArrayList<Album> albums = new ArrayList<>();
        for(int i=0;i< collection.length;i++){
            if(collection[i].getRating() == 5){
                albums.add(collection[i]);
            }
        }
        Album[] resultat = new Album[albums.size()];
        albums.toArray(resultat);
        return resultat;
    }

    @Override
    public String toString() {
        String resultat = "- le nombre d'albums : " + donnerNombreTypeAlbum() + "\n";
        resultat += "- le nombre de singles : " + donnerNombreTypeAlbum() + "\n";
        resultat += "- la liste des albums publiés depuis 2003 :\n";
        for (Album album : donnerAlbumsDepuis2003()){
            resultat += "     " + album.toString() + "\n";
        }
        resultat += "- la liste des albums avec une note de 5 :\n";
        for (Album album : donnerAlbumsAvecNote5()){
            resultat += "     " + album.toString() + "\n";
        }
        return resultat;
    }

    public JSONObject donnerJson() {
        JSONObject resultat = new JSONObject();
        JSONArray array = new JSONArray();
        for (int i=0; i<collection.length; i++){
            array.add(collection[i].donnerJson());
        }
        resultat.put("collection", array);
        return resultat;
    }
}
