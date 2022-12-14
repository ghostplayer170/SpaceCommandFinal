package Gui;

import Input.KeyBoard;
import States.GameState;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    private  double delta = 0; //TIEMPO QUE VA PASANDO
    private Thread thread;
    private GameState gameState;
    private boolean running = false;
    private final KeyBoard keyBoard;
    private JButton playButton;
    public GamePanel() {
        buildPanel();
        keyBoard = new KeyBoard();
        addKeyListener(keyBoard);
    }
    private void buildPanel() {
        setLayout(null);
        setFocusable(true);
        setBackground(Color.black);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(10, 10, 70, 25);
        add(backButton);

        playButton = new JButton("PLAY");
        playButton.setBounds(375, 370, 150, 50);
        add(playButton);

        backButton.addActionListener(e -> ControlCards.showSelectionPnl());
        playButton.addActionListener(e -> {
            playButton.setVisible(false);
            start();
        });
    }
    private void update(){
        keyBoard.update();
        gameState.update();
        if(gameState.isGameOver()){
            ControlCards.showStatsPnl();
            playButton.setVisible(true);
            add(playButton);
            stop();
        }
    }
    private void paintComponent(){
        //--------PAINT-----------//
        removeAll();
        gameState.paintComponent(this);
        revalidate();
        repaint();
        //----------END-----------//
    }
    @Override
    public void run() {
        long now; //REGISTRO TIEMPO QUE VA PASANDO
        long lastTime = System.nanoTime(); //HORA ACTUAL DEL SISTEMA EN NANOSEGUNDOS
        long time = 0;

        gameState = new GameState();

        while (running){
            now = System.nanoTime();
            //MIENTRAS MENOR SEA EL TIEMPO MEJOR ES (NANOSEGUNDOS POR FOTOGRAMAS)
            int fps = 60;
            double targetTime = 1000000000 / fps;
            delta += (now - lastTime)/ targetTime; //ACTUALIZAR TIEMPO (SE PRODUCE RETRASO)
            time += (now - lastTime);
            lastTime = now; //ACTUALIZA LAS VARIABLES

            if(delta>=1){
                update();
                paintComponent();
                --delta; //CRONOMETRA EL SIGUIENTE FOTOGRAMA
            }
            if(time>=1000000000){
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
    private void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
