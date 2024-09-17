public class Test {
    public static void main(String[] args) {
        playerStatusTests();
    }
    static void playerStatusTests() {
        int noHunger = 0;
        int someHunger = 1;
        int veryHunger = 3;
        
        int veryThirst = 2;
        int someThirst = 4;
        int noThirst = 6;

        Player pTest = new Player();

        pTest.quenched = noThirst;
        System.out.println("Feeling moist = " + pTest.getQuenchedStatus());

        pTest.quenched = someThirst;
        System.out.println("Feeling a little thirsty = " + pTest.getQuenchedStatus());

        pTest.quenched = veryThirst;
        System.out.println("Could really use a drink = " + pTest.getQuenchedStatus());
    }
}