package Game;

import Game.Builder_Prototype.Car;

import java.awt.*;

public interface Square {

    public void SetCoord(int x, int y);

    public int[] GetCenterCoord();

    public int ReturnType();

    public int ReturnNumber();

    public int ReturnX();

    public int ReturnY();

    public void DrawSquare(Graphics2D g2d, int x, int y, int width, int height);

    public double[] onTriggerEnter(int currentPosition, Car car, int rolled);

}
