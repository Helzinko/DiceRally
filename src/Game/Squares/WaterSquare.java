package Game.Squares;

import Game.Builder_Prototype.Car;
import Game.GameWindow;
import Game.Square;
import Game.Strategy.DriveBridge;
import Game.Strategy.Neutral;
import Game.Strategy.SquareAlgorithm;

import java.awt.*;

public class WaterSquare implements Square {

    public int type = 0;
    public int number = 0;

    public int x;
    public int y;

    public WaterSquare(int type, int number){

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
        int centerX = x + GameWindow.unitSize/2;
        int centerY = y + GameWindow.unitSize/2;

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
        g2d.setColor(Color.cyan);
        g2d.fillRect(x, y, width, height);
    }

    @Override
    public SquareAlgorithm getSquareAlgorithm() {

        return new Neutral();
    }
}
