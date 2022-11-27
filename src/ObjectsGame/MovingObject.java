package ObjectsGame;

import ObjectsGame.Types.TypeObject;
import States.GameState;
import Math.Vector2D;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Es una clase abstracta para cada objeto que pertenece al espacio y se encuentra en movimiento.
 */
public abstract class MovingObject extends GameObject {
    protected boolean dead;
    protected TypeObject typeObject;
    protected GameState gameState;
    public MovingObject(Vector2D pos){
        super(pos);
        this.dead = false;
    }
    public BufferedImage getBufferedImagePlayer(){return image;}
    public Vector2D getCenter(){
        return new Vector2D(position.getX()+getWidth()/2, position.getY()+getHeight()/2);
    }
    public TypeObject getType(){return typeObject;}
    protected void collision(){
        ArrayList<MovingObject> movingObjects = gameState.getMovingObjects();
        for(int i=0;i<movingObjects.size();++i){
            MovingObject m = movingObjects.get(i);
            if(m.equals(this))
                continue;
            double distance = m.getCenter().subtract(getCenter()).getMagnitude();
            if(distance < m.getWidth()/2 + m.getWidth()/2 && movingObjects.contains(this)){
                objectCollision(m, this);
            }
        }
    }

    private void objectCollision(MovingObject a, MovingObject b){
        if(!(a instanceof Asteroid && b instanceof Asteroid)
                && !((a.getType().equals(TypeObject.PlayerShip) && b instanceof Laser)
                    || b.getType().equals(TypeObject.PlayerShip) && a instanceof Laser)){
            a.destroy();
            b.destroy();
        }
    }

    protected void destroy(){
        gameState.getMovingObjects().remove(this);
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }
}
