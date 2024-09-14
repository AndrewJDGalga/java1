

public class Game {
    public static void main(String[] args) {
        String[] trashTable = {
            "drink",
            "snack",
            "caffeine_half",
            "beer_half",
            "change_half"
        };
        for(int i = 0; i < 1000; i++) {
            if(rollD6() > 6 || rollD6() < 1) System.out.println(rollD6());
        }
    }

    static int rollD6() {
        return (int)(Math.random() * 6) + 1;
    }
}