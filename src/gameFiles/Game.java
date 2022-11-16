package gameFiles;
import java.util.LinkedList;
import java.util.List;

public class Game
{
    public List<GameUnit> units = new LinkedList<>();

    public GameUnit selectedUnit = null;

    public int rows = 50;
    public int cols = 50;

    public Game()
    {
        units.add(new SettlersUnit(10, 10));
        units.add(new SettlersUnit(20, 20));
        units.add(new SettlersUnit(12, 15));
        
        //selectedUnit = units.get(1);
        //selectedUnit.setSelected(true);
    }
}
