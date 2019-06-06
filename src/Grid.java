import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Grid extends JPanel implements ActionListener {

    private int gridHeight = 500;
    private int gridWidth = 500;
    private int height = gridHeight + 50;
    private int width = gridWidth + 50;
    private final int dot_size = 10;
    private final int total_dots = (gridWidth * gridHeight)/(dot_size*dot_size);
    private boolean inGame = true;
    private int players = 1;
    private int win = 500;

    //Player 1 variables
    private int pOneX[] = new int[total_dots];
    private int pOneY[] = new int[total_dots];
    private int pOneDots;
    private int pOneDELAY = 140;
    private Color pOneColour = Color.RED;
    private String pOneName = "Player 1";
    private int pOneScore = 0;
    private boolean pOneLeft = false;
    private boolean pOneRight = true;
    private boolean pOneUp = false;
    private boolean pOneDown = false;
    private boolean pOneBoostOn = false;
    private Timer pOneTimer;

    //Player 2 variables
    private int pTwoX[] = new int[total_dots];
    private int pTwoY[] = new int[total_dots];
    private int pTwoDots;
    private int pTwoDELAY = 140;
    private Color pTwoColour = Color.PINK;
    private String pTwoName = "Player 2";
    private int pTwoScore = 0;
    private boolean pTwoLeft = true;
    private boolean pTwoRight = false;
    private boolean pTwoUp = false;
    private boolean pTwoDown = false;
    private boolean pTwoBoostOn = false;
    private Timer pTwoTimer;

    Grid(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(width, height));
    }

    void startGame(){
        //If it is a single player game
        pOneDots = 3;
        for (int z = 0; z < pOneDots; z++) {
            pOneX[z] = 50 - z * 10;
            pOneY[z] = 50;
        }
        pOneTimer = new Timer(pOneDELAY, this);
        pOneTimer.start();

        //If it is a two player game
        if(players == 2){
            pTwoDots = 3;
            for (int z = 0; z < pTwoDots; z++) {
                pTwoX[z] = (gridWidth - 20) - z * 10;
                pTwoY[z] = (gridHeight - 40);
            }
            pTwoTimer = new Timer(pTwoDELAY, this);
            pTwoTimer.start();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (inGame) {

            paintBike1(g);
            if(players == 2) {
                paintBike2(g);
            }
        }
        else{
            paintBack(g);
            gameOver(g);
            paintScore1(g);
            if(players == 2) {
                paintScore2(g);
            }
        }
    }

    private void paintBike1(Graphics bike) {

        for (int z = 0; z < pOneDots; z++) {
            if (z == 0) {
                //draw the bike
                bike.setColor(pOneColour);
                bike.fillRect(pOneX[z], pOneY[z], 10, 10);
            }
            else {
                //draw trail
                bike.setColor(pOneColour);
                bike.fillRect(pOneX[z], pOneY[z], 10, 10);
            }
        }
    }

    private void paintBike2(Graphics bike) {
        for (int z = 0; z < pTwoDots; z++) {
            if (z == 0) {
                //draw the bike
                bike.setColor(pTwoColour);
                bike.fillRect(pTwoX[z], pTwoY[z], 10, 10);
            }
            else {
                //draw trail
                bike.setColor(pTwoColour);
                bike.fillRect(pTwoX[z], pTwoY[z], 10, 10);
            }
        }
    }



    private void gameOver(Graphics g) {
        //Displays "Game Over"
        String msg = "Game Over";
        Font big = new Font("Helvetica", Font.BOLD, 30);
        FontMetrics metr = getFontMetrics(big);

        g.setColor(Color.red);
        g.setFont(big);
        g.drawString(msg, (width - metr.stringWidth(msg)) / 2, height / 2);

    }

    private void paintScore1(Graphics g){
        String scoreString = Integer.toString(pOneScore);
        String message = (pOneName + ": " + scoreString + " points");
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.GRAY);
        g.setFont(small);
        g.drawString(message, (width - metr.stringWidth(message)) / 2, (height / 2) + 50);
    }

    private void paintScore2(Graphics g){
        String scoreString = Integer.toString(pTwoScore);
        String message = (pTwoName + ": " + scoreString + " points");
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr2 = getFontMetrics(small);

        g.setColor(Color.gray);
        g.setFont(small);
        g.drawString(message, (width - metr2.stringWidth(message)) / 2, (height / 2) + 100);
    }

    private void paintBack(Graphics g){
        //paints a white box so you can read the game over text better
        g.setColor(Color.white);
        g.fillRect((width/2) - 100, (height/2) - 60, 200, 200);
    }

    private void move() {

        pOneDots++;

        if(pOneBoostOn){
            pOneScore += 2;
        }

        else if (!pOneBoostOn){
            pOneScore += 1;
        }

        for (int z = pOneDots; z > 0; z--) {
            pOneX[z] = pOneX[(z - 1)];
            pOneY[z] = pOneY[(z - 1)];
        }

        if (pOneLeft) {
            pOneX[0] -= dot_size;
        }

        if (pOneRight) {
            pOneX[0] += dot_size;
        }

        if (pOneUp) {
            pOneY[0] -= dot_size;
        }

        if (pOneDown) {
            pOneY[0] += dot_size;
        }

        //if its two player, this looks after moving the second player
        if(players == 2){
            pTwoDots++;

            if(pTwoBoostOn){
                pTwoScore += 2;
            }

            else if (!pTwoBoostOn){
                pTwoScore += 1;
            }


            for (int z = pTwoDots; z > 0; z--) {
                pTwoX[z] = pTwoX[(z - 1)];
                pTwoY[z] = pTwoY[(z - 1)];
            }

            if (pTwoLeft) {
                pTwoX[0] -= dot_size;
            }

            if (pTwoRight) {
                pTwoX[0] += dot_size;
            }

            if (pTwoUp) {
                pTwoY[0] -= dot_size;
            }

            if (pTwoDown) {
                pTwoY[0] += dot_size;
            }
        }
    }

    private void checkCollision() {
        //checks to see if player 1's bike collides with a jet wall or a border
        for (int z = pOneDots; z > 0; z--) {
            if ((z > 4) && (pOneX[0] == pOneX[z]) && (pOneY[0] == pOneY[z])) {
                pTwoScore += win;
                inGame = false;
            }
        }

        if (pOneY[0] >= gridHeight) {
            pTwoScore += win;
            inGame = false;
        }

        if (pOneY[0] < 20) {
            pTwoScore += win;
            inGame = false;
        }

        if (pOneX[0] >= gridWidth) {
            pTwoScore += win;
            inGame = false;
        }

        if (pOneX[0] < 20) {
            pTwoScore += win;
            inGame = false;
        }

        if(!inGame) {
            pOneTimer.stop();
        }

        if(players == 2) {
            //checks to see if player 2's bike collides with a jet wall or a border
            //checks for collision with own wall
            for (int z = pTwoDots; z > 0; z--) {
                if ((z > 4) && (pTwoX[0] == pTwoX[z]) && (pTwoY[0] == pTwoY[z])) {
                    pOneScore += win;
                    inGame = false;
                } else if ((z > 4) && (pTwoX[0] == pOneX[z]) && (pTwoY[0] == pOneY[z])) {
                    pOneScore += win;
                    inGame = false;
                }
                //checks for player 1 collision with player 2 jetwall
                else if ((z > 4) && (pOneX[0] == pTwoX[z]) && (pOneY[0] == pTwoY[z])) {
                    pTwoScore += win;
                    inGame = false;
                }
            }

            if (pTwoY[0] >= gridHeight) {
                pOneScore += win;
                inGame = false;
            }

            if (pTwoY[0] < 20) {
                pOneScore += win;
                inGame = false;
            }

            if (pTwoX[0] >= gridWidth) {
                pOneScore += win;
                inGame = false;
            }

            if (pTwoX[0] < 20) {
                pOneScore += win;
                inGame = false;

            }

            if (!inGame && players == 2) {
                pOneTimer.stop();
                pTwoTimer.stop();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            checkCollision();
            move();
        }
        revalidate();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            //checks to see which key has been pressed, and does not let the bike "back track on itself"

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!pOneRight)) {
                //left key
                pOneLeft = true;
                pOneUp = false;
                pOneDown = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!pOneLeft)) {
                //right key
                pOneRight = true;
                pOneUp = false;
                pOneDown = false;
            }

            if ((key == KeyEvent.VK_UP) && (!pOneDown)) {
                //up key
                pOneUp = true;
                pOneRight = false;
                pOneLeft = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!pOneUp)) {
                //down key
                pOneDown = true;
                pOneRight = false;
                pOneLeft = false;
            }

            if (key == KeyEvent.VK_SPACE) {
                //speeds up the bike
                if (pOneBoostOn){
                    pOneDELAY = 140;
                    pOneTimer.setDelay(pOneDELAY);
                    pOneBoostOn = false;
                }
                else {
                    pOneDELAY = 70;
                    pOneTimer.setDelay(pOneDELAY);
                    pOneBoostOn = true;
                }
            }
            if(players == 2){
                if ((key == KeyEvent.VK_A) && (!pTwoRight)) {
                    //left key for player 2
                    pTwoLeft = true;
                    pTwoUp = false;
                    pTwoDown = false;
                }

                if ((key == KeyEvent.VK_D) && (!pTwoLeft)) {
                    //right key for player 2
                    pTwoRight = true;
                    pTwoUp = false;
                    pTwoDown = false;
                }

                if ((key == KeyEvent.VK_W) && (!pTwoDown)) {
                    //up key for player 2
                    pTwoUp = true;
                    pTwoRight = false;
                    pTwoLeft = false;
                }

                if ((key == KeyEvent.VK_S) && (!pTwoUp)) {
                    //down key for player 2
                    pTwoDown = true;
                    pTwoRight = false;
                    pTwoLeft = false;
                }

                if (key == KeyEvent.VK_SHIFT) {
                    //speeds up the bike for player 2
                    if (pTwoBoostOn){
                        pTwoDELAY = 140;
                        pTwoTimer.setDelay(pTwoDELAY);
                        pTwoBoostOn = false;
                    }
                    else {
                        pTwoDELAY = 70;
                        pTwoTimer.setDelay(pTwoDELAY);
                        pTwoBoostOn = true;
                    }
                }
            }
        }
    }

    void setpOneColour(Color colour){
        //Allows the user to change the colour of their bike
        this.pOneColour = colour;
    }

    void setpOneName(String name) {
        //Allow the player to set/change their name
        this.pOneName = name;
    }

    void setpTwoColour(Color colour){
        //Allows the user to change the colour of their bike
        this.pTwoColour = colour;
    }

    void setpTwoName(String name) {
        //Allow the player to set/change their name
        this.pTwoName = name;
    }

    String getpOneName() {
        return pOneName;
    }

    String getpTwoName() {
        return pTwoName;
    }

    void setGridSize(int size) {
        //Allows the user to change the size of the grid
        this.gridWidth = size;
        this.gridHeight = size;
        this.width = gridWidth + 50;
        this.height = gridHeight + 50;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    void setGameMode(int answer){
        players = answer;
    }
}
