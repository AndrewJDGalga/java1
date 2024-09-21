class Location {
    Patron[] curPatrons;
    String locationName;

    Location(String name){
        locationName = name;
        curPatrons = new Patron[SystemSupport.rollD8() + 1];
        for(int i = 0; i < curPatrons.length; i++) {
            curPatrons[i] = new Patron();
        }
    }
    /*
    public String[] getPatronDescriptions() {

    }
    */
    /* 
    public boolean tryPatron(int selection) {

    }
    */
}