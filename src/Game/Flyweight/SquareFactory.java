package Game.Flyweight;

import Game.MapGenerator;
import Game.Square;
import Game.Squares.WaterSquare;

import java.util.HashMap;

public class SquareFactory {

    private static final HashMap squareMap = new HashMap();

    public static Square getWaterSquare(MapGenerator.Squares squareType) {

        Square square = (Square)squareMap.get(squareType);

        if(square == null) {

            if(squareType == MapGenerator.Squares.WATER){
                square = new WaterSquare(0, 0);
                squareMap.put(squareType, square);
                System.out.println("Creating new square : " + squareType);
            }

        }

        return square;
    }

}
