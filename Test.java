public class Test {
    public static void main(String[] args) {
        //playerThirstTest();
        //playerSatiationTest();
        playerDiceTest();
        
    }
    static void playerDiceTest() {
        Player pTest = new Player();
        pTest.rollDice();
        System.out.println(pTest.getCurrentDice());

        System.out.println("Decrease dice: empty");
        pTest.decreaseDice();
        System.out.println(pTest.getCurrentDice());

        System.out.println("Increase dice: empty");
        pTest.increaseDice();
        System.out.println(pTest.getCurrentDice());

        System.out.println("Increase dice: loop");
        for(int i = 0; i <= (Player.maxDice + Player.maxDice); i++){
            pTest.increaseDice();
            System.out.println(pTest.getCurrentDice());
        }

        System.out.println("Decrease dice: full");
        pTest.decreaseDice();
        System.out.println(pTest.getCurrentDice());
    }
    static void playerSatiationTest() {
        int noHunger = 6;
        int someHunger = 4;
        int veryHunger = 2;
        Player pTest = new Player();

        pTest.satiated = noHunger;
        System.out.println("Feeling full = " + pTest.getSatiatedStatus());

        pTest.satiated = someHunger;
        System.out.println("Feeling a little hungry = " + pTest.getSatiatedStatus());

        pTest.satiated = veryHunger;
        System.out.println("Could really use a bite = " + pTest.getSatiatedStatus());
    }
    static void playerThirstTest() {
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