public class Player {

    private int playerID;
    private String playerName;
    private String playerColour;
    //Allows the player to speed up
    private char speedUp;
    //Allows the player to slow down
    private char speedDown;
    //Allows the player to rotate 90 degrees to the left
    private char moveLeft;
    //Allows the player to rotate 90 degrees to the right
    private char moveRight;
    //Allows the player to toggle their jetwall on/off
    private char jetWall;

    Player(){
        //Default player variables, like name, ID, colour, and controls
        playerID = 1;
        playerName = "Player" + playerID;
        playerColour = "Red";
        speedUp = 'w';
        speedDown = 's';
        moveLeft = 'a';
        moveRight = 'd';
        jetWall = 'e';
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID)
    {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    void setPlayerName(String playerName) {
        //Allow the player to set/change their name
        this.playerName = playerName;
        System.out.println("You have changed your name to " + this.playerName);
    }

    public String getPlayerColour() {
        return playerColour;
    }

    void setPlayerColour(String playerColour) {
        //Allow the player to change the colour of their player and bike
        this.playerColour = playerColour;
        System.out.println("You have changed your colour to " + this.playerColour);
    }

    void setPlayerControls(char moveUp, char moveDown, char moveLeft, char moveRight, char jetWall){
        //Allow the player to change their controls
        this.speedUp = moveUp;
        System.out.println("Speed up is now set to " + moveUp);
        this.speedDown = moveDown;
        System.out.println("Slow down is now set to " + moveDown);
        this.moveLeft = moveLeft;
        System.out.println("Turn left is now set to " + moveLeft);
        this.moveRight = moveRight;
        System.out.println("Turn right is now set to " + moveRight);
        this.jetWall = jetWall;
        System.out.println("Jetwall toggle is now set to " + jetWall);
        System.out.println("You have successfully changed your controls");
    }
}
