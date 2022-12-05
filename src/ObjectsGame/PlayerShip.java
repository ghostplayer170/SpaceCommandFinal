package ObjectsGame;

import Gui.GamePanel;
import Factory.SpaceShip;
import Functions.Functions;
import Gui.MainFrame;
import Input.KeyBoard;
import ObjectsGame.Types.TypeColor;
import ObjectsGame.Types.TypeObject;
import ObjectsGame.Types.TypeShip;
import States.GameState;
import Math.Vector2D;

/**
 * Es una clase abstracta para la nave del jugador.
 */

public abstract class PlayerShip extends MovingObject implements SpaceShip {
    protected TypeColor playerTypeColor;
    protected TypeShip playerType;
    protected String pilot;
    protected double speed;
    protected int fireRate;
    protected Chronometer fire;

    PlayerShip(Vector2D pos) {
        super(pos);
        speed = 0;
        fireRate = 250;
        typeObject = TypeObject.PlayerShip;
        fire = new Chronometer();
        image = null;
        playerType = null;
        playerTypeColor = null;
        pilot = "Unknown_Player";
    }

    public TypeShip getPlayerType(){
        return playerType;
    }
    public TypeColor getPlayerColor(){
        return playerTypeColor;
    }
    public String getPilot() {
        return pilot;
    }
    public void setPilot(String pilot){this.pilot = pilot;}
    public abstract void setColor(TypeColor typeColor);
    public void paintComponent(GamePanel g) {
        imgLabel = Functions.toImageJLabel(getBufferedImagePlayer());
        imgLabel.setBounds((int)position.getX(), (int)position.getY(), 110, 110);
        g.add(imgLabel);
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public void move() {

        //MOVEMENT
        if(KeyBoard.RIGHT)
            position.setX(position.getX()+speed);
        if(KeyBoard.LEFT)
            position.setX(position.getX()-speed);
        if(KeyBoard.UP)
            position.setY(position.getY()-speed);
        if(KeyBoard.DOWN)
            position.setY(position.getY()+speed);

        //LIMITS SCREEN
        if(position.getX() < -15)
            position.setX(-15);
        if(position.getY() < 0)
            position.setY(0);
        if(position.getX() > MainFrame.WIDTH-110)
            position.setX(MainFrame.WIDTH-110);
        if(position.getY() > MainFrame.HEIGHT-125)
            position.setY(MainFrame.HEIGHT-125);
    }

    public void update(){
        move();
        shoot();
        collision();
    }

    @Override
    public void destroy() {
        gameState.gameOver();
        super.destroy();
    }
}
