package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends Panel {

    private static int playedID;
    public static boolean canGo;
    public static Color playerColor;
    public static Color enemyColor;
    public static String carType;

    public static GameWindow gameWindow;

    public static int windowSize = 800;
    public static int unitSize = 80;

    public static JButton dice;

    public static int diceSize = 100;

    public static int currentPlayerSquare = 1;
    private static int enemyPlayerSquare = 1;

    public GameWindow (int width, int height, boolean needBorder) {
        super(width, height, needBorder);
    }

    public static String rolledMessage;
    public static boolean rollPressed = false;

    public static GameWindow ShowWindow()
    {
        carType = LoginWindow.inputCarType.getSelectedItem().toString();

        Director director = new Director();
        CarBuilder builder = new CarBuilder();

        switch (carType){
            case "Race Car":
                director.constructRaceCar(builder);
                System.out.println(builder.getResult());
            case "Rally Car":
                director.constructRallyCar(builder);
                System.out.println(builder.getResult());
            case "Truck Car":
                director.constructTruckCar(builder);
                System.out.println(builder.getResult());
        }

        Chat.AddMessage(builder.getResult().toString());
        playedID = Client.playerID;

        if(playedID == 0){
            playerColor = Color.blue;
            enemyColor = Color.red;
            canGo = true;
        }
        else{
            playerColor = Color.red;
            enemyColor = Color.blue;
            canGo = false;
        }

        gameWindow = new GameWindow(windowSize, windowSize, true);

        ImageIcon diceIcon = new ImageIcon(Images.dice1.getImage().getScaledInstance(diceSize, diceSize, 0));
        dice = new JButton(diceIcon);
        dice.setBorder(null);
        dice.setBackground(null);
        dice.setLayout(null);
        dice.setBorderPainted(false);
        dice.setContentAreaFilled(false);
        dice.setFocusPainted(false);
        dice.setOpaque(false);
        dice.setMargin(new Insets(0, 0, 0, 0));
        gameWindow.add(dice);

        dice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(canGo) {


                    int rolledNumber = Dice.Roll();
                    currentPlayerSquare += rolledNumber;

                    if (currentPlayerSquare > 26) {
                        currentPlayerSquare = currentPlayerSquare - 26;
                    }
                    Square[][] map = MapGenerator.Generate();
                    boolean finishCalculation = false;
                    for ( int row = 0; row < 10; row++ ){
                        for ( int column = 0; column < 10; column++ ){
                            if(currentPlayerSquare ==map[row][column].ReturnNumber()){
                                currentPlayerSquare = map[row][column].onTriggerEnter(currentPlayerSquare);
                                finishCalculation = true;
                                break;
                            }
                        }
                        if(finishCalculation){
                            finishCalculation = false;
                            break;
                        }
                    }
                    rolledMessage = String.valueOf(rolledNumber) + "," + String.valueOf(currentPlayerSquare);
                    System.out.println("Formed: " + rolledMessage);

                    ChangeDice(rolledNumber);

                    gameWindow.repaint();

                    canGo = false;
                    rollPressed = true;
                }
            }
        });

        return gameWindow;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // background;
        //g2d.setColor(Color.cyan);
        //g2d.fillRect(0, 0, gameWindow.pWidth, gameWindow.pHeight);
        //  ---------------------

        // map drawing ------------------------------
        Square[][] map = MapGenerator.Generate();

        for ( int row = 0; row < 10; row++ ){
            for ( int column = 0; column < 10; column++ ){

                map[row][column].SetCoord(column*unitSize, row*unitSize);
                map[row][column].DrawSquare(g2d,column*unitSize, row*unitSize, unitSize, unitSize);

                if(map[row][column].ReturnType() == 1){
                    //if(map[row][column].ReturnNumber() == 1){
                        //g2d.setColor(Color.RED);
                    //    g2d.fillRect(column*unitSize, row*unitSize, unitSize, unitSize);
                    //}else{
                     //   //g2d.setColor(Color.ORANGE);
                    //    //g2d.fillRect(column*unitSize, row*unitSize, unitSize, unitSize);
                    //}

                    g2d.setColor(Color.black);
                    g2d.drawString(String.valueOf(map[row][column].ReturnNumber()), map[row][column].GetCenterCoord()[0], map[row][column].GetCenterCoord()[1]);

                    if(map[row][column].ReturnNumber() == currentPlayerSquare){
//                        drawPlayer(g2d, map[row][column].ReturnX(), map[row][column].ReturnY(), carType);
                        drawPlayer(g2d, map[row][column].ReturnX(), map[row][column].ReturnY());
                    }

                    if(map[row][column].ReturnNumber() == enemyPlayerSquare){
//                        drawEnemy(g2d, map[row][column].ReturnX(), map[row][column].ReturnY(), carType);
                        drawEnemy(g2d, map[row][column].ReturnX(), map[row][column].ReturnY());
                    }
                }

                if(map[row][column].ReturnType() == 10){
                    dice.setBounds(map[row][column].ReturnX(), map[row][column].ReturnY(), unitSize, unitSize);
                }
            }
        }
    }

    public void drawPlayer(Graphics2D g2d, int x, int y)
    {
        g2d.setColor(playerColor);
        g2d.fillOval(x, y,30,30);
    }

    public void drawEnemy(Graphics2D g2d, int x, int y)
    {
        g2d.setColor(enemyColor);
        g2d.fillOval(x + unitSize - 30, y, 30, 30);
    }

    public void drawPlayer(Graphics2D g2d, int x, int y, String carType){
        g2d.setColor(playerColor);
//        g2d.fillOval(x, y, 30, 30);
        switch (carType) {
            case "Race Car":
                g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g2d.drawString(carType, x, y);
//                g2d.drawPolygon(new int[]{10, 20, 30}, new int[]{100, 200, 300}, 3);
            case "Rally Car":
                g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g2d.drawString(carType, x, y);
//                g2d.fillRect(x, y, 20,30);
            case "Truck Car":
                g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g2d.drawString(carType, x, y);
        }
    }

    public void drawEnemy(Graphics2D g2d, int x, int y, String carType) {
        g2d.setColor(enemyColor);
        //        g2d.fillOval(x, y, 30, 30);
        switch (carType) {
            case "Race Car":
                g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g2d.drawString(carType, x + unitSize - 30, y);
//                g2d.drawPolygon(new int[]{10, 20, 30}, new int[]{100, 200, 300}, 3);
            case "Rally Car":
                g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g2d.drawString(carType, x + unitSize - 30, y);
//                g2d.fillRect(x, y, 20,30);
            case "Truck Car":
                g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g2d.drawString(carType, x + unitSize - 30, y);
        }
    }

    public static void ChangeDice(int number) {
        switch (number) {
            case 1:
                dice.setIcon(new ImageIcon(Images.dice1.getImage().getScaledInstance(diceSize, diceSize, 0)));
                break;
            case 2:
                dice.setIcon(new ImageIcon(Images.dice2.getImage().getScaledInstance(diceSize, diceSize, 0)));
                break;
            case 3:
                dice.setIcon(new ImageIcon(Images.dice3.getImage().getScaledInstance(diceSize, diceSize, 0)));
                break;
            case 4:
                dice.setIcon(new ImageIcon(Images.dice4.getImage().getScaledInstance(diceSize, diceSize, 0)));
                break;
            case 5:
                dice.setIcon(new ImageIcon(Images.dice5.getImage().getScaledInstance(diceSize, diceSize, 0)));
                break;
            case 6:
                dice.setIcon(new ImageIcon(Images.dice6.getImage().getScaledInstance(diceSize, diceSize, 0)));
                break;
        }
    }

    public static void EnemyRolled(String[] messageArray){
        canGo = true;

        ChangeDice(Integer.parseInt(messageArray[0]));

        enemyPlayerSquare = Integer.parseInt(messageArray[1]);

        gameWindow.repaint();
    }

}
