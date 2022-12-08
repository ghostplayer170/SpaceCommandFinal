package Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static Functions.Functions.playerDataFromHistory;
import static Game.SaveAndLoad.loadDataHistory;

public class StatsPanel extends Panels {
    private JPanel canvasLabel;
    public StatsPanel(){
        buildPanel();
    }
    private void buildPanel(){
        setLayout(null);

        setBackground(spaceImage);

        JButton tryAgainButton = new JButton("TRY AGAIN");
        tryAgainButton.setBounds(775,10,100,25);
        add(tryAgainButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(10,10,70,25);
        add(backButton);

        JLabel titleLabel = new JLabel("GAME OVER");
        titleLabel.setBounds(200,100,700,150);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 85));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);

        JButton statsButton = new JButton("SHOW SCORE");
        statsButton.setBounds(375,370,150,50);
        add(statsButton);

        canvasLabel = new JPanel();
        canvasLabel.setBounds(245,300,450,200);
        canvasLabel.setLayout(new BoxLayout(canvasLabel, BoxLayout.PAGE_AXIS));
        canvasLabel.add(Box.createRigidArea(new Dimension(5,5)));
        canvasLabel.setOpaque(false);

        statsButton.addActionListener(e -> {
            statsButton.setVisible(false);
            buildScore(loadData());
            add(canvasLabel);
        });

        tryAgainButton.addActionListener(e-> {
            statsButton.setVisible(true);
            canvasLabel.removeAll();
            add(statsButton);
            ControlCards.showGamePnl();
        });
        backButton.addActionListener(e-> {
            statsButton.setVisible(true);
            canvasLabel.removeAll();
            add(statsButton);
            ControlCards.showStartPnl();
        });
    }
    private ArrayList<String> loadData(){
        return new ArrayList<>(playerDataFromHistory(loadDataHistory()));
    }

    private void buildScore(ArrayList<String> playerDataScore){
        int posx=250, posy=275, width=450, height=150, fontSize=30;

        JLabel nameLabel = new JLabel("PILOT : " + playerDataScore.get(0).toUpperCase());
        nameLabel.setBounds(posx,posy,width,height);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, fontSize));
        nameLabel.setForeground(Color.WHITE);
        canvasLabel.add(nameLabel);

        JLabel shipLabel = new JLabel("SHIP : " + playerDataScore.get(1).toUpperCase());
        shipLabel.setBounds(posx,posy+50,width,height);
        shipLabel.setFont(new Font("Tahoma", Font.BOLD, fontSize));
        shipLabel.setForeground(Color.WHITE);
        canvasLabel.add(shipLabel);

        JLabel shipColorLabel = new JLabel("COLOR : " + playerDataScore.get(2).toUpperCase());
        shipColorLabel.setBounds(posx,posy+100,width,height);
        shipColorLabel.setFont(new Font("Tahoma", Font.BOLD, fontSize));
        shipColorLabel.setForeground(Color.WHITE);
        canvasLabel.add(shipColorLabel);

        JLabel scoreLabel = new JLabel("SCORE : " + playerDataScore.get(3));
        scoreLabel.setBounds(posx,posy+150,width,height);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, fontSize));
        scoreLabel.setForeground(Color.WHITE);
        canvasLabel.add(scoreLabel);
    }
}
