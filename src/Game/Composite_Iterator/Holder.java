package Game.Composite_Iterator;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class Holder {
    MenuComponent allMenus;

    public Holder(MenuComponent allMenus){
        this.allMenus = allMenus;
    }

    public void displayMenu(JPanel menuPanel, GridBagConstraints c) {
        Iterator<MenuComponent> iterator = new CompositeIterator(allMenus.createIterator());
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            menuComponent.displayMenu(menuPanel, c);
        }
    }
}
