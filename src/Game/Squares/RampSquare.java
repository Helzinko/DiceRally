package Game.Squares;

import Game.GameWindow;
import Game.Square;

import java.awt.*;

public class RampSquare implements Square {

    public int type = 0;
    public int number = 0;
    public int addition = 3;

    public int x;
    public int y;

    public RampSquare(int type, int number) {

        this.type = type;
        this.number = number;

    }

    @Override
    public void SetCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int[] GetCenterCoord() {
        int centerX = x + GameWindow.unitSize / 2;
        int centerY = y + GameWindow.unitSize / 2;

        int[] center = {centerX, centerY};

        return center;
    }

    @Override
    public int ReturnType() {
        return type;
    }

    @Override
    public int ReturnNumber() {
        return number;
    }

    @Override
    public int ReturnX() {
        return x;
    }

    @Override
    public int ReturnY() {
        return y;
    }

    @Override
    public void DrawSquare(Graphics2D g2d, int x, int y, int width, int height) {
        g2d.setColor(Color.yellow);
        g2d.fillRect(x, y, width, height);
    }

    @Override
    public int onTriggerEnter(int currentPosition) {
        return currentPosition + this.addition;
    }
}
