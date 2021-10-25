package Game;

import Game.Builder_Prototype.Builder;
import Game.Builder_Prototype.Car;
import Game.Builder_Prototype.CarBuilder;
import Game.Builder_Prototype.Director;
import Game.CommandPattern.*;
import Game.Decorator.Diesel;
import Game.Facade.Facade;
import Game.Decorator.ElectricEngine;
import Game.Decorator.Petrol;
import Game.Decorator.BioFuel;
import Game.Facade.Facade;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GameWindow extends Panel {

    private static int playedID;
    public static boolean canGo;
    public static boolean canPause = true;
    public static Color playerColor;
    public static Color enemyColor;
    public static String carType;

    public static GameWindow gameWindow;

    public static int windowSize = 800;
    public static int unitSize = 80;

    public static JButton dice;
    public static JButton petrol;
    public static JButton pause;

    public static int diceSize = 100;
    public static int pauseButtonSize = 40;

    public static int currentPlayerSquare = 1;
    private static int enemyPlayerSquare = 1;

    public static boolean needUpdate = false;
    public static String updateMessage;

    public GameWindow (int width, int height, boolean needBorder) {
        super(width, height, needBorder);
    }

    public static String rolledMessage;
    public static boolean rollPressed = false;

    public static int pausePressedCount = 0;
    public static boolean pausePlayPressed = false;

    private static Car builderCar;
    private static Car decoratedCar;
    private static Car car;
    private static Car decoratedVehicle;
    private static Car decoratedVehicle1;

    public static GameWindow ShowWindow()
    {
        carType = LoginWindow.inputCarType.getSelectedItem().toString();

        /*Director director = new Director();
        CarBuilder builder = new CarBuilder();
        switch (carType){
            case "Race Car":
                director.constructRaceCar(builder);
                System.out.println(builder.getResult());

                Car car = builder.getCar();
                Car shallowCopy = builder.getCar().copyShallow();
                Car deepCopy = builder.getCar().copyDeep();


                decoratedVehicle = new ElectricEngine(car);
                decoratedVehicle1 = new Petrol(decoratedVehicle);
                decoratedVehicle1.getFuelType();
                System.out.println("primary shield: " + car.getShield().getType() + " | " + System.identityHashCode(car.getShield()));
                System.out.println("shallow copy shield: " + shallowCopy.getShield().getType() + " | " + System.identityHashCode(shallowCopy.getShield()));
                System.out.println("deep copy shield: " + deepCopy.getShield().getType() + " | " + System.identityHashCode(deepCopy.getShield()));
                break;
            case "Rally Car":
                director.constructRallyCar(builder);
                System.out.println(builder.getResult());
                Car carRally = builder.getCar();
                decoratedVehicle = new ElectricEngine(carRally);
                decoratedVehicle1 = new Diesel(decoratedVehicle);
                decoratedVehicle1.getFuelType();
                break;
            default:
                director.constructTruckCar(builder);
                System.out.println(builder.getResult());
                Car carTruck = builder.getCar();
                decoratedVehicle = new ElectricEngine(carTruck);
                decoratedVehicle1 = new BioFuel(decoratedVehicle);
                decoratedVehicle1.getFuelType();
                break;
        }

        car = builder.getCar();

        Chat.AddMessage(builder.getResult().toString());*/

        Facade facade= new Facade();
        CarBuilder builder = facade.demoBuilder(carType);
        decoratedCar = facade.demoDecorator(carType, builder.getCar());

        car = builder.getCar();

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
                    if(car.fuel <= 0){
                        Chat.AddMessage("I can't move. I am out of fuel. I will miss one move :(");
                        car.fuel = 60;
                    }
                    else if (car.health <= 0){
                        Chat.AddMessage("My car is broken. I can't. I will miss one move until my team fixes it.");
                        car.health = 100;
                    }
                    else{
                        //int rolledNumber = Dice.Roll();

                        Dice dice = new Dice();
                        Controller ctrl = new Controller();
                        ICommand cmd = new RollCommand(dice);
                        int rolledNumber = ctrl.run(cmd);

                        currentPlayerSquare += rolledNumber;

                        if (currentPlayerSquare > 26) {
                            currentPlayerSquare = currentPlayerSquare - 26;
                        }
                        Square[][] map = MapGenerator.Generate();
                        boolean finishCalculation = false;
                        for ( int row = 0; row < 10; row++ ){
                            for ( int column = 0; column < 10; column++ ){
                                if(currentPlayerSquare ==map[row][column].ReturnNumber()){
                                    double[] resultsAfterRoll = map[row][column].getSquareAlgorithm().doSquareAction(currentPlayerSquare, car, rolledNumber);
                                    needUpdate = true;
                                    updateMessage = car.fuel + "," + car.health;
                                    currentPlayerSquare = (int)resultsAfterRoll[0];
                                    car.fuel = (int)resultsAfterRoll[1];
                                    car.health = (int)resultsAfterRoll[2];
                                    System.out.println("kuras " + car.fuel);
                                    System.out.println("hp " + car.health);
                                    finishCalculation = true;
                                    break;
                                }
                            }
                            if(finishCalculation){
                                finishCalculation = false;
                                break;
                            }
                        }
                        rolledMessage = String.valueOf(rolledNumber) + "," + String.valueOf(currentPlayerSquare) + "," + String.valueOf((int)car.fuel) + "," + String.valueOf((int)car.health);
                        System.out.println("Formed: " + rolledMessage);

                        ChangeDice(rolledNumber);
                    }

                    gameWindow.repaint();

                    canGo = false;
                    rollPressed = true;
                }
            }
        });

        ImageIcon pauseIcon = new ImageIcon(Images.pause.getImage().getScaledInstance(pauseButtonSize, pauseButtonSize, 0));
        pause = new JButton(pauseIcon);
        pause.setBorder(null);
        pause.setBackground(null);
        pause.setLayout(null);
        pause.setBorderPainted(false);
        pause.setContentAreaFilled(false);
        pause.setFocusPainted(false);
        pause.setOpaque(false);
        pause.setMargin(new Insets(0, 0, 0, 0));
        gameWindow.add(pause);

        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller ctrl = new Controller();
                ICommand cmd = new PauseCommand(pause);
                if(canPause)
                {
                    if(!pausePlayPressed) {
                        canGo = false;
                        pausePlayPressed = true;
                        ctrl.run(cmd);
                    }
                    else if(pausePlayPressed)
                    {
                        ctrl.run(cmd);
                        canGo = true;
                        pausePlayPressed = false;
                        ctrl.undo();
                    }
                    pausePressedCount++;
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
                try {
                    map[row][column].DrawSquare(g2d,column*unitSize, row*unitSize, unitSize, unitSize);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(map[row][column].ReturnType() == 1){
                    //if(map[row][column].ReturnNumber() == 1){
                        //g2d.setColor(Color.RED);
                    //    g2d.fillRect(column*unitSize, row*unitSize, unitSize, unitSize);
                    //}else{
                     //   //g2d.setColor(Color.ORANGE);
                    //    //g2d.fillRect(column*unitSize, row*unitSize, unitSize, unitSize);
                    //}

                    if(map[row][column].ReturnNumber() == currentPlayerSquare){
//                        drawPlayer(g2d, map[row][column].ReturnX(), map[row][column].ReturnY(), carType);
                        try {
                            drawPlayer(g2d, map[row][column].ReturnX(), map[row][column].ReturnY());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if(map[row][column].ReturnNumber() == enemyPlayerSquare){
//                        drawEnemy(g2d, map[row][column].ReturnX(), map[row][column].ReturnY(), carType);
                        try {
                            drawEnemy(g2d, map[row][column].ReturnX(), map[row][column].ReturnY());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                if(map[row][column].ReturnType() == 10){
                    dice.setBounds(map[row][column].ReturnX(), map[row][column].ReturnY(), unitSize, unitSize);
                }

                if(map[row][column].ReturnType() == 11){
                    pause.setBounds(map[row][column].ReturnX(), map[row][column].ReturnY(), unitSize, unitSize);
                }
            }
        }
    }

    public void drawPlayer(Graphics2D g2d, int x, int y) throws IOException {
        g2d.drawImage(ImageIO.read(new File("src/images/red_car.png")), x+unitSize/2-20, y, 50, 50, null);
    }

    public void drawEnemy(Graphics2D g2d, int x, int y) throws IOException {
        g2d.drawImage(ImageIO.read(new File("src/images/blue_car.png")), x+unitSize/2-20, y + 25, 50, 50, null);
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
            case 1 -> dice.setIcon(new ImageIcon(Images.dice1.getImage().getScaledInstance(diceSize, diceSize, 0)));
            case 2 -> dice.setIcon(new ImageIcon(Images.dice2.getImage().getScaledInstance(diceSize, diceSize, 0)));
            case 3 -> dice.setIcon(new ImageIcon(Images.dice3.getImage().getScaledInstance(diceSize, diceSize, 0)));
            case 4 -> dice.setIcon(new ImageIcon(Images.dice4.getImage().getScaledInstance(diceSize, diceSize, 0)));
            case 5 -> dice.setIcon(new ImageIcon(Images.dice5.getImage().getScaledInstance(diceSize, diceSize, 0)));
            case 6 -> dice.setIcon(new ImageIcon(Images.dice6.getImage().getScaledInstance(diceSize, diceSize, 0)));
        }
    }

    public static void ChangePause(boolean pressed) {
        if (!pressed) {
            pause.setIcon(new ImageIcon(Images.pause.getImage().getScaledInstance(pauseButtonSize, pauseButtonSize, 0)));
        } else {
            pause.setIcon(new ImageIcon(Images.play.getImage().getScaledInstance(pauseButtonSize, pauseButtonSize, 0)));
        }
    }

    public static void EnemyRolled(String[] messageArray){
        canGo = true;

        ChangeDice(Integer.parseInt(messageArray[0]));

        enemyPlayerSquare = Integer.parseInt(messageArray[1]);

        gameWindow.repaint();
    }

    public static void EnemyPaused(boolean pressed){

        if(!pressed)
        {
            canGo = false;
            //canPause = true;
        }
        else
        {
            canGo = true;
            //canPause = false;
        }
        //ChangePause(pressed);
    }

}
