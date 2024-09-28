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
        Location gStation = new Location("The Gas Station");
        boolean play = true;

        final int maxTime = 8;
        int currentTime = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Bus Ticket");
        System.out.println("Goal: Get enough cash together through begging and scrounging to buy a bus ticket before time runs out.\n");

        do {
            System.out.println((maxTime - ++currentTime) + "hrs remaining.");
            if(player.isMissTurn()) {
                System.out.println(Player.missedTurnNotice);
                player.missTurn = false;
                scanner.nextLine();
                continue;
            }
            playerStatus(player);
            locationStatus(gStation);
            
            int choice = 0;
            do{
                System.out.println("\n--What would you like to do?--");
                System.out.println("1 = Approach a Customer (spend a die)");
                System.out.println("2 = Relieve yourself (cheap recovery, possible cost).");
                System.out.println("3 = Enter the store (expensive recovery, certain cost).");
                System.out.println("4 = Scrounge in trash (end the turn, random item)");
                System.out.println("5 = Quit (no save)");
                
                if(scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                }else {
                    System.out.println("\n---Please enter a number between 1 & 5---");
                    scanner.nextLine();
                }
            }while(choice < 1 || choice > 5);

            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Ta ta!");
                    play = false;
            }
        } while(play);
        scanner.close(); //just in case system doesn't cleanup on exit
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