import java.util.Map;

final class SystemSupport {
    private SystemSupport() {}
    
    static int rollD6() {
        return rollDie(6);
    }
    static int rollD8() {
        return rollDie(8);
    }
    static String randomMapKey(Map<String,Integer> map) {
        Object[] keys = map.keySet().toArray();
        return (String)keys[(int)Math.random() * keys.length];
    }
    private static int rollDie(int max) {
        return (int)(Math.random() * max) + 1;
    }
}