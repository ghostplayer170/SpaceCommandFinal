package ObjectsGame;

import Gui.GamePanel;
import Functions.Functions;
import Gui.MainFrame;
import ObjectsGame.Types.TypeObject;
import Math.Vector2D;
import States.GameState;

import java.awt.image.BufferedImage;

public class Asteroid extends MovingObject{

    private final int speed;
    private final boolean diagonalRight;
    private final boolean diagonalLeft;

    public Asteroid(Vector2D pos, BufferedImage texture, GameState gs) {
        super(pos);
        typeObject = TypeObject.Asteroid;
        image = texture;
        gameState = gs;
        speed = randomSpeed();
        diagonalRight = isDiagonal();
        diagonalLeft = isDiagonal();
    }

    @Override
    public void update() {
        //LIMITS SCREEN
        if(position.getX() < 0)
            position.setX(MainFrame.WIDTH);
        if(position.getY() < -100)
            position.setY(MainFrame.HEIGHT);
        if(position.getX() > MainFrame.WIDTH)
            position.setX(0);
        if(position.getY() > MainFrame.HEIGHT)
            position.setY(-100);
        position.setY(getPosition().getY()+speed);
        if(diagonalRight && !diagonalLeft)
            position.setX(getPosition().getX()+speed);
        if(!diagonalRight && diagonalLeft)
            position.setX(getPosition().getX()-speed);
    }

    private int randomSpeed(){
        return (int) Math.floor(Math.random()*5+2);
    }

    @Override
    public void paintComponent(GamePanel g) {
        imgLabel = Functions.imageToJLabel(getBufferedImagePlayer());
        imgLabel.setBounds((int)position.getX(), (int)position.getY(), 100, 100);
        g.add(imgLabel);
    }

    private boolean isDiagonal(){
        int rnd = (int) (Math.random() * 10);
        return rnd % 2 == 0;
    }

    public void destroy(){
        gameState.addScore(Constants.ASTEROID_SCORE);
        gameState.setAsteroidsDestroyed(1);
        super.destroy();
    }
}
