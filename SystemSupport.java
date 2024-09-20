final class SystemSupport {
    private SystemSupport() {}
    
    static int rollD6() {
        return rollDie(6);
    }
    static int rollD8() {
        return rollDie(8);
    }
    private static int rollDie(int max) {
        return (int)(Math.random() * max) + 1;
    }
}