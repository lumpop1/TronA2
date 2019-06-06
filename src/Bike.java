public class Bike {

    private String bikeColour;
    private int bikeID;

    Bike()
    {
        bikeColour = "Red";
        bikeID = 1;
    }

    public int getBikeID() {
        return bikeID;
    }

    public void setBikeID(int bikeID) {
        //sets the bikeID equal to the playerID
        this.bikeID = bikeID;
    }

    public String getBikeColour() {
        return bikeColour;
    }

    void setBikeColour(String bikeColour) {
        //sets the bikeColour equal to the playerColour
        this.bikeColour = bikeColour;
    }
}
