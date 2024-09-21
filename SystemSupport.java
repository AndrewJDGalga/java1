import java.util.Map;

final class SystemSupport {
    private SystemSupport() {}
    
    static int rollD6() {
        return rollDie(6, 1);
    }
    static int rollD8() {
        return rollDie(8, 1);
    }
    private static int rollDie(int max, int min) {
        return (int)(Math.random() * max) + min;
    }

    public static String randomMapKey(Map<String,Integer> map) {
        Object[] keys = map.keySet().toArray();
        return (String)keys[rollDie(keys.length, 0)];
    }
}