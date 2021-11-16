package Game.Composite_Iterator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {
    Iterator<MenuComponent> iterator = null;
    List<MenuComponent> subMenus = new ArrayList<>();

    public Menu(String name, LoginInputs inputs) {
        super(name, inputs);
    }

    @Override
    public void add(MenuComponent menuComponent) {
        this.subMenus.add(menuComponent);
    }

    @Override
    public void displayMenu(JPanel menuPanel, GridBagConstraints c) {
        JPanel newPanel = new JPanel();
        newPanel.add(new JLabel(getName()));
        newPanel.setName(getName());
        menuPanel.add(newPanel);
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
         return subMenus.iterator();
    }
}
