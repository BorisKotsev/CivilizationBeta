package gameFiles;
import java.util.LinkedList;
import java.util.List;

public class Game
{
    private static Game instance = null;

    public static Game getInctnance()
    {
        if(instance == null)
        {
            instance = new Game();
        }
        
        return instance;
    }

    public List<GameUnit> units = new LinkedList<>();

    public GameUnit selectedUnit = null;

    public int rows = 50;
    public int cols = 50;

    private Game()
    {
        units.add(new SettlersUnit(10, 10));
        units.add(new SettlersUnit(20, 20));
        units.add(new SettlersUnit(12, 15));
        
        //selectedUnit = units.get(1);
        //selectedUnit.setSelected(true);
    }
}
