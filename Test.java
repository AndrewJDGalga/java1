public class Test {
    public static void main(String[] args) {
        //playerThirstTest();
        //playerSatiationTest();
        //playerDiceTest();
        //patronTest();
        locationTest();
    }
    static void locationTest() {
        Location lTest = new Location("Test");
        System.out.println("Generating " + lTest.curPatrons.length + " patrons.");
        for(int i = 0; i < lTest.curPatrons.length; i++) {
            System.out.println(i + " " + lTest.curPatrons[i].type);
            System.out.println(lTest.curPatrons[i].meetOrExceed);
            System.out.println(lTest.curPatrons[i].description);
        }

        System.out.println("Regenerating patrons.");
        lTest.generatePatrons();
        for(int i = 0; i < lTest.curPatrons.length; i++) {
            System.out.println(i + " " + lTest.curPatrons[i].type);
            System.out.println(lTest.curPatrons[i].meetOrExceed);
            System.out.println(lTest.curPatrons[i].description);
        }

        System.out.print("Patron descriptions array are same length: ");
        System.out.println(lTest.curPatrons.length == lTest.getPatronDescriptions().length);
    }
    static void patronTest() {
        System.out.println("Correct types:");
        for(int i = 0; i < 10; i++) {
            Patron pTest = new Patron();
            System.out.println(pTest.type);
            System.out.println(pTest.meetOrExceed);
        }
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

        System.out.println("Decrease dice: loop");
        for(int i = 0; i <= (Player.maxDice + Player.maxDice); i++){
            pTest.decreaseDice();
            System.out.println(pTest.getCurrentDice());
        }
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