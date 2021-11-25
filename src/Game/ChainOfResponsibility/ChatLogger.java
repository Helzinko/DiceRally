package Game.ChainOfResponsibility;

import Game.Chat;

public class ChatLogger extends AbstractLogger {
    public ChatLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
       Chat.AddMessage("ChatLogging: " + message);
    }
}
