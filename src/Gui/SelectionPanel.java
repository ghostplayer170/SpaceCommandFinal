package Gui;

import Game.SaveAndLoad;
import Graphics.Assets;
import ObjectsGame.*;
import Factory.*;
import ObjectsGame.Types.TypeColor;
import javax.swing.*;

public class SelectionPanel extends CardsPanel {
    public final int WIDTHBTN = 120, HEIGHTBTN = 85; //DIMENSIONES DE BOTONES
    private final FactorySpaceShip factory;
    public SelectionPanel() {
        Assets.init();
        factory = new FactorySpaceShip();
        buildPanel();
    }
    private void buildPanel(){
        setLayout(null);

        backButton = new JButton("BACK");
        backButton.setBounds(10,10,70,25);

        selection1Label = new JLabel("ENTER YOUR NAME");
        selection1Label.setBounds(390,60,200,30);

        nameField = new JTextField();
        nameField.setBounds(350,100,200,30);

        selection2Label = new JLabel("SELECT YOUR SHIP");
        selection2Label.setBounds(390,190,200,30);

        selLightLabel = new JLabel("LIGHT CRUISER");
        selLightLabel.setBounds(75,280,200,30);

        selHeavyLabel = new JLabel("HEAVY CRUISER");
        selHeavyLabel.setBounds(75,405,200,30);

        selStarLabel = new JLabel("STAR CRUISER");
        selStarLabel.setBounds(75,530,200,30);

        //LIGHTCRUISER
        shipLightButtonR = new JButton();
        shipLightButtonR.setIcon(new ImageIcon(Assets.lightCruiserRed));
        shipLightButtonR.setBounds(250,250,WIDTHBTN,HEIGHTBTN);
        shipLightButtonB = new JButton();
        shipLightButtonB.setIcon(new ImageIcon(Assets.lightCruiserBlue));
        shipLightButtonB.setBounds(450,250,WIDTHBTN,HEIGHTBTN);
        shipLightButtonG = new JButton();
        shipLightButtonG.setIcon(new ImageIcon(Assets.lightCruiserGreen));
        shipLightButtonG.setBounds(650,250,WIDTHBTN,HEIGHTBTN);

        //HEAVYCRUISER
        shipHeavyButtonR = new JButton();
        shipHeavyButtonR.setIcon(new ImageIcon(Assets.heavyCruiserRed));
        shipHeavyButtonR.setBounds(250,380,WIDTHBTN,HEIGHTBTN);
        shipHeavyButtonB = new JButton();
        shipHeavyButtonB.setIcon(new ImageIcon(Assets.heavyCruiserBlue));
        shipHeavyButtonB.setBounds(450,380,WIDTHBTN,HEIGHTBTN);
        shipHeavyButtonG = new JButton();
        shipHeavyButtonG.setIcon(new ImageIcon(Assets.heavyCruiserGreen));
        shipHeavyButtonG.setBounds(650,380,WIDTHBTN,HEIGHTBTN);

        //STARCRUISER
        shipStarButtonR = new JButton();
        shipStarButtonR.setIcon(new ImageIcon(Assets.starCruiserRed));
        shipStarButtonR.setBounds(250,510,WIDTHBTN,HEIGHTBTN);
        shipStarButtonB = new JButton();
        shipStarButtonB.setIcon(new ImageIcon(Assets.starCruiserBlue));
        shipStarButtonB.setBounds(450,510,WIDTHBTN,HEIGHTBTN);
        shipStarButtonG = new JButton();
        shipStarButtonG.setIcon(new ImageIcon(Assets.starCruiserGreen));
        shipStarButtonG.setBounds(650,510,WIDTHBTN,HEIGHTBTN);

        add(backButton);
        add(nameField);

        add(selection1Label);
        add(selection2Label);
        add(selHeavyLabel);
        add(selLightLabel);
        add(selStarLabel);

        add(shipLightButtonR);
        add(shipHeavyButtonR);
        add(shipStarButtonR);

        add(shipLightButtonB);
        add(shipHeavyButtonB);
        add(shipStarButtonB);

        add(shipLightButtonG);
        add(shipHeavyButtonG);
        add(shipStarButtonG);

        shipLightButtonR.addActionListener(e -> selectedPlayer(shipLightButtonR));
        shipLightButtonB.addActionListener(e -> selectedPlayer(shipLightButtonB));
        shipLightButtonG.addActionListener(e -> selectedPlayer(shipLightButtonG));
        shipStarButtonR.addActionListener(e -> selectedPlayer(shipStarButtonR));
        shipStarButtonB.addActionListener(e -> selectedPlayer(shipStarButtonB));
        shipStarButtonG.addActionListener(e -> selectedPlayer(shipStarButtonG));
        shipHeavyButtonR.addActionListener(e -> selectedPlayer(shipHeavyButtonR));
        shipHeavyButtonB.addActionListener(e -> selectedPlayer(shipHeavyButtonB));
        shipHeavyButtonG.addActionListener(e -> selectedPlayer(shipHeavyButtonG));
        backButton.addActionListener(e-> ControlCards.showStartPnl());
    }
    private void selectedPlayer(JButton btn){
        //PLAYER SELECTION
        PlayerShip player = null;
        if(btn.equals(shipLightButtonR)){
            player = (PlayerShip) factory.create("ShipLight");
            player.setColor(TypeColor.RED);
        } else if (btn.equals(shipLightButtonB)) {
            player = (PlayerShip) factory.create("ShipLight");
            player.setColor(TypeColor.BLUE);
        } else if (btn.equals(shipLightButtonG)) {
            player = (PlayerShip) factory.create("ShipLight");
            player.setColor(TypeColor.GREEN);
        } else if (btn.equals(shipHeavyButtonR)) {
            player = (PlayerShip) factory.create("ShipHeavy");
            player.setColor(TypeColor.RED);
        } else if (btn.equals(shipHeavyButtonB)) {
            player = (PlayerShip) factory.create("ShipHeavy");
            player.setColor(TypeColor.BLUE);
        } else if (btn.equals(shipHeavyButtonG)) {
            player = (PlayerShip) factory.create("ShipHeavy");
            player.setColor(TypeColor.GREEN);
        } else if (btn.equals(shipStarButtonR)) {
            player = (PlayerShip) factory.create("ShipStar");
            player.setColor(TypeColor.RED);
        } else if (btn.equals(shipStarButtonB)) {
            player = (PlayerShip) factory.create("ShipStar");
            player.setColor(TypeColor.BLUE);
        } else if (btn.equals(shipStarButtonG)) {
            player = (PlayerShip) factory.create("ShipStar");
            player.setColor(TypeColor.GREEN);
        }
        if(!nameField.getText().isEmpty())
            if (player != null) {
                player.setPilot(nameField.getText());
            }
        SaveAndLoad.savePlayer(player);
        ControlCards.showGamePnl();
    }


}
