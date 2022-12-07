package Gui;

import javax.swing.*;
import java.awt.*;
public class MainFrame extends JFrame{

    public static final int WIDTH = 900, HEIGHT = 700; //DIMENSIONES DE LA VENTANA
    public final CardLayout cardLayout;
    public final JPanel framePanel;

    public MainFrame(){
        setTitle("SPACE COMMAND");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //EVITAR REDIMENSIONAMIENTO DEL JUEGO
        setLocationRelativeTo(null);

        framePanel = new JPanel();
        add(framePanel);

        cardLayout = new CardLayout();
        framePanel.setLayout(cardLayout);

        StartPanel startPnl = new StartPanel();
        framePanel.add(startPnl,"StartPanel");

        SelectionPanel selectionPnl = new SelectionPanel();
        framePanel.add(selectionPnl,"SelectionPanel");

        GamePanel gamePnl = new GamePanel();
        framePanel.add(gamePnl,"GamePanel");

        StatsPanel statsPnl = new StatsPanel();
        framePanel.add(statsPnl, "StatsPanel");

        new ControlCards(this);

        setVisible(true);
    }
}