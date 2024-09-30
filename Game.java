import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        String[] trashTable = {
            "water_half",
            "snack_half",
            "caffeine_half",
            "beer_half",
            "change_half"
        };
        Map<String, Float> storeItems = Map.ofEntries(
            Map.entry("bus_pass", 25f),
            Map.entry("water_full", 3f),
            Map.entry("snack_full", 3f),
            Map.entry("bathroom", 2f),
            Map.entry("beer_full", 4f),
            Map.entry("caffeine_full", 4f),
            Map.entry("sink", 3f)
        );
        Player player = new Player();
        Location gStation = new Location("The Gas Station", 3);
        boolean play = true;

        final int maxTime = 8;
        int currentTime = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Bus Ticket");
        System.out.println("Goal: Get enough cash together through begging and scrounging to buy a bus ticket before time runs out.\n");

        do {
            if(currentTime < maxTime) System.out.println((maxTime - ++currentTime) + "hrs remaining.");
            else {
                System.out.println("You watch dejectedly as the last bus of the day pushes away from the station. You're out of time. Oh well. Tonight you'll sleep on the street, and tomorrow you'll head towards home.\n\nYou wish you had a chance to see the end of this dream. Maybe, someday, there'll be another one.\n\nGame Over.");
                break;
            }
            if(player.isMissTurn()) {
                System.out.println(Player.missedTurnNotice);
                player.missTurn = false;
                scanner.nextLine();
                continue;
            }
            playerStatus(player);
            locationStatus(gStation);
            innerLoop();
        } while(play);
        scanner.close(); //just in case system doesn't cleanup on exit
    }
    
    static void innerLoop() {
        int choice = 0;
        boolean nextHour = false;
        do{
            System.out.println("\n--What would you like to do?--");
            System.out.println("1 = Approach a Customer (spend a die)");
            System.out.println("2 = Relieve yourself (cheap recovery, possible cost).");
            System.out.println("3 = Enter the store (expensive recovery, certain cost).");
            System.out.println("4 = Scrounge in trash (end the turn, random item)");
            System.out.println("5 = Quit (no save)");
            
            if(scanner.hasNextInt()) {
                choice = scanner.nextInt();
                nextHour = handleChoice(choice, player, gStation);
            }else {
                System.out.println("\n---Please enter a number between 1 & 5---");
                scanner.nextLine();
            }
        }while(!nextHour);
    }    
    static boolean handleChoice(int choice, Player player, Location location) {
        boolean exit = false;
        switch (choice) {
            case 1:
                approachACustomer();
                break;
            case 2:
                relieveSelf(player, location);
                break;
            case 3:
                enterStore();
                break;
            case 4:
                scrounge();
                break;
            default:
                exit = true;
        }
        return exit;
    }
    static void approachACustomer(){

    }
    static void relieveSelf(Player player, Location location) {
        
    }
    static void enterStore() {

    }
    static void scrounge() {

    }
    static void locationStatus(Location loc) {
        String[] descriptions = loc.getPatronDescriptions();
        System.out.println("You spot some other customers to solicit for the money you need. You see:");
        for(int i = 0; i < descriptions.length && descriptions[i] != null; i++) {
            System.out.println("Customer " + (i+1) + " " + descriptions[i]);
        }
    }
    static void playerStatus(Player player) {
        System.out.printf("You have: $%.2f\n", player.cash);
        System.out.println("Your dirtiness is " + player.dirty + " out of " + Player.dirtyMax + ".");
        System.out.println("Your quenched status is: " + player.getQuenchedStatus());
        System.out.println("Your satiated status is: " + player.getSatiatedStatus());
    }
}