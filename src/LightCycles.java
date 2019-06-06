import java.io.File;


import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class LightCycles extends JFrame implements ActionListener {

    private static Player Player1 = new Player();
    private static Grid GameGrid = new Grid();
    private static Bike PlayerBike = new Bike();
    private static int gridSize = 500;
    private JButton singlePlayerGame = new JButton("Single Player Game");
    private JButton twoPlayerGame = new JButton("Two Player Game");
    private JButton resetButton = new JButton("RESTART");
    private JButton exitGame = new JButton("Exit");
    private JButton red = new JButton("     ");
    private JButton blue = new JButton("     ");
    private JButton green = new JButton("     ");
    private JButton yellow = new JButton("     ");
    private JButton pink = new JButton("     ");
    private JButton cyan = new JButton("     ");
    private JButton magenta = new JButton("     ");
    private JButton orange = new JButton("     ");
    private final static String MENU = "Main Menu";
    private final static String OPTIONS = "Options";
    private final Font bigFont = new Font("Arial", Font.PLAIN, 30);
    private final Font smallFont = new Font("Calibri", Font.BOLD, 15);
    private JTextField nameField1 = new JTextField(GameGrid.getpOneName(), 20);
    private JTextField nameField2 = new JTextField(GameGrid.getpTwoName(), 20);
    private String[] gridSizeStrings = new String[]{"Small", "Medium", "Large"};
    private JComboBox gridList = new JComboBox(gridSizeStrings);

    private LightCycles()
    {
        singlePlayerGame.addActionListener(this);
        twoPlayerGame.addActionListener(this);
        exitGame.addActionListener(this);
        resetButton.addActionListener(this);
        red.setBackground(Color.RED);
        red.addActionListener(this);

        blue.setBackground(Color.BLUE);
        blue.addActionListener(this);

        green.setBackground(Color.GREEN);
        green.addActionListener(this);

        yellow.setBackground(Color.YELLOW);
        yellow.addActionListener(this);

        pink.setBackground(Color.PINK);
        pink.addActionListener(this);

        cyan.setBackground(Color.CYAN);
        cyan.addActionListener(this);

        magenta.setBackground(Color.MAGENTA);
        magenta.addActionListener(this);

        orange.setBackground(Color.ORANGE);
        orange.addActionListener(this);

        nameField1.addActionListener(this);
        nameField2.addActionListener(this);
    }

    public static void main(String args[]) throws IOException {
        //Create and set up the content pane
        LightCycles mainFrame = new LightCycles();
        mainFrame.setSize(500, 400);
        mainFrame.addComponentToPane(mainFrame.getContentPane());
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
    }

    private void addComponentToPane(Container pane) throws IOException {

        try {
            Image img = ImageIO.read(new File("1p.png"));
            singlePlayerGame.setIcon(new ImageIcon(img));
            singlePlayerGame.setBackground(Color.white);

            Image img1 = ImageIO.read(new File("2p.png"));
            twoPlayerGame.setIcon(new ImageIcon(img1));
            twoPlayerGame.setBackground(Color.white);


            Image img2 = ImageIO.read(new File("exit.png"));
            exitGame.setIcon(new ImageIcon(img2));
            exitGame.setBackground(Color.white);

        } catch (IOException ex) {
        }

        ;
        JLabel title = new JLabel("Tron Light Cycle Game");
        title.setFont(new Font("STXingkai", Font.PLAIN, 34));
        title.setForeground(Color.white);
        title.setSize(300, 80);

        //creates the tabbed pane which everything will be on
        JTabbedPane tabbedpane = new JTabbedPane();


        ImagePanel menu = new ImagePanel(
                new ImageIcon("homepage.jpg").getImage());

        //creates the menu card
        //JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
        //menu.setBackground(Color.BLACK);

        menu.setPreferredSize(super.getSize());
        singlePlayerGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        singlePlayerGame.setFont(bigFont);
        twoPlayerGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        twoPlayerGame.setFont(bigFont);
        exitGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitGame.setFont(bigFont);
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resetButton.setFont(bigFont);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        menu.add(Box.createRigidArea(new Dimension(0,20))); //adds space between the elements
        menu.add(title);
        menu.add(Box.createRigidArea(new Dimension(0,400))); //adds space between the elements
        menu.add(singlePlayerGame);
        menu.add(Box.createRigidArea(new Dimension(0,0))); //adds space between the elements
        menu.add(twoPlayerGame);
        menu.add(Box.createRigidArea(new Dimension(0,0))); //adds space between the elements
        menu.add(resetButton);
        menu.add(Box.createRigidArea(new Dimension(0,0))); //adds space between the elements
        menu.add(exitGame);


        //creates the options card

        ImagePanel options = new ImagePanel(
                new ImageIcon("homepage.jpg").getImage());

        //JPanel options = new JPanel();
        options.setBackground(Color.BLACK);
        options.setLayout(new BoxLayout(options, BoxLayout.PAGE_AXIS));
        options.add(Box.createRigidArea(new Dimension(0,50))); //adds space between the elements

        Container colourCon1 = new Container();
        colourCon1.setLayout(new FlowLayout());
        options.add(colourCon1);
        JLabel colourLabel = new JLabel("Player 1 Bike Colour: ");
        colourLabel.setFont(smallFont);
        colourLabel.setForeground(Color.WHITE);
        colourCon1.add(colourLabel);
        colourCon1.add(red);
        colourCon1.add(blue);
        colourCon1.add(green);
        colourCon1.add(yellow);

        Container nameCon1 = new Container();
        nameCon1.setLayout(new FlowLayout());
        options.add(nameCon1);
        JLabel nameLabel = new JLabel("Player 1 Name: ");
        nameLabel.setFont(smallFont);
        nameLabel.setForeground(Color.WHITE);
        nameField1.setFont(smallFont);
        nameCon1.add(nameLabel);
        nameCon1.add(nameField1);

        Container colourCon2 = new Container();
        colourCon2.setLayout(new FlowLayout());
        options.add(colourCon2);
        JLabel colourLabel2 = new JLabel("Player 2 Bike Colour: ");
        colourLabel2.setFont(smallFont);
        colourLabel2.setForeground(Color.WHITE);
        colourCon2.add(colourLabel2);
        colourCon2.add(pink);
        colourCon2.add(cyan);
        colourCon2.add(magenta);
        colourCon2.add(orange);

        Container nameCon2 = new Container();
        nameCon2.setLayout(new FlowLayout());
        options.add(nameCon2);
        JLabel nameLabel2 = new JLabel("Player 2 Name: ");
        nameLabel2.setFont(smallFont);
        nameLabel2.setForeground(Color.WHITE);
        nameField2.setFont(smallFont);
        nameCon2.add(nameLabel2);
        nameCon2.add(nameField2);

        Container gridCon = new Container();
        gridCon.setLayout(new FlowLayout());
        options.add(gridCon);
        JLabel gLabel = new JLabel("Pick the Grid Size: ");
        gLabel.setFont(smallFont);
        gLabel.setForeground(Color.WHITE);
        gridList.setSelectedIndex(0);
        gridList.addActionListener(this);
        gridCon.add(gLabel);
        gridCon.add(gridList);



        //adds the cards as tabs to the tabbedpane
        tabbedpane.addTab(MENU, menu);
        tabbedpane.addTab(OPTIONS, options);

        pane.add(tabbedpane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == exitGame) {
            //exits the game
            System.exit(0);
        }
        else if(source == singlePlayerGame){
            //loads the light cycles game
            GameGrid.setGameMode(1);
            startGame();
        }

        else if(source == twoPlayerGame){
            //loads the light cycles game
            GameGrid.setGameMode(2);
            startGame();
        }
        else if(source == resetButton) {
            //exits the game
            ClassLoader loader = LightCycles.class.getClassLoader();
            ClassLoader ParentLoader = loader.getParent();
        }
        //lets the user change player 1's colour
        else if(source == red){
            GameGrid.setpOneColour(red.getBackground()); //sets the bike colour to red
        }

        else if(source == blue){
            GameGrid.setpOneColour(blue.getBackground()); //sets the bike colour to blue
        }

        else if(source == green){
            GameGrid.setpOneColour(green.getBackground()); //sets the bike colour to green
        }

        else if(source == yellow){
            GameGrid.setpOneColour(yellow.getBackground()); //sets the bike colour to yellow
        }

        //lets the user change player 2's colour
        else if(source == pink){
            GameGrid.setpTwoColour(pink.getBackground()); //sets the bike colour to pink
        }

        else if(source == cyan){
            GameGrid.setpTwoColour(cyan.getBackground()); //sets the bike colour to cyan
        }

        else if(source == magenta){
            GameGrid.setpTwoColour(magenta.getBackground()); //sets the bike colour to magenta
        }

        else if(source == orange){
            GameGrid.setpTwoColour(orange.getBackground()); //sets the bike colour to orange
        }

        //lets the user change player 1's name
        else if(source == nameField1){
            String name = nameField1.getText();
            GameGrid.setpOneName(name);
        }

        //lets the user change player 2's name
        else if(source == nameField2){
            String name = nameField2.getText();
            GameGrid.setpTwoName(name);
        }

        else if (source == gridList){
            JComboBox cb = (JComboBox)e.getSource();
            String text = (String)cb.getSelectedItem();
            switch(text){
                case "Small":
                    gridSize = 500;
                    GameGrid.setGridSize(gridSize);
                    break;
                case "Medium":
                    gridSize = 700;
                    GameGrid.setGridSize(gridSize);
                    break;
                case "Large":
                    gridSize = 900;
                    GameGrid.setGridSize(gridSize);
                    break;
            }
        }
    }

    private static void startGame(){
        JFrame gameFrame = new JFrame();
        gameFrame.setSize(gridSize + 50, gridSize + 100);
        gameFrame.setVisible(true);
        gameFrame.add(GameGrid, BorderLayout.CENTER);
        gameFrame.getContentPane().setBackground(Color.BLACK);; //here

        gameFrame.setResizable(false);

        gameFrame.setTitle("Tron Game");
        gameFrame.setLocationRelativeTo(null);
        GameGrid.startGame();
    }

}