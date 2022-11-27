package ObjectsGame.Types;

/**
 * Esta clase es para definir los tipos de colores naves existentes para el jugador.
 */

public enum TypeColor {
    BLUE("Blue"),
    RED("Red"),
    GREEN("Green");

    private final String typeColor;

    TypeColor(String color) {this.typeColor = color;}

}
