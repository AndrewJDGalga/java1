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
        boolean play = false;

        System.out.println("Welcome to Bus Ticket");
        System.out.println("Goal: Get enough cash together through begging and scrounging to buy a bus ticket before time runs out.\n");

        do {
            System.out.printf("You have: $%.2f\n", player.cash);
            System.out.println("Your dirtiness is " + player.dirty + " out of " + Player.dirtyMax + ".");
            System.out.println("Your quenched status is: " + player.getQuenchedStatus() + ".");
        } while(play);
    }

    static int rollD6() {
        return (int)(Math.random() * 6) + 1;
    }
}

class Player {
    static final int dirtyMax = 6;
    static final int poopMax = 6;
    static final int peeMax = 4;
    static final int quenchedMax = 6;
    static final int satedMax = 6;
    int dirty = 0;
    int poop = 0;
    int pee = 0;
    int sated = satedMax;
    int quenched = quenchedMax;
    float cash = 0f;

    public String getQuenchedStatus() {
        String status = "";
            if(quenched >= quenchedMax - 1) status = "Feeling good";
            else if (quenched >= quenchedMax - 3) status = "Feeling a little thirsty";
            else status = "Could really use a drink";
        return status;
    }
}