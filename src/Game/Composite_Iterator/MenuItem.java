package Game.Composite_Iterator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
        JPanel newPanel = new JPanel();

        if(Objects.equals(inputType, "carType")){
            newPanel.setName("carType");
        } else if(Objects.equals(inputType, "genderType")){
            newPanel.setName("genderType");
        } else if(Objects.equals(inputType, "colorType")){
            newPanel.setName("colorType");
        }

        JButton button = new JButton(getName());
        newPanel.add(button);
        menuPanel.add(newPanel);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(inputType, "carType")) {
            setCarType(getName());
            var button = (JButton)e.getSource();
            button.setBackground(Color.gray);

            Arrays.stream(((JButton) e.getSource()).getParent().getParent().getComponents())
                    .filter(c -> c.getClass() == JPanel.class).filter(p -> Objects.equals(p.getName(), "carType"))
                    .forEach(p -> Arrays.stream(((JPanel) p).getComponents()).filter(b -> b != button).forEach(b -> b.setBackground(null)));
        }
        else if(Objects.equals(inputType, "genderType")) {
            setGenderType(getName());
            var button = (JButton) e.getSource();
            setCarType(getName());
            button.setBackground(Color.pink);

            Arrays.stream(((JButton) e.getSource()).getParent().getParent().getComponents())
                    .filter(c -> c.getClass() == JPanel.class).filter(p -> Objects.equals(p.getName(), "genderType"))
                    .forEach(p -> Arrays.stream(((JPanel) p).getComponents()).filter(b -> b != button).forEach(b -> b.setBackground(null)));
        }
        else if(Objects.equals(inputType, "colorType")){
            setColorType(getName());
            var button = (JButton) e.getSource();
            setCarType(getName());
            button.setBackground(Color.ORANGE);

            Arrays.stream(((JButton) e.getSource()).getParent().getParent().getComponents())
                    .filter(c -> c.getClass() == JPanel.class).filter(p -> Objects.equals(p.getName(), "colorType"))
                    .forEach(p -> Arrays.stream(((JPanel) p).getComponents()).filter(b -> b != button).forEach(b -> b.setBackground(null)));
        }
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }
}
