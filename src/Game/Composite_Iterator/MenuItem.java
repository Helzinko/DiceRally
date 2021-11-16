package Game.Composite_Iterator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Objects;

public class MenuItem extends MenuComponent implements ActionListener {

    private final String inputType;

    public MenuItem(String name, String inputType, LoginInputs inputs) {
        super(name, inputs);
        this.inputType = inputType;
    }

    @Override
    public void displayMenu(JPanel menuPanel, GridBagConstraints c) {
        JButton button = new JButton(getName());
        menuPanel.add(button);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(inputType, "carType"))
            setCarType(getName());
        else if(Objects.equals(inputType, "genderType"))
            setGenderType(getName());
        else if(Objects.equals(inputType, "colorType"))
            setColorType(getName());
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }
}
