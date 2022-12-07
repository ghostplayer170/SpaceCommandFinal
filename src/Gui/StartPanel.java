package Gui;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends Panels {
    public StartPanel() {
        buildPanel();
    }
    private void buildPanel(){
        setLayout(null);

        setBackground(spaceImage);

        JLabel titleLabel = new JLabel("SPACE COMMAND");
        titleLabel.setBounds(125,100,700,300);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 70));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);

        JButton startButton = new JButton("START");
        startButton.setBounds(375,370,150,50);
        add(startButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(10,10,70,25);
        add(exitButton);

        startButton.addActionListener(e-> ControlCards.showSelectionPnl());
        exitButton.addActionListener(e-> ControlCards.exit());
    }
}
