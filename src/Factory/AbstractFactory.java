package Factory;

import ObjectsGame.Laser;
import ObjectsGame.Types.TypeColor;
import Math.Vector2D;

public interface AbstractFactory<T> {
    T create(String Object);
}
