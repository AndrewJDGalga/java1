import java.util.Arrays; 

class Player {
    static final int dirtyMax = 6;
    static final int poopMax = 6;
    static final int peeMax = 4;
    static final int quenchedMax = 6;
    static final int satiatedMax = 6;
    static final int minDice = 2;
    static final int maxDice = 8;
    int[] currentDice = new int[maxDice];
    private int currentDiceCount = 3; 
    int dirty = 0;
    int poop = 0;
    int pee = 0;
    int satiated = satiatedMax;
    int quenched = quenchedMax;
    float cash = 0f;

    public String getCurrentDice() {
        return Arrays.toString(currentDice);
    }
    public void rollDice() {
        Arrays.fill(currentDice,0,maxDice, 0);
        for(int i = 0; i < currentDiceCount; i++) {
            currentDice[i] = SystemSupport.rollD6();
        }
    }
    public String getQuenchedStatus() {
        String status = "";
            if(quenched >= quenchedMax - 1) status = "Feeling moist.";
            else if (quenched >= quenchedMax - 3) status = "Feeling a little thirsty.";
            else status = "Could really use a drink.";
        return status;
    }
    public String getSatiatedStatus() {
        String status = "";
            if(satiated >= satiatedMax - 1) status = "Feeling full.";
            else if (satiated >= satiatedMax - 3) status = "Feeling a little hungry.";
            else status = "Could really use a bite.";
        return status;
    }
}