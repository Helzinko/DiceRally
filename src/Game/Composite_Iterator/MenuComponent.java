package Game.Composite_Iterator;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public abstract class MenuComponent {

    private final String name;
    private final LoginInputs inputs;


    public MenuComponent(String name, LoginInputs inputs) {

        this.name = name;
        this.inputs = inputs;
    }

    public String getName() {
        return name;
    }

    public String getCarType() {
        return this.inputs.getCarType();
    }

    public void setCarType(String carType){
        this.inputs.setCarType(carType);
    }

    public String getGenderType(){
        return this.inputs.getGenderType();
    }

    public void setGenderType(String genderType){
        this.inputs.setGenderType(genderType);
    }

    public String getColorType(){
        return this.inputs.getColorType();
    }

    public void setColorType(String colorType){
        this.inputs.setColorType(colorType);
    }

    public void add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public abstract void displayMenu(JPanel menuPanel, GridBagConstraints c);

    public abstract Iterator<MenuComponent> createIterator();
}
