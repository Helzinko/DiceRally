package Game;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    public static int Roll(){
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

}
