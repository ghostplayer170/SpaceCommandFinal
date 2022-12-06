package Game;

import ObjectsGame.PlayerShip;
import java.io.*;
import java.util.ArrayList;

import static Functions.Functions.loadPlayerData;

public class SaveAndLoad {

    public SaveAndLoad() {

    }

    //SAVE PLAYER DATA
    public static void savePlayer(PlayerShip player) {
        FileWriter fiche = null;
        PrintWriter pw;
        try {
            fiche = new FileWriter("PlayerData.txt");
            pw = new PrintWriter(fiche);
            pw.println(player.getPilot()+","+player.getPlayerType()+","+player.getPlayerColor()+";");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fiche)
                    fiche.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //SAVE PLAYER TO HISTORY
    public static void saveHistory(PlayerShip player, int score) {
        FileWriter fiche = null;
        PrintWriter pw;
        try {
            File file = new File("GameData.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fiche = new FileWriter(file.getAbsoluteFile(), true);
            pw = new PrintWriter(fiche);
            pw.println(player.getPilot()+","+player.getPlayerType()+","+player.getPlayerColor()+","+score+";");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fiche)
                    fiche.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //LOAD DATA HISTORY
     public ArrayList<String> loadDataHistory() {

        ArrayList<String> playerDataHistory = new ArrayList<>();
        File archive;
        FileReader fr = null;
        BufferedReader br;

        try {
            archive = new File("GameData.txt");
            fr = new FileReader(archive);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null)
                playerDataHistory = loadPlayerData(linea);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return playerDataHistory;
    }

    //LOAD PLAYER
    public ArrayList<String> loadShip() {

        ArrayList<String> playerData = new ArrayList<>();
        File archive;
        FileReader fr = null;
        BufferedReader br;

        try {
            archive = new File("PlayerData.txt");
            fr = new FileReader(archive);
            br = new BufferedReader(fr);
            String linea = br.readLine();
            playerData = loadPlayerData(linea);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return playerData;
    }
}
