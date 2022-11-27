package Functions;

import ObjectsGame.Types.TypeColor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Functions {
    public static TypeColor toEnumColor(String color){
        if (color.equals(TypeColor.RED.toString())) {
            return TypeColor.RED;
        } else if (color.equals(TypeColor.BLUE.toString())) {
            return TypeColor.BLUE;
        } else if (color.equals(TypeColor.GREEN.toString())) {
            return TypeColor.GREEN;
        }
        return TypeColor.BLUE;
    }
    public static JLabel toImageJLabel(BufferedImage im){
        BufferedImage img = im;
        Image dmg = img.getScaledInstance(80, 60, Image.SCALE_SMOOTH);
        return new JLabel(new ImageIcon(dmg));
    }
    public static JLabel toImageJLabelScore(BufferedImage im){
        BufferedImage img = im;
        Image dmg = img;
        return new JLabel(new ImageIcon(dmg));
    }
}
