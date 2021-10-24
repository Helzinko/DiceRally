package Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Chat {

    public static Chat instance;

    public Chat(){
        instance = this;
    }

    private static JButton sendBtn;
    public static JTextField sendField;

    private static JTextArea jTextArea;
    private static JScrollPane scrollPanel;

    private List<Observer> observers = new ArrayList<Observer>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public static Panel ChatPanel(Panel panel) {

        sendField = new JTextField(20);
        jTextArea = new JTextArea(10, 50);
        jTextArea.setEditable(false);
        sendBtn = new JButton("Send");

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instance.setState(sendField.getText());
            }
        });

        JPanel textPanel = new Panel(Frame.mainFrameWidth, (Frame.mainFrameHeight - GameWindow.windowSize) / 4 * 3, false);
        JPanel sendPanel = new Panel(Frame.mainFrameWidth, (Frame.mainFrameHeight - GameWindow.windowSize) / 4, false);


        textPanel.add(jTextArea);
        scrollPanel = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textPanel.add(scrollPanel);
        sendPanel.add(sendField);
        sendPanel.add(sendBtn);

        panel.add(textPanel,  BorderLayout.NORTH);
        panel.add(sendPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static void AddMessage(String message) {
        if (jTextArea != null){
            jTextArea.append(message + "\n");
            jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
        }
    }

}
