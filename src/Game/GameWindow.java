package Game;

import Game.Builder_Prototype_Bridge.Car;
import Game.Builder_Prototype_Bridge.CarBuilder;
import Game.ChainOfResponsibility.AbstractLogger;
import Game.ChainOfResponsibility.ChatLogger;
import Game.ChainOfResponsibility.ErrorConsoleLogger;
import Game.ChainOfResponsibility.FileLogger;
import Game.CommandPattern.*;
import Game.Facade.Facade;
import Game.Composite_Iterator.MainMenu;
import Game.Memento.CareTaker;
import Game.Memento.Originator;
import Game.State.*;
import Game.Visitor.StatusEffectHail;
import Game.Visitor.StatusEffectVisitor;
import Game.Visitor.StatusEffectWind;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameWindow extends Panel {

    private static int playedID;
    public static boolean canGo;
    public static boolean canPause = true;
    public static Color playerColor;
    public static Color enemyColor;
    public static String carType;
    public static String fuelTypes="";

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
    public static Car decoratedCar;
    private static Car car;
    private static Car decoratedVehicle;
    private static Car decoratedVehicle1;

    public static int turnCounter = 0; // how many turns effect lasting so far
    private static final int hailPercentage = 30;
    private static final int windPercentage = 40;
    public static StatusEffectVisitor statusEffect;
    public static boolean isStatusEffectActive = false;

    private static AbstractLogger loggerChain;

    private static boolean endGameAfterTurn = false;

    public static GameWindow ShowWindow()
    {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        loggerChain = getChainOfLoggers();
        carType = MainMenu.carTypeInput;

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

        ImageIcon diceIcon = new ImageIcon(Images.dice1.display().getImage().getScaledInstance(diceSize, diceSize, 0));
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

        Random random = new Random();

        dice.addActionListener(e -> {
            if(canGo) {
                Context context = new Context();

                if(car.fuel <= 0){
                    //Chat.AddMessage("I can't move. I am out of fuel. I will miss one move :(");
                    //car.fuel = 60;
                    EmptyFuel emptyFuel = new EmptyFuel();
                    FillFuel fillFuel = new FillFuel();
                    emptyFuel.Handle(context);
                    fillFuel.Handle(context, car);
                }
                else if (car.health <= 0){
                    //Chat.AddMessage("My car is broken. I can't. I will miss one move until my team fixes it.");
                    //car.health = 100;
                    EmptyHealth emptyHealth = new EmptyHealth();
                    FillHealth fillHealth = new FillHealth();
                    emptyHealth.Handle(context);
                    fillHealth.Handle(context, car);
                }
                else{
                    //int rolledNumber = Dice.Roll();
                    if(careTaker.size()>0) {
                        originator.getStateFromMemento(careTaker.get(careTaker.size() - 1));
                        Chat.AddMessage("Last roll: " + originator.getState());
                    }

                    Dice dice = new Dice();
                    Controller ctrl = new Controller();
                    ICommand cmd = new RollCommand(dice);
                    int rolledNumber = ctrl.run(cmd);

                    originator.setState(String.valueOf(rolledNumber));
                    careTaker.add(originator.saveStateToMemento());

                    currentPlayerSquare += rolledNumber;

                    if (currentPlayerSquare > 26) {
                        endGameAfterTurn = true;
                        currentPlayerSquare = currentPlayerSquare - 26;
                    }

                    Square[][] map = MapGenerator.Generate();
                    boolean finishCalculation = false;
                    for ( int row = 0; row < 10; row++ ){
                        for ( int column = 0; column < 10; column++ ){
                            if(currentPlayerSquare == map[row][column].ReturnNumber()){
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
                            break;
                        }
                    }

                    rolledMessage = rolledNumber + "," + currentPlayerSquare + "," + (int) car.fuel + "," + (int) car.health;

                    CanRoll canRoll = new CanRoll();
                    canRoll.Handle(context, rolledMessage);
                    ChangeDice(rolledNumber);
                }

                if(!isStatusEffectActive){
                    if(random.nextInt(100) < hailPercentage){
                        isStatusEffectActive = true;

                        if(statusEffect == null){
                            turnCounter = 0;
                            statusEffect = new StatusEffectHail();
                        }
                        car.visitPlayerCar(statusEffect);
                        turnCounter++;
                    }
                    else if(random.nextInt(100) < windPercentage){
                        isStatusEffectActive = true;
                        if(statusEffect == null){
                            turnCounter = 0;
                            statusEffect = new StatusEffectWind();
                        }
                    }
                } else {
                    //gameWindow.add(new JButton(new ImageIcon(Images.hail.display().getImage().getScaledInstance(60, 60, 0))));
                    car.visitPlayerCar(statusEffect);
                    turnCounter++;
                }

                if(!endGameAfterTurn) {
                    gameWindow.repaint();

                    canGo = false;
                    rollPressed = true;
                } else {
                    System.out.println("============= GAME WON, current square after roll: " + (currentPlayerSquare) + " =================");
                    canGo = false;
                    canPause = false;

                    var endPanel = new Panel(windowSize / 2, windowSize / 4, true);
                    var exitButton = new JButton("Exit");

                    if(playerColor == Color.blue)
                        endPanel.add(new JLabel("You won the race !"));
                    else
                        endPanel.add(new JLabel("You lost the race . . ."));

                    exitButton.addActionListener(
                            event -> {
                                System.exit(0); // stop program
                            }
                    );

                    endPanel.add(exitButton);

                    gameWindow.add(endPanel, FlowLayout.CENTER);

                    gameWindow.repaint();
                    gameWindow.revalidate();
                }
            }
        });

        ImageIcon pauseIcon = new ImageIcon(Images.pause.display().getImage().getScaledInstance(pauseButtonSize, pauseButtonSize, 0));
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

        pause.addActionListener(e -> {
            Controller ctrl = new Controller();
            ICommand cmd = new PauseCommand(pause);
            if(canPause)
            {
                if(!pausePlayPressed) {
                    canGo = false;
                    pausePlayPressed = true;
                    ctrl.run(cmd);
                }
                else {
                    ctrl.run(cmd);
                    canGo = true;
                    pausePlayPressed = false;
                    ctrl.undo();
                }
                pausePressedCount++;
            }
        });

        if(endGameAfterTurn){
            System.out.println("============= GAME OVER, current square after roll: " + (currentPlayerSquare) + " =================");

            var endPanel = new Panel(windowSize / 2, windowSize / 4, true);
            var exitButton = new JButton("Exit");

            if(playerColor == Color.blue) {
                endPanel.add(new JLabel("You won the race !"));
            }
            else {
                endPanel.add(new JLabel("You lost the race . . ."));
            }

            canGo = false;
            canPause = false;

            exitButton.addActionListener(
                    event -> {
                        System.exit(0); // stop program
                    }
            );

            endPanel.add(exitButton);

            gameWindow.add(endPanel, FlowLayout.CENTER);

            gameWindow.repaint();
            gameWindow.revalidate();
        }

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

        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {

                map[row][column].SetCoord(column * unitSize, row * unitSize);
                try {
                    map[row][column].DrawSquare(g2d, column * unitSize, row * unitSize, unitSize, unitSize);
                } catch (IOException e) {
                    loggerChain.logMessage(AbstractLogger.ERROR_CONSOLE, e.getMessage());
                    e.printStackTrace();
                }

                if (map[row][column].ReturnType() == 1) {
                    //if(map[row][column].ReturnNumber() == 1){
                    //g2d.setColor(Color.RED);
                    //    g2d.fillRect(column*unitSize, row*unitSize, unitSize, unitSize);
                    //}else{
                    //   //g2d.setColor(Color.ORANGE);
                    //    //g2d.fillRect(column*unitSize, row*unitSize, unitSize, unitSize);
                    //}

                    if (map[row][column].ReturnNumber() == currentPlayerSquare) {
                        try {
                            drawPlayer(g2d, map[row][column].ReturnX(), map[row][column].ReturnY());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (map[row][column].ReturnNumber() == enemyPlayerSquare) {
                        try {
                            drawEnemy(g2d, map[row][column].ReturnX(), map[row][column].ReturnY());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                if (map[row][column].ReturnType() == 10) {
                    dice.setBounds(map[row][column].ReturnX(), map[row][column].ReturnY(), unitSize, unitSize);
                }

                if (map[row][column].ReturnType() == 11) {
                    pause.setBounds(map[row][column].ReturnX(), map[row][column].ReturnY(), unitSize, unitSize);
                }
            }
        }
    }

    public void drawPlayer(Graphics2D g2d, int x, int y) throws IOException {
        switch (car.getShield().getType()){
            case("electric shield"):
                g2d.drawImage(ImageIO.read(new File("src/images/Cars/red_car_electric.png")), x+unitSize/2-20, y, 50, 50, null);
            case("forcefield shield"):
                g2d.drawImage(ImageIO.read(new File("src/images/Cars/red_car_forcefield.png")), x+unitSize/2-20, y, 50, 50, null);
            case("magic shield"):
                g2d.drawImage(ImageIO.read(new File("src/images/Cars/red_car_magic.png")), x+unitSize/2-20, y, 50, 50, null);
            default:
                g2d.drawImage(ImageIO.read(new File("src/images/red_car.png")), x+unitSize/2-20, y, 50, 50, null);
        }
    }

    public void drawEnemy(Graphics2D g2d, int x, int y) throws IOException {
        g2d.drawImage(ImageIO.read(new File("src/images/blue_car.png")), x+unitSize/2-20, y + 25, 50, 50, null);
    }

    public static void ChangeDice(int number) {
        switch (number) {
            case 1 -> dice.setIcon(new ImageIcon(Images.dice1.display().getImage().getScaledInstance(diceSize, diceSize, 0)));
            case 2 -> dice.setIcon(new ImageIcon(Images.dice2.display().getImage().getScaledInstance(diceSize, diceSize, 0)));
            case 3 -> dice.setIcon(new ImageIcon(Images.dice3.display().getImage().getScaledInstance(diceSize, diceSize, 0)));
            case 4 -> dice.setIcon(new ImageIcon(Images.dice4.display().getImage().getScaledInstance(diceSize, diceSize, 0)));
            case 5 -> dice.setIcon(new ImageIcon(Images.dice5.display().getImage().getScaledInstance(diceSize, diceSize, 0)));
            case 6 -> dice.setIcon(new ImageIcon(Images.dice6.display().getImage().getScaledInstance(diceSize, diceSize, 0)));
        }
    }

    public static void ChangePause(boolean pressed) {
        if (!pressed) {
            pause.setIcon(new ImageIcon(Images.pause.display().getImage().getScaledInstance(pauseButtonSize, pauseButtonSize, 0)));
        } else {
            pause.setIcon(new ImageIcon(Images.play.display().getImage().getScaledInstance(pauseButtonSize, pauseButtonSize, 0)));
        }
    }

    public static void EnemyRolled(String[] messageArray){
        canGo = true;

        ChangeDice(Integer.parseInt(messageArray[0]));

        enemyPlayerSquare = Integer.parseInt(messageArray[1]);

        gameWindow.repaint();
    }

    public static void EnemyPaused(boolean pressed){

        //canPause = true;
        //canPause = false;
        canGo = pressed;
        //ChangePause(pressed);
    }

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ChatLogger(AbstractLogger.ERROR_CONSOLE);
        AbstractLogger fileLogger = new ErrorConsoleLogger(AbstractLogger.FILE);
        AbstractLogger chatLogger = new FileLogger(AbstractLogger.CHAT);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(chatLogger);

        return errorLogger;
    }

}
