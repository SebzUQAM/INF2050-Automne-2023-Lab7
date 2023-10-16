import org.json.simple.JSONObject;

public class Album {

    private String type;
    private String artist;
    private String title;
    private Integer publication;
    private Integer rating;

    public Album(JSONObject json) {
        type = (String) json.get("type");
        artist = (String) json.get("artist");
        title = (String) json.get("title");
        publication = ((Long) json.get("publication")).intValue();
        rating = ((Long) json.get("rating")).intValue();
    }

    public Album(String type, String artist, String title, int publication, int rating) {
        this.type = type;
        this.artist = artist;
        this.title = title;
        this.publication = publication;
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public int getPublication() {
        return publication;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return title + " de " + artist;
    }

    public JSONObject donnerJson() {
        JSONObject json = new JSONObject();
        json.put("type", type);
        json.put("artist", artist);
        json.put("title", title);
        json.put("publication", publication);
        json.put("rating", rating);
        return json;
    }
}
