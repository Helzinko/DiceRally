package Game.PlayerProfile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WomanRed implements Person{
    @Override
    public BufferedImage getAvatar() {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File("src/images/womanRed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }
}
