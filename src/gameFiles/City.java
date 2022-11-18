package gameFiles;

import views.CityView;
import views.UnitView;

public class City extends GameUnit 
{
    private final String name;
    
    private int productionPerTurn; 
    private int productionInProgress;
    
    private GameUnit inProduction;

    public City(String name, int x, int y)
    {
        super(x, y);

        this.name = name;

        productionPerTurn = 1;

        productionInProgress = 0;

        inProduction = new SettlersUnit(x + 1, y);
    }

    public void incrementProductionInProgress()
    {
        productionInProgress += productionPerTurn;

        if(productionInProgress >= inProduction.getProductionPoints())
        {
            Game.getInctnance().units.add(inProduction);

            inProduction = new SettlersUnit(x + 1, y);

            productionInProgress -= inProduction.getProductionPoints();
        }
    }

    public UnitView getView() 
    {
        return new CityView(this);
    }

    public String getName()
    {
        return name;
    }

    public boolean isCity()
    {
        return true;
    }

}
