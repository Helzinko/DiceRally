package Game;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends Panel {

    public static GameWindow gameWindow;

    public GameWindow (int width, int height, boolean needBorder) {
        super(width, height, needBorder);
    }

    public static GameWindow ShowWindow(){

        gameWindow = new GameWindow(Frame.mainFrameWidth / 4 * 2, Frame.mainFrameHeight / 3 * 2, true);
        return gameWindow;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.cyan);
        g.fillRect(0, 0, gameWindow.pWidth, gameWindow.pHeight);
        g.setColor(Color.red);
        g.fillRect(10, 10, 10, 10);
    }


}
