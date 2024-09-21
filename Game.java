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
        String[] descriptions = loc.getPatronDescriptions();
        System.out.println("You spot some other customers to solicit for the money you need. You see:");
        for(int i = 0; i < descriptions.length; i++) {
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