import java.util.Map;



class Patron {
    /* TODO: Refactor post prototype
    public enum TYPES {
        LONELY (2),
        SOLO (3),
        FAMILY (4),
        RICH (5);
    }*/

    static Map<String, Integer> types = Map.ofEntries(
        Map.entry("lonely", 2),
        Map.entry("solo", 3),
        Map.entry("family", 4),
        Map.entry("rich", 5)
    );
    static Map<String, String[]> descriptions = Map.ofEntries(
        Map.entry("lonely", new String[]{"is looking around sadly.", "is staring off into space.", "is wandering around the place.", "is not especially notable."}),
        Map.entry("solo", new String[]{"is cleaning their windshield.", "is tracing an old-fashioned map.", "is sitting, playing on thier phone, car door open wide.", "is not especially notable."}),
        Map.entry("family", new String[]{"is arguing with their spouse.","is trying to wrangle a few wild children.", "is trying to talk to their elder offspring.", "is not especially notable."}),
        Map.entry("rich", new String[]{"is observes all with an expression of disdain.","is standing next to a very shiny car.", "is wearing very fine clothes.", "is not especially notable."})
    );
    static String[] states = {"just pulled up.", "figuring the transaction.", "waiting on the pump.", "getting ready to leave."};
    String type;
    String description;
    String state;
    int meetOrExceed;

    public Patron(){
        type = SystemSupport.randomMapKey(Patron.types);
        description = Patron.descriptions.get(type)[SystemSupport.rollD4()-1];
        state = Patron.states[SystemSupport.rollD4()-1];
        meetOrExceed = Patron.types.get(type);
    }    
}