package Game;

import java.awt.*;

public class Square {

    public int type;
    public int number;

    public int x;
    public int y;

    public Square(int type, int number){

        this.type = type;
        this.number = number;

    }

    public void SetCoord(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int[] GetCenterCoord(){

        int centerX = x + GameWindow.unitSize/2;
        int centerY = y + GameWindow.unitSize/2;

        int[] center = {centerX, centerY};

        return center;
    }

}
