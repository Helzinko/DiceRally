package Game;

import Game.PlayerProfile.Person;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EnemyPanel extends Panel{

    private static BufferedImage profilePic;

    private static int picSize = 250;

    private static int panelWidth;
    private static int panelHeight;

    private static String name;

    public EnemyPanel(int width, int height, boolean needBorder) {
        super(width, height, needBorder);
    }

    public static Panel PaintProfilePanel(Panel panel, Person person, String enemyName) throws IOException {


        System.out.println("Help me 2");
        panelWidth = panel.pWidth;
        panelHeight = panel.pHeight;

        EnemyPanel profilePanel = new EnemyPanel(panelWidth, panelHeight, true);

        profilePic = person.getAvatar();

        name = enemyName;

        return profilePanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(profilePic, panelWidth/2-picSize/2, 0, picSize, picSize, this);

        g.setColor(Color.black);

        g.drawString(name,  panelWidth / 2 ,300);
    }
}
