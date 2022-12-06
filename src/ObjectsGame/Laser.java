package ObjectsGame;

import Gui.GamePanel;
import Functions.Functions;
import Graphics.Assets;
import Math.Vector2D;
import ObjectsGame.Types.TypeColor;
import ObjectsGame.Types.TypeObject;
import States.GameState;
import java.awt.image.BufferedImage;

public class Laser extends MovingObject{

    private final ObjectsGame.Types.TypeColor TypeColor;
    private int width,height,speed;

    public Laser(Vector2D pos, TypeColor clr, GameState gs) {
        super(pos);
        typeObject = TypeObject.Laser;
        TypeColor = clr;
        image = setImage(clr);
        gameState = gs;
        setProperties(clr);
    }

    public BufferedImage setImage(TypeColor typeColor){
        switch (typeColor){
            case BLUE -> {
                return Assets.blueLaser;
            }
            case RED -> {
                return Assets.redLaser;
            }
            case GREEN -> {
                return Assets.greenLaser;
            }
            default -> {
                return Assets.blueLaser;
            }
        }
    }

    @Override
    public void update() {
        position.setY(position.getY()-speed);
        if(position.getY()<0)
            destroy();
        collision();
    }

    private void setProperties(TypeColor color){
        switch (color){
            case BLUE -> {
                this.width = 5;
                this.height = 30;
                this.speed = 25;
            }
            case RED -> {
                this.width = 10;
                this.height = 40;
                this.speed = 15;
            }
            case GREEN -> {
                this.width = 15;
                this.height = 50;
                this.speed = 7;
            }
            default -> {
                this.width = 5;
                this.height = 50;
                this.speed = 15;
            }
        }
    }

    @Override
    public void paintComponent(GamePanel g) {
        imgLabel = Functions.imageToJLabel(image);
        imgLabel.setBounds((int)position.getX(),(int)position.getY(),width,height);
        g.add(imgLabel);
    }

    public Vector2D getCenter(){
        return new Vector2D(position.getX()+getWidth()/2, position.getY()+getWidth()/2);
    }
}
