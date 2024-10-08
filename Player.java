import java.util.Arrays; 

class Player {
    static final int dirtyMax = 6;
    static final int bowelsMax = 6;
    static final int bladderMax = 4;
    static final int quenchedMax = 6;
    static final int satiatedMax = 6;
    static final int minDice = 2;
    static final int maxDice = 8;
    static final String missedTurnNotice = "You lost a turn!";
    int[] currentDice = new int[maxDice];
    private int currentDiceCount = 3;
    int dirty = 0;
    int bowels = 0;
    int bladder = 0;
    int satiated = satiatedMax;
    int quenched = quenchedMax;
    float cash = 0f;
    public boolean missTurn = false;

    public boolean increaseDice() {
        return setDice(1);
    }
    public boolean decreaseDice() {
        return setDice(-1);
    }
    private boolean setDice(int val) {
        boolean success = true;
        if(val < 0 && currentDiceCount+val >= minDice) {
            currentDice[currentDiceCount-1] = 0;
            currentDiceCount += val;
        }else if(val > 0 && currentDiceCount+val <= maxDice){
            currentDice[currentDiceCount] = SystemSupport.rollD6();
            currentDiceCount += val;
        }
        else success = false;
        return success;
    }
    public String getCurrentDice() {
        String dice = "";
        for(int i = 0; i < maxDice; i++) {
            if(currentDice[i] > 0) dice += String.format("Die %d: %d\n", i, currentDice[i]);
        }
        return dice;
    }
    public void rollDice() {
        Arrays.fill(currentDice,0,maxDice, 0);
        for(int i = 0; i < currentDiceCount; i++) {
            currentDice[i] = SystemSupport.rollD6();
        }
    }
    public void passTime() {
        if(bowels < bowelsMax) bowels++;
        else {
            if(SystemSupport.rollD4() <= 1 && dirty < dirtyMax) dirty++;
        }
        if(bladder < bladderMax) bladder++;
        else {
            if(SystemSupport.rollD4() <= 2 && dirty < dirtyMax) dirty++;
        }
        if(satiated > 0) satiated--;
        if(quenched > 0) quenched--;

        if(satiated <= satiatedMax/2 && quenched <= quenchedMax/2) {
            if(SystemSupport.rollD4() == 1) missTurn = true;
        }
    }
    public boolean isMissTurn() {
        return missTurn;
    }
    public String getBowelsStatus() {
        String status = "Peeking!";
        if(bowels >= bowelsMax - 1) status = "Nice and empty.";
        else if (bowels >= bowelsMax - 3) status = "Feeling disquieting rumblings.";
        return status;
    }
    public String getBladderStatus() {
        String status = "Near to bursting!";
        if(bladder >= bladderMax - 1) status = "Empty.";
        else if (bladder >= bladderMax - 3) status = "Could release.";
        return status;
    }
    public String getQuenchedStatus() {
        String status = "Could really use a drink.";
        if(quenched >= quenchedMax - 1) status = "Feeling moist.";
        else if (quenched >= quenchedMax - 3) status = "Feeling a little thirsty.";
        return status;
    }
    public String getSatiatedStatus() {
        String status = "Could really use a bite.";
        if(satiated >= satiatedMax - 1) status = "Feeling full.";
        else if (satiated >= satiatedMax - 3) status = "Feeling a little hungry.";
        return status;
    }
}