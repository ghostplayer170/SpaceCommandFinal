package ObjectsGame;

import Graphics.Assets;
import Input.KeyBoard;
import ObjectsGame.Types.TypeColor;
import ObjectsGame.Types.TypeShip;
import Math.Vector2D;

import java.awt.image.BufferedImage;

/**
 * Esta clase es un objeto de los tipos de naves existentes.
 * Es la nave tipo ShipLight
 */

public class ShipLight extends PlayerShip {
    public ShipLight(Vector2D pos) {
        super(pos);
        speed = 6;
        playerType = TypeShip.ShipLight;
    }

    public void setColor(TypeColor typeColor){
        this.playerTypeColor = typeColor;
        this.image = setImage(typeColor);
    }

    protected BufferedImage setImage(TypeColor typeColor) {
        switch (typeColor){
            case RED:
                return Assets.lightCruiserRed;
            case BLUE:
                return Assets.lightCruiserBlue;
            case GREEN:
                return Assets.lightCruiserGreen;
            default:
                return Assets.lightCruiserOrange;
        }
    }

    @Override
    public void shoot() {
        if(KeyBoard.SHOOT && !fire.isRunning()){
            gameState.getMovingObjects().add(new Laser(getCenter(),TypeColor.BLUE, gameState));
            fire.run(fireRate);
        }
        fire.update();
    }
}
