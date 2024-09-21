import java.util.Map;

class Patron {
    static Map<String, Integer> types = Map.ofEntries(
        Map.entry("solo", 3),
        Map.entry("family", 4),
        Map.entry("rich", 5)
    );
    static Map<String, String[]> descriptions = Map.ofEntries(
        Map.entry("solo", new String[]{"is staring off into space.", "is sitting, playing on thier phone, car door open wide.", "is not especially notable."}),
        Map.entry("family", new String[]{"is trying to wrangle a few wild children.", "is trying to talk to their elder offspring.", "is not especially notable."}),
        Map.entry("rich", new String[]{"stands next to a very shiny car.", "is wearing very fine clothes.", "is not especially notable."})
    );
    String type;
    String description;
    int meetOrExceed;

    public Patron(){
        type = SystemSupport.randomMapKey(Patron.types);
        description = Patron.descriptions.get(type);
        meetOrExceed = Patron.types.get(type);
    }    
}