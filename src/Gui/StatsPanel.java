package Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static Functions.Functions.playerDataFromHistory;
import static Game.SaveAndLoad.loadDataHistory;

public class StatsPanel extends CardsPanel {
    public StatsPanel(){
        buildPanel();
    }
    private void buildPanel(){
        setLayout(null);
        tryAgainButton = new JButton("TRY AGAIN");
        tryAgainButton.setBounds(775,10,100,25);
        backButton = new JButton("BACK");
        backButton.setBounds(10,10,70,25);
        JLabel titleLabel = new JLabel("GAME OVER");
        titleLabel.setBounds(200,100,700,150);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 85));
        add(tryAgainButton);
        add(backButton);
        add(titleLabel);
        tryAgainButton.addActionListener(e-> ControlCards.showGamePnl());
        backButton.addActionListener(e-> ControlCards.showStartPnl());
        loadData();
    }
    private void loadData(){
        ArrayList<String> playerDataScore = new ArrayList<>(playerDataFromHistory(loadDataHistory()));
        //playerDataScore = playerDataFromHistory(loadDataHistory());

        int posx=250, posy=275, width=450, height=150;

        JLabel nameLabel = new JLabel("PILOT : " +playerDataScore.get(0).toUpperCase());
        nameLabel.setBounds(posx,posy,width,height);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(nameLabel);

        JLabel shipLabel = new JLabel("SHIP : " +playerDataScore.get(1).toUpperCase());
        shipLabel.setBounds(posx,posy+50,width,height);
        shipLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(shipLabel);

        JLabel shipColorLabel = new JLabel("COLOR : " +playerDataScore.get(2).toUpperCase());
        shipColorLabel.setBounds(posx,posy+100,width,height);
        shipColorLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(shipColorLabel);

        JLabel scoreLabel = new JLabel("SCORE : " + playerDataScore.get(3));
        scoreLabel.setBounds(posx,posy+150,width,height);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(scoreLabel);
    }

}
