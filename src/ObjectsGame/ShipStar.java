package ObjectsGame;

import Graphics.Assets;
import Input.KeyBoard;
import ObjectsGame.Types.TypeColor;
import ObjectsGame.Types.TypeShip;
import Math.Vector2D;

import java.awt.image.BufferedImage;

/**
 * Esta clase es un objeto de los tipos de naves existentes.
 * Es la nave tipo ShipStar
 */

public class ShipStar extends PlayerShip{
    public ShipStar(Vector2D pos) {
        super(pos);
        speed = 4.5;
        playerType = TypeShip.ShipStar;
    }

    public void setColor(TypeColor typeColor){
        this.playerTypeColor = typeColor;
        this.image = setImage(typeColor);
    }

    protected BufferedImage setImage(TypeColor typeColor) {
        switch (typeColor){
            case RED:
                return Assets.starCruiserRed;
            case BLUE:
                return Assets.starCruiserBlue;
            case GREEN:
                return Assets.starCruiserGreen;
            default:
                return Assets.starCruiserOrange;
        }
    }

    @Override
    public void shoot() {
        if(KeyBoard.SHOOT && !fire.isRunning()){
            gameState.getMovingObjects().add(new Laser(getCenter(),TypeColor.RED, gameState));
            fire.run(fireRate);
        }
        fire.update();
    }

}
