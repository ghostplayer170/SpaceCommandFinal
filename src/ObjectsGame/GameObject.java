package ObjectsGame;

import Gui.GamePanel;
import Math.Vector2D;
import ObjectsGame.Types.TypeObject;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Es una clase abstracta para cada objeto que pertenece al espacio.
 */
public abstract class GameObject {

    protected BufferedImage image;
    protected Vector2D position;
    protected JLabel imgLabel;

    public GameObject(Vector2D pos){
        this.position = pos;
        this.imgLabel = null;
    }

    public abstract void update();

    public abstract void paintComponent(GamePanel g);

    public Vector2D getPosition() {
        return position;
    }

    public abstract TypeObject getType();

}
