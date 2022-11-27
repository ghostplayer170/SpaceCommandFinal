package ObjectsGame.Types;

/**
 * Esta clase es para definir los tipos de naves existentes para el jugador.
 */

public enum TypeShip {
    ShipHeavy("Heavy Ship"),
    ShipLight("Light Ship"),
    ShipStar("Star Ship");

    private final String typeShip;

    TypeShip(String Ship) {
        this.typeShip = Ship;
    }

}
