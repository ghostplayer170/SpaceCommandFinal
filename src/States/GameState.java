package States;

import Gui.GamePanel;
import Factory.FactorySpaceShip;
import Game.SaveAndLoad;
import Graphics.Assets;
import Gui.MainFrame;
import ObjectsGame.Asteroid;
import ObjectsGame.MovingObject;
import ObjectsGame.PlayerShip;
import Math.Vector2D;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static Functions.Functions.*;

/**
 * Clase para la logica del juego
 */

public class GameState {

    private PlayerShip player;
    private int asteroids;
    private int asteroidsDestroyed;
    private ArrayList<MovingObject> movingObjects = new ArrayList<>();
    private int score;
    private boolean gameOver;

    public GameState(){
        player = loadPlayer();
        player.setGameState(this);
        movingObjects.add(player);
        asteroids = 1;
        asteroidsDestroyed = 0;
        startWave(1);
    }

    private void startWave(int ast){
        double x, y;
        for(int i=0; i<ast; ++i){
            x = Math.random() * MainFrame.WIDTH-75;
            y = MainFrame.HEIGHT+100;
            BufferedImage texture = Assets.bigs[(int)(Math.random()*Assets.bigs.length)];
            movingObjects.add(new Asteroid(new Vector2D(x,y), texture, this));
        }
        ++asteroids;
    }

    public PlayerShip loadPlayer(){
        ArrayList<String> playerData = new SaveAndLoad().loadShip();
        FactorySpaceShip Factory = new FactorySpaceShip();
        String playerName = playerData.get(0);
        String playerType = playerData.get(1);
        String playerColor = playerData.get(2);
        PlayerShip playerShip = (PlayerShip) Factory.create(playerType);
        playerShip.setPilot(playerName);
        playerShip.setColor(toEnumColor(playerColor));
        return playerShip;
    }

    public void update(){
        for (int i=0;i<movingObjects.size();++i) {
            movingObjects.get(i).update();
        }
        if((asteroids-1) == asteroidsDestroyed) {
            startWave(asteroids);
        }
    }

    public void paintComponent(GamePanel g) {
        for (int i = 0;i<movingObjects.size();++i){
            movingObjects.get(i).paintComponent(g);
        }
        drawScore(g);
    }

    public ArrayList<MovingObject> getMovingObjects() {
        return movingObjects;
    }

    public void addScore(int value){
        score += value;
    }

    private void drawScore(GamePanel g){
        Vector2D pos = new Vector2D(800, 25);
        String scoreToString = Integer.toString(score);
        for(int i = 0; i < scoreToString.length(); i++) {
            JLabel imgLabel = toImageJLabelScore(Assets.numbers[Integer.parseInt(scoreToString.substring(i, i + 1))]);
            imgLabel.setBounds((int)pos.getX(), (int)pos.getY(), 20, 20);
            g.add(imgLabel);
            pos.setX(pos.getX() + 20);
        }
    }

    public void setAsteroidsDestroyed(int asteroidsDestroyed) {
        this.asteroidsDestroyed += asteroidsDestroyed;
    }

    public void gameOver(){
        SaveAndLoad.saveHistory(player,score);
        Timer timer = new Timer (750, e -> gameOver = true);
        timer.start();
    }

    public boolean isGameOver() {
        return this.gameOver;
    }
}
