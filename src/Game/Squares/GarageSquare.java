package Game.Squares;

import Game.GameWindow;
import Game.Proxy.ProxyImage;
import Game.Square;
import Game.Strategy_Template.Fix;
import Game.Strategy_Template.SquareAlgorithm;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GarageSquare implements Square {

    public int type = 0;
    public int number = 0;

    public int x;
    public int y;

    private Game.Proxy.Image squareImage;

    public GarageSquare(int type, int number) {

        this.type = type;
        this.number = number;

        squareImage = new ProxyImage("src/images/Default/garage_01.png");
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
    public void DrawSquare(Graphics2D g2d, int x, int y, int width, int height) throws IOException {
        g2d.drawImage(squareImage.display().getImage(), x, y, width, height, null);
    }

    @Override
    public SquareAlgorithm getSquareAlgorithm() {

        return new Fix();
    }
}
