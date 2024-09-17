final class SystemSupport {
    private SystemSupport() {}
    
    static int rollD6() {
        return (int)(Math.random() * 6) + 1;
    }
}