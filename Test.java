public class Test {
    public static void main(String[] args) {
        playerStatusTests();
    }
    static void playerStatusTests() {
        int noHunger = 0;
        int someHunger = 1;
        int veryHunger = 3;
        
        int veryThirst = 3;
        int someThirst = 1;
        int noThirst = 6;

        Player pTest = new Player();

        pTest.quenched = noThirst;
        System.out.println("Feeling moist = " + pTest.getQuenchedStatus());
    }
}