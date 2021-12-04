package Game.Squares;

import Game.GameWindow;
import Game.Proxy.ProxyImage;
import Game.Square;
import Game.Strategy_Template.Neutral;
import Game.Strategy_Template.SquareAlgorithm;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import Game.Proxy.Image;
import Game.Proxy.ProxyImage;

public class WaterSquare implements Square {

    public int type = 0;
    public int number = 0;

    public int x;
    public int y;

    private Image waterImage;

    public WaterSquare(int type, int number){

        this.type = type;
        this.number = number;

        waterImage = new ProxyImage("src/images/Default/roadTexture_25.png");
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
    public void DrawSquare(Graphics2D g2d, int x, int y, int width, int height) throws IOException {
        g2d.drawImage(waterImage.display().getImage(), x, y, width, height, null);
    }

    @Override
    public SquareAlgorithm getSquareAlgorithm() {

        return new Neutral();
    }
}
