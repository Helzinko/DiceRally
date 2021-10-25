package Game;

import Game.PlayerProfile.Person;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ProfilePanel extends Panel{

    private static BufferedImage profilePic;

    private static int picSize = 250;

    private static int panelWidth;
    private static int panelHeight;
    double fuel;
    double health;

    public ProfilePanel(int width, int height, boolean needBorder, double fuel, double health) {
        super(width, height, needBorder);
        this.fuel = fuel;
        this.health = health;
    }

    public Panel PaintProfilePanel(Panel panel, Person person) throws IOException {
        panelWidth = panel.pWidth;
        panelHeight = panel.pHeight;
        profilePic = person.getAvatar();

        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(profilePic, panelWidth/2-picSize/2, 0, picSize, picSize, this);
        g.setColor(Color.black);
        String name = Client.playerName;
        g.drawString(name,  panelWidth / 2 ,300);
        g.drawString("Fuel: " + fuel,  panelWidth / 2 ,315);
        g.drawString("Health: " + health,  panelWidth / 2 ,330);
    }

    public void updadeInfo(double fuelLeft, double healthLeft){
        if(fuelLeft < 0){
            this.fuel = 0;
        }
        else {
            this.fuel = fuelLeft;
        }
        if(healthLeft < 0){
            this.health = 0;
        }
        else {
            this.health = healthLeft;
        }
        repaint();
    }
}
