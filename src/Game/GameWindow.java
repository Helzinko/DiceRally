package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends Panel {

    public static GameWindow gameWindow;

    public static int windowSize = 800;
    public static int unitSize = 80;

    public static JButton dice;

    public static int diceSize = 100;

    public static int currentPlayerSquare = 1;

    public GameWindow (int width, int height, boolean needBorder) {
        super(width, height, needBorder);
    }

    public static GameWindow ShowWindow(){

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
                int rolledNumber = Dice.Roll();

                switch (rolledNumber){
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

                currentPlayerSquare += rolledNumber;

                if(currentPlayerSquare > 26){
                    currentPlayerSquare = currentPlayerSquare - 26;
                }

                gameWindow.repaint();
            }
        });

        return gameWindow;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // background;
        g2d.setColor(Color.cyan);
        g2d.fillRect(0, 0, gameWindow.pWidth, gameWindow.pHeight);
        //  ---------------------

        // map drawing ------------------------------
        Square[][] map = MapGenerator.Generate();

        for ( int row = 0; row < 10; row++ ){
            for ( int column = 0; column < 10; column++ ){

                map[row][column].SetCoord(column*unitSize, row*unitSize);

                if(map[row][column].type == 1){
                    if(map[row][column].number == 1){
                        g2d.setColor(Color.RED);
                        g2d.fillRect(column*unitSize, row*unitSize, unitSize, unitSize);
                    }else{
                        g2d.setColor(Color.ORANGE);
                        g2d.fillRect(column*unitSize, row*unitSize, unitSize, unitSize);
                    }

                    g2d.setColor(Color.black);
                    g2d.drawString(String.valueOf(map[row][column].number), map[row][column].GetCenterCoord()[0], map[row][column].GetCenterCoord()[1]);

                    if(map[row][column].number == currentPlayerSquare){
                        drawPlayer(g2d, map[row][column].x, map[row][column].y);
                    }
                }

                if(map[row][column].type == 10){
                    dice.setBounds(map[row][column].x, map[row][column].y, unitSize, unitSize);
                }
            }
        }

    }

    public void drawPlayer(Graphics2D g2d, int x, int y){

        g2d.setColor(Color.BLUE);
        g2d.fillOval(x, y, 30, 30);

    }

}
