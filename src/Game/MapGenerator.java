package Game;

import Game.Squares.*;

public class MapGenerator {

    public static Square[][] Generate(){

        Square[][] map = {

                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RampSquare(1, 24) ,new RoadSquare(1, 23) ,new RoadSquare(1, 22) ,new RoadSquare(1, 21) ,new RoadSquare(1, 20) ,new RoadSquare(1, 19) ,new RoadSquare(1, 18) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RoadSquare(1, 25) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RoadSquare(1, 17) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new RampSquare(1, 1) ,new RoadSquare(1, 26) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RoadSquare(1, 16) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new RampSquare(1, 2) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RoadSquare(1, 15) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WallSquare(1, 3) ,new GarageSquare(1, 4) ,new WaterSquare(0, 0) ,new RoadSquare(1, 10) ,new RoadSquare(1, 11) ,new RoadSquare(1, 12) ,new RoadSquare(1, 13) ,new RoadSquare(1, 14) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new GasSquare(1, 5) ,new WaterSquare(0, 0) ,new RoadSquare(1, 9) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RampSquare(1, 6) ,new RampSquare(1, 7) ,new RoadSquare(1, 8) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new RoadSquare(10, 0) ,new WaterSquare(0, 0)},
                {new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0) ,new WaterSquare(0, 0)},

        };

        return map;
    }
}
