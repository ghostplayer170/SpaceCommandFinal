package Gui;

import javax.swing.*;
import java.awt.*;
//RECUPERADO DE https://stackoverflow.com/questions/2966334/how-do-i-set-the-colour-of-a-label-coloured-text-in-java
public class Panels extends JPanel {

    private Image background;
    protected String spaceImage = "gfx/Images/PNG/Space/space.png";

    public void paintComponent(Graphics g) {

        int width = this.getSize().width;
        int height = this.getSize().height;

        if (this.background != null) {
            g.drawImage(this.background, 0, 0, width, height, null);
        }

        super.paintComponent(g);

    }

    public void setBackground(String imagePath) {
        this.setOpaque(false);
        this.background = new ImageIcon(imagePath).getImage();
        repaint();
    }

}
