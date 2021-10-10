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
    static JLabel sexTypeLabel;
    static JLabel hairTypeLabel;
    static JComboBox inputCarType;
    static JComboBox inputSexType;
    static JComboBox inputHairColor;

    public static void CreateWindow(){

        loginFrame = new JFrame("Dice Rally Connect");
        inputText = new JLabel("Input Your Name");
        carTypeLabel = new JLabel("Select Your Car");

        String[] carStrings = {"Race Car", "Rally Car", "Truck Car"};
        inputCarType = new JComboBox(carStrings);

        sexTypeLabel = new JLabel("Select Your Gender");

        String[] sexString = {"Male", "Female"};
        inputSexType = new JComboBox(sexString);

        hairTypeLabel = new JLabel("Select Your Hair Color");

        String[] hairColorString = {"Black", "Brown", "Red"};
        inputHairColor = new JComboBox(hairColorString);
        
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
        loginWindow.add(inputSexType);
        loginWindow.add(inputHairColor);
        loginWindow.add(loginButton);

        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(loginWindow);
        loginFrame.setSize(300, 300);
        loginFrame.show();
    }
}
