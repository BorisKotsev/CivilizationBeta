package gameFiles;

import views.SettlersUnitView;
import views.UnitView;

public class SettlersUnit extends MoveableUnit
{
    public SettlersUnit(int x, int y) 
    {
        super(x, y);
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
        
    }

    public UnitView getView() 
    {
        return new SettlersUnitView(this);
    }

}
