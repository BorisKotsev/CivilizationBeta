package gameFiles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.awt.Color;

public class Game
{
    private static Game instance = null;

    public static Game getInstance()
    {
        if(instance == null)
        {
            instance = new Game();
        }
        
        return instance;
    }

    public Map<Integer, Color> playerColorsMap;

    public List<GameUnit> units = new LinkedList<>();
    public List<Player> players = new LinkedList<>();

    public GameUnit selectedUnit = null;

    public int rows = 30;
    public int cols = 30;
    public int playerIndex = 0;
    
    private Game()
    {
        playerColorsMap = new HashMap<>();
       
        playerColorsMap.put(1, Color.red);
        playerColorsMap.put(2, Color.blue);
        playerColorsMap.put(3, Color.yellow);
        playerColorsMap.put(4, Color.orange);
        playerColorsMap.put(5, Color.lightGray);

        Player player1 = new Player("Bobiko");
        Player player2 = new Player("Zlatio");
        
        player1.getUnits().add(new SettlersUnit(3, 3));
        player2.getUnits().add(new SettlersUnit(26, 26));

        players.add(player1);
        players.add(player2);
    }

    public void nextPlayer()
    {
        playerIndex ++;

        if(playerIndex == players.size())
        {
            playerIndex = 0;
        }
    }
}
