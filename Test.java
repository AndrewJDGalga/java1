public class Test {
    public static void main(String[] args) {
        //playerThirstTest();
        //playerSatiationTest();
        //playerDiceTest();
        //patronTest();
        //locationTest();

        Location lTest = new Location("Test");
        for(int i = 0; i < lTest.curPatrons.length && lTest.curPatrons[i] != null; i++){
            System.out.println(lTest.curPatrons[i].type);
        }
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
        String[] descriptions = lTest.getPatronDescriptions();
        System.out.println(lTest.curPatrons.length == descriptions.length);
        System.out.println("Any mismatch?");
        for(int i = 0; i < descriptions.length; i++) {
            if(!lTest.curPatrons[i].description.equals(descriptions[i])) System.out.println("Mismatch between '" + lTest.curPatrons[i].description + " and " + descriptions[i]); 
        }
    }
    static void patronTest() {
        System.out.println("Patrons:");
        for(int i = 0; i < 10; i++) {
            Patron pTest = new Patron();
            System.out.println(pTest.type);
            System.out.println(pTest.meetOrExceed);
            System.out.println(pTest.state);
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