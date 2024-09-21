import java.util.Map;

class Patron {
    static Map<String, Integer> types = Map.ofEntries(
        Map.entry("solo", 3),
        Map.entry("family", 4),
        Map.entry("rich", 5)
    );
    String type = "";

    public Patron(){
        
    }
}