package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {

    public static boolean pressed = false;

    public static JTextField loginInputField;
    static JFrame loginFrame;
    static public JButton loginButton;
    static JLabel inputText;
    static JLabel carTypeLabel;
    static JComboBox inputCarType;

    public static void CreateWindow(){

        loginFrame = new JFrame("Dice Rally Connect");
        inputText = new JLabel("Input Your Name");
        carTypeLabel = new JLabel("Select Your Car");

        String[] carStrings = {"Race Car", "Rally Car", "Truck Car"};
        inputCarType = new JComboBox(carStrings);
        
        loginButton = new JButton("Play");

        loginInputField = new JTextField(16);
        JPanel loginWindow = new JPanel();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressed = true;
                loginFrame.setVisible(false);
                loginFrame.dispose();
            }
        });

        loginWindow.add(inputText);
        loginWindow.add(loginInputField);
        loginWindow.add(inputCarType);
        loginWindow.add(loginButton);

        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(loginWindow);
        loginFrame.setSize(300, 300);
        loginFrame.show();
    }
}
