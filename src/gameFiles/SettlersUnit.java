package gameFiles;

import javax.swing.JOptionPane;

import views.SettlersUnitView;
import views.UnitView;

public class SettlersUnit extends MoveableUnit
{
    public SettlersUnit(int x, int y) 
    {
        super(x, y);

        setProductionPoints(5);
    }

    public void buildField()
    {
        throw new ActionDeniedException();
    }

    public void buildMine() 
    {
        throw new ActionDeniedException();
    }

    public void buildRoad() 
    {
        throw new ActionDeniedException();
    }

    public void buildCity() 
    {
        String cityName = JOptionPane.showInputDialog("City name: ");

        City city = new City(cityName, this.x, this.y);

        Player currPlayer = Game.getInctnance().players.get(Game.getInctnance().playerIndex);

        currPlayer.getCities().add(city);
        currPlayer.getUnits().remove(this);
    }

    public UnitView getView() 
    {
        return new SettlersUnitView(this);
    }

}
