import java.util.Scanner;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //playerThirstTest();
        //playerSatiationTest();
        //playerDiceTest();
        //playerBladderTest();
        //playerBowelsTest();
        //patronTest();
        //locationTest();
        customerInteractionTest();
    }
    static void customerInteractionTest() {
        Scanner scanner = new Scanner(System.in);
        Location lTest = new Location("Test", 1);
        Player pTest = new Player();
        String choice = "";
        
        do {
            lTest.printPatronDescriptions();
            choice = scanner.nextLine();
        } while(!choice.equals("q"));
    }
    static void locationTest() {
        Location lTest = new Location("Test", 2);
        System.out.println("Populated after instancing:");
        for(int i = 0; i < lTest.curPatrons.length && lTest.curPatrons[i] != null; i++){
            System.out.println(lTest.curPatrons[i].type);
        }

        for(int i = 0; i < 100; i++){
            lTest.generatePatrons();
        }
        System.out.println("Filled after 100 runs:");
        for(int i = 0; i < lTest.curPatrons.length && lTest.curPatrons[i] != null; i++){
            System.out.println(lTest.curPatrons[i].type);
        }

        System.out.println("Descriptions");
        ArrayList<String> descStrings = lTest.getPatronDescriptions();
        for(int i = 0; i < descStrings.size() && descStrings.get(i) != null; i++) {
            System.out.println(descStrings.get(i));
        }

        System.out.println("Deleting all");
        for(int i = 0; i < lTest.curPatrons.length * 50; i++) {
            lTest.depopulate(lTest.curPatrons);
        }
        for(int i = 0; i < lTest.curPatrons.length && lTest.curPatrons[i] != null; i++){
            System.out.println(lTest.curPatrons[i].type);
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
    static void playerBladderTest() {
        int veryNeed = 0;
        int someNeed = 2;
        int noNeed = 4;
        Player pTest = new Player();

        pTest.bladder = noNeed;
        System.out.println("Empty. = " + pTest.getBladderStatus());

        pTest.bladder = someNeed;
        System.out.println("Could release. = " + pTest.getBladderStatus());

        pTest.bladder = veryNeed;
        System.out.println("Near to bursting! = " + pTest.getBladderStatus());
    }
    static void playerBowelsTest() {
        int veryNeed = 2;
        int someNeed = 4;
        int noNeed = 6;
        Player pTest = new Player();

        pTest.bowels = noNeed;
        System.out.println("Nice and empty. = " + pTest.getBowelsStatus());

        pTest.bowels = someNeed;
        System.out.println("Feeling disquieting rumblings. = " + pTest.getBowelsStatus());

        pTest.bowels = veryNeed;
        System.out.println("Peeking! = " + pTest.getBowelsStatus());
    }
    static void playerDiceTest() {
        Player pTest = new Player();
        pTest.rollDice();
        System.out.println(pTest.getCurrentDice());

        /* 
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
            */
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