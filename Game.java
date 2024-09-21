import java.util.Map;

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
        boolean play = false;

        System.out.println("Welcome to Bus Ticket");
        System.out.println("Goal: Get enough cash together through begging and scrounging to buy a bus ticket before time runs out.\n");

        do {
            playerStatus(player);
            locationStatus(gStation);
            
        } while(play);
    }

    static void locationStatus(Location loc) {
        
    }

    static void playerStatus(Player player) {
        System.out.printf("You have: $%.2f\n", player.cash);
        System.out.println("Your dirtiness is " + player.dirty + " out of " + Player.dirtyMax + ".");
        System.out.println("Your quenched status is: " + player.getQuenchedStatus());
        System.out.println("Your satiated status is: " + player.getSatiatedStatus());
    }
}