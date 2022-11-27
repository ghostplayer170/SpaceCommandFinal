package Gui;

import Graphics.Assets;
import Input.KeyBoard;
import States.GameState;

import javax.swing.*;

import java.awt.*;

public class GamePanel extends CardsPanel implements Runnable{

    private final int fps = 60;
    private double TargetTime = 1000000000/fps; //MIENTRAS MENOR SEA EL TIEMPO MEJOR ES (NANOSEGUNDOS POR FOTOGRAMAS)
    private  double delta = 0; //TIEMPO QUE VA PASANDO
    private int AverageFps = fps; //CONOCER LA MEDIA DE LOS FOTOGRAMAS POR SEGUNDO
    private Thread thread;
    private GameState gameState;
    private boolean running = false;
    private KeyBoard keyBoard;
    private int score;

    public GamePanel() {
        buildPanel();
        keyBoard = new KeyBoard();
        setFocusable(true);
        addKeyListener(keyBoard);
    }

    private void buildPanel() {
        setLayout(null);
        Integer score = 0, time = 0;
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setBounds(750, 10, 140, 35);
        timeLabel = new JLabel("Time: " + time);
        timeLabel.setBounds(750, 30, 140, 35);
        backButton = new JButton("BACK");
        backButton.setBounds(10, 10, 70, 25);
        gameStateLabel = new JLabel("GAME STARTS");
        nextButton = new JButton("NEXT");
        nextButton.setBounds(375, 470, 150, 50);
        playButton = new JButton("PLAY");
        playButton.setBounds(375, 370, 150, 50);
        add(gameStateLabel);
        add(scoreLabel);
        add(nextButton);
        add(timeLabel);
        add(playButton);
        add(backButton);
        backButton.addActionListener(e -> {
            ControlCards.showSelectionPnl();
            removeAll();
        });
        nextButton.setVisible(false);
        playButton.addActionListener(e -> {
            playButton.setVisible(false);
            setBackground(Color.black);
            start();
        });
    }
    private void init(){
        Assets.init();
        gameState = new GameState();
    }

    private void update(){
        keyBoard.update();
        gameState.update();
        if(gameState.isGameOver()){
            stop();
            ControlCards.showStatsPnl();
        }


    }

    private void paintComponent(){
        //--------DIBUJAR-----------

        removeAll();
        gameState.paintComponent(this);
        revalidate();
        repaint();

        //------FIN_DIBUJAR---------
    }

    @Override
    public void run() {
        long now = 0; //REGISTRO TIEMPO QUE VA PASANDO
        long lastTime = System.nanoTime(); //HORA ACTUAL DEL SISTEMA EN NANOSEGUNDOS
        int frames = 0;
        long time = 0;

        init();

        while (running){
            now = System.nanoTime();
            delta += (now - lastTime)/TargetTime; //ACTUALIZAR TIEMPO (SE PRODUCE RETRASO)
            time += (now - lastTime);
            lastTime = now; //ACTUALIZA LAS VARIABLES
            if(delta>=1){
                update();
                paintComponent();
                --delta; //CRONOMETRA EL SIGUIENTE FOTOGRAMA
                ++frames;
            }
            if(time>=1000000000){
                AverageFps = frames;
                frames = 0; //VOLVER EMPEZAR A CONTAR
                time = 0;
            }
        }
        stop();
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private void stop(){
        try {
            thread.wait();
            running = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
