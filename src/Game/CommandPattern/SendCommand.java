/**
 * @(#) SendCommand.java
 */

package Game.CommandPattern;

import Game.Builder_Prototype.Car;
import Game.Chat;
import Game.DateFormat;
import Game.GameWindow;
import Game.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendCommand extends ICommand
{

    public SendCommand(Message msg) {
        super(msg);
    }

    @Override
    public int execute() {
        System.out.println(this.message.player.GetName() + " says: " + this.message.text);
        Chat.AddMessage(DateFormat.CurrentTime() + this.message.player.GetName() + " says: " + this.message.text);
        return 0;
    }

    @Override
    public void undo() {

    }
}
