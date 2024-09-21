class Location {
    Patron[] curPatrons;
    String locationName;

    Location(String name){
        locationName = name;
        generatePatrons();
    }
    public void generatePatrons() {
        curPatrons = new Patron[SystemSupport.rollD8() + 1];
        for(int i = 0; i < curPatrons.length; i++) {
            curPatrons[i] = new Patron();
        }
    }
    public String[] getPatronDescriptions() {
        String[] arrDescriptions = new String[curPatrons.length];
        for(int i = 0; i < curPatrons.length; i++) {
            arrDescriptions[i] = curPatrons[i].description;
        }
        return arrDescriptions;
    }
    
    /* 
    public boolean tryPatron(int selection) {

    }
    */
}