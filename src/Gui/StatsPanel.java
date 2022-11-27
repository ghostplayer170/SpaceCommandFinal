package Gui;

import javax.swing.*;

public class StatsPanel extends CardsPanel {
    public StatsPanel(){
        setLayout(null);
        tryAgainButton = new JButton("TRY AGAIN");
        tryAgainButton.setBounds(775,10,100,25);
        backButton = new JButton("BACK");
        backButton.setBounds(10,10,70,25);
        historyTable = new JTable();
        scoreTable = new JTable();
        selection1Label = new JLabel("GAME OVER");
        selection1Label.setBounds(390,60,200,30);
        selection2Label = new JLabel("TOP5");
        selection2Label.setBounds(405,190,200,30);
        add(tryAgainButton);
        add(historyTable);
        add(scoreTable);
        add(backButton);
        add(selection1Label);
        add(selection2Label);
        tryAgainButton.addActionListener(e-> ControlCards.showGamePnl());
        backButton.addActionListener(e-> ControlCards.showStartPnl());
        //new SaveAndLoad().loadDataHistory();
    }
}
