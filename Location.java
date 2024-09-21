class Location {
    Patron[] curPatrons;
    String locationName;

    Location(String name){
        locationName = name;
        curPatrons = new Patron[SystemSupport.rollD8() + 1];
    }
}