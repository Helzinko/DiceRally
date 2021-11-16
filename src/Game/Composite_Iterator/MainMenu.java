package Game.Composite_Iterator;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public static boolean pressed = false;
    static JFrame loginFrame;
    public static String carTypeInput;
    public static String genderTypeInput;
    public static String colorTypeInput;
    public static JLabel nameInput;
    static LoginInputs inputs;

    public static void CreateWindow(){

        loginFrame = new JFrame("Dice Rally Connect");

        inputs = new LoginInputs();

        MenuComponent allMenus = new Menu("All menus", inputs);

        MenuComponent carMenu = new Menu("Select car type:", inputs);
        MenuComponent avatarMenu = new Menu("Create your avatar", inputs);

        allMenus.add(carMenu);
        allMenus.add(avatarMenu);

        carMenu.add(new MenuItem("Race Car", "carType", inputs));
        carMenu.add(new MenuItem("Rally Car", "carType", inputs));
        carMenu.add(new MenuItem("Truck Car", "carType", inputs));

        MenuComponent genderMenu = new Menu("Select gender:", inputs);
        MenuComponent colorMenu = new Menu("Select color:", inputs);

        genderMenu.add(new MenuItem("Male", "genderType", inputs));
        genderMenu.add(new MenuItem("Female", "genderType", inputs));

        colorMenu.add(new MenuItem("Black", "colorType", inputs));
        colorMenu.add(new MenuItem("Brown", "colorType", inputs));
        colorMenu.add(new MenuItem("Red", "colorType", inputs));

        avatarMenu.add(genderMenu);
        avatarMenu.add(colorMenu);

        JPanel menuPanel = new JPanel(new GridLayout(0,1, 5,5));
        menuPanel.setName("main menu");
        GridBagConstraints c = new GridBagConstraints();

        nameInput = new JLabel("Enter your name:");

        menuPanel.add(nameInput);
        menuPanel.add(new JTextField(16));

        Holder holder = new Holder(allMenus);
        holder.displayMenu(menuPanel, c);

        JPanel startPanel = new JPanel();
        JButton startButton = new JButton("Start !");
        startButton.setMargin(new Insets(0,0,0,0));

        startButton.addActionListener(e -> {
            pressed = true;
            loginFrame.setVisible(false);
            loginFrame.dispose();

            carTypeInput = carMenu.getCarType();
            genderTypeInput = genderMenu.getGenderType();
            colorTypeInput = colorMenu.getColorType();

            System.out.println("Car type: " + carTypeInput + " Gender type: " + genderMenu.getGenderType() + " Color type: " + colorMenu.getColorType());
        });

        startPanel.add(startButton);
        menuPanel.add(startPanel);

        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(menuPanel);
        loginFrame.setSize(400, 600);
        loginFrame.setLocation(400,100);
    }
}
