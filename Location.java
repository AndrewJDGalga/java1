class Location {
    Patron[] curPatrons = new Patron[8];
    String locationName;

    Location(String name){
        locationName = name;
        generatePatrons();
    }
    public void generatePatrons() {
        depopulate(curPatrons);
        populate(curPatrons);
    }
    private void populate(Patron[] arr) {
        int randomNewPatrons = SystemSupport.rollD4();
        for(int i = 0; i < arr.length && randomNewPatrons > 0; i++) {
            if(arr[i] == null){
                arr[i] = new Patron();
                randomNewPatrons--;
            }
        }
    }
    public void depopulate(Patron[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != null && arr[i].isLeaving()) arr[i] = null;
        }
    }
    public String[] getPatronDescriptions() {
        String[] arrDescriptions = new String[curPatrons.length];

        for(int i = 0, j= 0; i < curPatrons.length; i++) {
            if(curPatrons[i] != null) arrDescriptions[j++] = curPatrons[i].description;
        }

        return arrDescriptions;
    }
    
    /* 
    public boolean tryPatron(int selection) {

    }
    */
}