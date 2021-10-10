package Game;

import Game.PlayerProfile.AbstractFactory;
import Game.PlayerProfile.FactoryProducer;
import Game.PlayerProfile.Person;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProfilePanel extends Panel{

    private static BufferedImage profilePic;
    private static int picSize = 250;


    private static int panelWidth;
    private static int panelHeight;

    public ProfilePanel(int width, int height, boolean needBorder) {
        super(width, height, needBorder);
    }

    public static Panel PaintProfilePanel(Panel panel) throws IOException {

        panelWidth = panel.pWidth;
        panelHeight = panel.pHeight;

        ProfilePanel profilePanel = new ProfilePanel(panelWidth, panelHeight, false);

        boolean isMale = true;

        if(LoginWindow.inputSexType.getSelectedItem().toString().equals("Female")){
            isMale = false;
        }

        String hairColor = LoginWindow.inputHairColor.getSelectedItem().toString();

        AbstractFactory shapeFactory = FactoryProducer.getFactory(isMale);
        Person person1 = shapeFactory.getPerson(hairColor);

        profilePic = person1.getAvatar();

        return profilePanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(profilePic, panelWidth/2-picSize/2, 0, picSize, picSize, this);

        g.setColor(Color.black);

        String name = Client.playerName;

        g.drawString(name,  panelWidth / 2 ,300);
    }
}
