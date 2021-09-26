package Game;

import javafx.scene.layout.Pane;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat {

    private static JButton sendBtn;
    public static JTextField sendField;

    public static boolean sendPressed = false;

    private static JTextArea jTextArea;

    public static Panel ChatPanel(Panel panel) {

        sendField = new JTextField(20);
        jTextArea = new JTextArea();
        sendBtn = new JButton("Send");

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendPressed = true;
            }
        });

        JPanel textPanel = new Panel(Frame.mainFrameWidth, (Frame.mainFrameHeight - GameWindow.windowSize) / 4 * 3, false);
        JPanel sendPanel = new Panel(Frame.mainFrameWidth, (Frame.mainFrameHeight - GameWindow.windowSize) / 4, false);

        textPanel.add(jTextArea);
        sendPanel.add(sendField);
        sendPanel.add(sendBtn);

        panel.add(textPanel,  BorderLayout.NORTH);
        panel.add(sendPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static void AddMessage(String message) {
        if (jTextArea != null)
            jTextArea.append(message + "\n");
    }

}
