package Game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

class Panel extends JPanel {
    int pWidth, pHeight;

    public Panel(int width, int height, boolean needBorder) {
        pWidth = width;
        pHeight = height;
        if(needBorder)
            setBorder(new LineBorder(Color.BLACK));
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }
}