import java.util.HashMap;
public class Hashmatique {
    public void GetTracks(){
        HashMap<String, String> trackList = new HashMap<>();
        trackList.put("Luis Fonsi & Daddy Yankee", "Despacito");
        trackList.put("Ed Sheeran", "Shape of You");
        trackList.put("Bruno Mars", "24K Magic");
        trackList.put("Katy Perry ft. Nicki Minaj", "Swish Swish");
        String track = trackList.get("Ed Sheeran");
        System.out.println("Ed Sheeran's song: "+ track);
        trackList.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}