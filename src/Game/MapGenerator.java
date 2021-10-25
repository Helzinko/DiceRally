package Game;

import Game.Squares.*;

public class MapGenerator {

    public static Square[][] Generate(){

        Square[][] map = {

                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(11, 0)},
                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RoadSquare(1, 24, 3) ,new GasSquare(1, 23) ,new RoadSquare(1, 22, 1) ,new RampSquare(1, 21, 1) ,new RoadSquare(1, 20, 1) ,new RoadSquare(1, 19, 1) ,new RoadSquare(1, 18, 4) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RoadSquare(1, 25, 2) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RoadSquare(1, 17, 2) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new RoadSquare(1, 1, 3) ,new RoadSquare(1, 26, 6) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WallSquare(1, 16) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new RoadSquare(1, 2, 2) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RoadSquare(1, 15, 2) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WallSquare(1, 3) ,new WaterSquare(1, 0) ,new WaterSquare(0, 0) ,new RoadSquare(1, 10, 3) ,new RoadSquare(1, 11, 1) ,new GarageSquare(1, 12) ,new RoadSquare(1, 13, 1) ,new RoadSquare(1, 14, 6) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new RoadSquare(1, 4, 5) ,new RoadSquare(1, 5, 4) ,new WaterSquare(0, 0) ,new RoadSquare(1, 9, 2) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RoadSquare(1, 6, 5) ,new RampSquare(1, 7, 2) ,new RoadSquare(1, 8, 6) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(10, 0) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0)},

        };

        return map;
    }
}
