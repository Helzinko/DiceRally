package Game.Proxy;

import javax.swing.*;

public class RealImage implements Image {

    private String fileName;
    private ImageIcon imgIcon;

    public RealImage(String fileName){
        this.fileName = fileName;
        imgIcon = loadFromDisk(fileName);
    }

    @Override
    public ImageIcon display() {
        return imgIcon;
    }

    private ImageIcon loadFromDisk(String fileName){
        return new ImageIcon(fileName);
    }
}
