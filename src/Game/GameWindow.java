package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow {

    private static JFrame jFrame;
    private static JTextArea jTextArea;

    private static JButton sendBtn;
    public static JTextField sendInput;

    public static boolean pressed = false;

    public static void CreateWindow(){
        jFrame = new JFrame();

        jTextArea = new JTextArea();

        JPanel textPanel = new JPanel();
        textPanel.add(jTextArea);

        JPanel buttonPanel = new JPanel();

        sendBtn = new JButton("Send");
        buttonPanel.add(sendBtn);
        jFrame.add(textPanel, BorderLayout.WEST);
        jFrame.add(buttonPanel, BorderLayout.EAST);

        jFrame.setSize(600, 600);
        jFrame.setVisible(true);
    }

    public static void AddMessage(String message){
        if(jTextArea != null)
            jTextArea.append( message + "\n" );
    }


}
