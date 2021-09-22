package Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow {

    private static JFrame jFrame;
    private static JPanel chatPanel;
    private static JPanel boardPanel;

    private static JTextArea jTextArea;

    public static void PaintWindow() {
        jFrame = new JFrame();

        chatPanel = new JPanel();
        boardPanel = new JPanel();

        boardPanel.setBackground(Color.gray);
        jFrame.setLayout(new GridLayout(1, 2));
        ChatPanel();
        BoardPanel();
        jFrame.add(chatPanel);
        jFrame.add(boardPanel);

        jFrame.setSize(1920, 1080);
        jFrame.setVisible(true);
    }

    private static JButton sendBtn;
    public static JTextField sendField;

    public static boolean sendPressed = false;

    public static void ChatPanel() {
        chatPanel.setLayout(new GridLayout(2, 1));

        sendField = new JTextField(20);
        jTextArea = new JTextArea();
        sendBtn = new JButton("Send");

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendPressed = true;
            }
        });

        JPanel textPanel = new JPanel();
        JPanel sendPanel = new JPanel();

        Border blackline = BorderFactory.createLineBorder(Color.black);
        textPanel.setBorder(blackline);

        textPanel.add(jTextArea);
        sendPanel.add(sendField);
        sendPanel.add(sendBtn);

        chatPanel.add(sendPanel);
        chatPanel.add(textPanel);
    }

    private static JPanel[] squarePanels;
    private static JButton diceButton;

    public static boolean rollPressed = false;

    public static void BoardPanel() {
        boardPanel.setLayout(new GridLayout(3, 3));
        squarePanels = new JPanel[9];
        for (int i = 0; i < 9; i++) {
          squarePanels[i] = new JPanel();
          squarePanels[i].setBorder(BorderFactory.createLineBorder(Color.black));
          boardPanel.add(squarePanels[i]);
        }
        diceButton = new JButton("ROLL");

        diceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollPressed = true;
            }
        });

        diceButton.setPreferredSize(new Dimension(320, 360));
        squarePanels[4].add(diceButton);
    }

    public static void AddMessage(String message) {
        if (jTextArea != null)
            jTextArea.append(message + "\n");
    }


}
