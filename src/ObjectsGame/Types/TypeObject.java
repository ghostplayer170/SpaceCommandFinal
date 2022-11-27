package ObjectsGame.Types;

public enum TypeObject {
    Laser("Laser"),
    PlayerShip("PlayerShip"),
    Asteroid("Asteroid");

    private final String typeObject;

    TypeObject(String object) {
        this.typeObject = object;
    }
}
