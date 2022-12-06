package Functions;

import ObjectsGame.Types.TypeColor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
    public static JLabel imageToJLabel(BufferedImage im){
        BufferedImage img = im;
        Image dmg = img.getScaledInstance(80, 60, Image.SCALE_SMOOTH);
        return new JLabel(new ImageIcon(dmg));
    }
    public static JLabel imageToJLabelScore(BufferedImage im){
        BufferedImage img = im;
        Image dmg = img;
        return new JLabel(new ImageIcon(dmg));
    }
    public static ArrayList<String> loadPlayerData (String linea){
        StringBuilder aux = new StringBuilder();
        ArrayList<String> playerData = new ArrayList<>();
        int letter = 0;
        for(int i=0; i<linea.length(); ++i){
            if(!Character.toString(linea.charAt(letter)).matches(",")
                    && !Character.toString(linea.charAt(letter)).matches(";"))
            {
                aux.append(linea.charAt(letter));
                ++letter;
            }
            else
            {
                playerData.add(String.valueOf(aux));
                ++letter;
                aux.setLength(0);
            }
        }
        return playerData;
    }
}
