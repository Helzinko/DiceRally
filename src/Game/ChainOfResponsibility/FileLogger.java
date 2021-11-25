package Game.ChainOfResponsibility;

import Game.singleton.Logger;

public class FileLogger extends AbstractLogger{

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        Logger.getInstance().log(message);
    }
}
