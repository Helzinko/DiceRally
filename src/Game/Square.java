package Game;

import Game.Strategy.SquareAlgorithm;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Square {

    void SetCoord(int x, int y);

    int[] GetCenterCoord();

    int ReturnType();

    int ReturnNumber();

    int ReturnX();

    int ReturnY();

    void DrawSquare(Graphics2D g2d, int x, int y, int width, int height) throws IOException;

    SquareAlgorithm getSquareAlgorithm();

}
