package gameFiles;

import java.util.LinkedList;
import java.util.List;

import gameFiles.buildings.Building;
import views.CityView;
import views.UnitView;

public class City extends GameUnit 
{
    private final String name;
    
    private int productionPerTurn; 
    
    private int productionInProgress;
    private int sciencePerTurn;

    private Production inProduction;

    private List<Building> buildings;

    public City(String name, int x, int y)
    {
        super(x, y);

        this.name = name;

        productionPerTurn = 1;
        productionInProgress = 0;
        sciencePerTurn = 1;

        inProduction = (Production) new SettlersUnit(x + 1, y);

        buildings = new LinkedList<>();

        initImage("images\\city.png");
    }

    public void incrementProductionInProgress()
    {
        productionInProgress += productionPerTurn;

        if(productionInProgress >= inProduction.getProductionPoints())
        {
            Player currPlayer = Game.getInstance().players.get(Game.getInstance().playerIndex);

            if(inProduction instanceof Building)
            {
                buildings.add((Building)inProduction);
            }
            else if(inProduction instanceof MoveableUnit)
            {
                currPlayer.getUnits().add((MoveableUnit)inProduction);
            }

            inProduction = null; //inProduction = (Production) new SettlersUnit(x + 1, y);

            productionInProgress -= inProduction.getProductionPoints();
        }
    }

    public Production getInProduction()
    {
        return inProduction;
    }    

    public void setInProduction(Production inProduction)
    {
        this.inProduction = inProduction;
    }

    public List<Production> getThingsToBuild()
    {
        return new LinkedList<>();
    }
    
    public UnitView getView() 
    {
        return new CityView(this);
    }

    public int getProductionPerTurn() 
    {
        return productionPerTurn;
    }

    public void setProductionPerTurn(int productionPerTurn) 
    {
        this.productionPerTurn = productionPerTurn;
    }

    public int getSciencePerTurn() 
    {
        return sciencePerTurn;
    }

    public void setSciencePerTurn(int sciencePerTurn) 
    {
        this.sciencePerTurn = sciencePerTurn;
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
