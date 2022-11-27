package Gui;

import Gui.MainFrame;

public class ControlCards {
    private static MainFrame window;
    public ControlCards(MainFrame frame) {
        window = frame;
    }
    static void showStartPnl(){
        window.cardLayout.show(window.framePanel,"StartPanel");
    }
    static void showSelectionPnl(){
        window.cardLayout.show(window.framePanel,"SelectionPanel");
    }
    static void showGamePnl(){
        window.cardLayout.show(window.framePanel,"GamePanel");
    }
    static void showStatsPnl(){
        window.cardLayout.show(window.framePanel,"StatsPanel");
    }
    static void exit(){System.exit(0);}

}
