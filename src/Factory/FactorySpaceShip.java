package Factory;

import Math.Vector2D;
import ObjectsGame.ShipHeavy;
import ObjectsGame.ShipLight;
import ObjectsGame.ShipStar;

import static ObjectsGame.Constants.RESPAWN_Y;
import static ObjectsGame.Constants.RESPAWN_X;

public class FactorySpaceShip implements AbstractFactory<SpaceShip>  {
    @Override
    public SpaceShip create(String shipType) {
        if(shipType.equalsIgnoreCase("ShipLight")){
            return new ShipLight(new Vector2D(RESPAWN_X, RESPAWN_Y));
        }
        else if(shipType.equalsIgnoreCase("ShipHeavy")){
            return new ShipHeavy(new Vector2D(RESPAWN_X, RESPAWN_Y));
        }
        else if(shipType.equalsIgnoreCase("ShipStar")){
            return new ShipStar(new Vector2D(RESPAWN_X, RESPAWN_Y));
        }
        return null;
    }
}
