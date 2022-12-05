package Gui;

import javax.swing.*;

public class StartPanel extends CardsPanel {
    public StartPanel() {
        buildPanel();
    }
    void buildPanel(){
        setLayout(null);

        titleLabel = new JLabel("SPACE COMMAND");
        titleLabel.setBounds(400,300,150,40);

        startButton = new JButton("START");
        startButton.setBounds(375,370,150,50);

        exitButton = new JButton("EXIT");
        exitButton.setBounds(10,10,70,25);

        add(titleLabel);
        add(startButton);
        add(exitButton);

        startButton.addActionListener(e-> ControlCards.showSelectionPnl());
        exitButton.addActionListener(e-> ControlCards.exit());
    }
}
