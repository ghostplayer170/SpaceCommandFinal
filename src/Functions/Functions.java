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
        Image dmg = im.getScaledInstance(80, 60, Image.SCALE_SMOOTH);
        return new JLabel(new ImageIcon(dmg));
    }
    public static JLabel imageToJLabelNoScale(BufferedImage im){
        return new JLabel(new ImageIcon(im));
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
    public static ArrayList<ArrayList<String>> topFivePlayers (ArrayList<ArrayList<String>> playersDataHistory){
        ArrayList<ArrayList<String>> topFive = new ArrayList<>();
        int aux = playersDataHistory.size()-1;
        for(int i=0; i<5; ++i){
            topFive.add(playersDataHistory.get(aux));
            --aux;
        }
        return topFive;
    }
    public static ArrayList<String> playerDataFromHistory (ArrayList<ArrayList<String>> playersDataHistory){
        return playersDataHistory.get(playersDataHistory.size()-1);
    }
}
