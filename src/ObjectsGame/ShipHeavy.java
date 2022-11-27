package ObjectsGame;

import Graphics.Assets;
import Input.KeyBoard;
import ObjectsGame.Types.TypeColor;
import ObjectsGame.Types.TypeShip;
import Math.Vector2D;

import java.awt.image.BufferedImage;

/**
 * Esta clase es un objeto de los tipos de naves existentes.
 * Es la nave tipo HevayCruiser
 */

public class ShipHeavy extends PlayerShip {
    public ShipHeavy(Vector2D pos) {
        super(pos);
        speed = 2.5;
        playerType = TypeShip.ShipHeavy;
    }

    public void setColor(TypeColor typeColor){
        this.playerTypeColor = typeColor;
        this.image = setImage(typeColor);
    }

    protected BufferedImage setImage(TypeColor typeColor) {
        switch (typeColor){
            case RED:
                return Assets.heavyCruiserRed;
            case BLUE:
                return Assets.heavyCruiserBlue;
            case GREEN:
                return Assets.heavyCruiserGreen;
            default:
                return Assets.heavyCruiserOrange;
        }
    }

    @Override
    public void shoot() {
        if(KeyBoard.SHOOT && !fire.isRunning()){
            gameState.getMovingObjects().add(new Laser(getCenter(),TypeColor.GREEN,gameState));
            fire.run(fireRate);
        }
        fire.update();
    }
}
