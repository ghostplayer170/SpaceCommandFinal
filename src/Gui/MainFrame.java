package Gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public static final int WIDTH = 900, HEIGHT = 700; //DIMENSIONES DE LA VENTANA
    public final CardLayout cardLayout;
    public final JPanel framePanel;
    private Thread thread;

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
        SelectionPanel selectionPnl = new SelectionPanel();
        StatsPanel statsPnl = new StatsPanel();
        GamePanel gamePnl = new GamePanel();

        framePanel.add(startPnl,"StartPanel");
        framePanel.add(selectionPnl,"SelectionPanel");
        framePanel.add(gamePnl,"GamePanel");
        framePanel.add(statsPnl,"StatsPanel");

        new ControlCards(this);

        setVisible(true);
    }
}