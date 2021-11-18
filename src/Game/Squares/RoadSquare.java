package Game.Squares;

import Game.GameWindow;
import Game.Square;
import Game.Strategy_Template.Drive;
import Game.Strategy_Template.SquareAlgorithm;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RoadSquare implements Square {

    public int type = 0;
    public int number = 0;

    public int x;
    public int y;

    private int angle = 0;

    public RoadSquare(int type, int number, int angle){

        this.type = type;
        this.number = number;
        this.angle = angle;
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
        switch (angle){
            case 1:
                g2d.drawImage(ImageIO.read(new File("src/images/Default/roadTexture_13.png")), x, y, width, height, null);
                break;
            case 2:
                g2d.drawImage(ImageIO.read(new File("src/images/Default/roadTexture_01.png")), x, y, width, height, null);
                break;
            case 3:
                g2d.drawImage(ImageIO.read(new File("src/images/Default/roadTexture_02.png")), x, y, width, height, null);
                break;
            case 4:
                g2d.drawImage(ImageIO.read(new File("src/images/Default/roadTexture_03.png")), x, y, width, height, null);
                break;
            case 5:
                g2d.drawImage(ImageIO.read(new File("src/images/Default/roadTexture_14.png")), x, y, width, height, null);
                break;
            case 6:
                g2d.drawImage(ImageIO.read(new File("src/images/Default/roadTexture_15.png")), x, y, width, height, null);
                break;
        }


    }

    @Override
    public SquareAlgorithm getSquareAlgorithm() {

        return new Drive();
    }

}
