package Game;

public class MapGenerator {

    public static Square[][] Generate(){

        Square[][] map = {

                {new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0)},
                {new Square(0, 0) ,new Square(0, 0) ,new Square(1, 24) ,new Square(1, 23) ,new Square(1, 22) ,new Square(1, 21) ,new Square(1, 20) ,new Square(1, 19) ,new Square(1, 18) ,new Square(0, 0)},
                {new Square(0, 0) ,new Square(0, 0) ,new Square(1, 25) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(1, 17) ,new Square(0, 0)},
                {new Square(0, 0) ,new Square(1, 1) ,new Square(1, 26) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(1, 16) ,new Square(0, 0)},
                {new Square(0, 0) ,new Square(1, 2) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(1, 15) ,new Square(0, 0)},
                {new Square(0, 0) ,new Square(1, 3) ,new Square(1, 4) ,new Square(0, 0) ,new Square(1, 10) ,new Square(1, 11) ,new Square(1, 12) ,new Square(1, 13) ,new Square(1, 14) ,new Square(0, 0)},
                {new Square(0, 0) ,new Square(0, 0) ,new Square(1, 5) ,new Square(0, 0) ,new Square(1, 9) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0)},
                {new Square(0, 0) ,new Square(0, 0) ,new Square(1, 6) ,new Square(1, 7) ,new Square(1, 8) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0)},
                {new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(10, 0) ,new Square(0, 0)},
                {new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0) ,new Square(0, 0)},

        };

        return map;
    }
}
