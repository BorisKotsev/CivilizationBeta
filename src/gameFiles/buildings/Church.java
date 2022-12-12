package gameFiles.buildings;

import gameFiles.City;
import gameFiles.MoveableUnit;
import gameFiles.Technology;

public class Church implements Building
{
    public void applyBonus(City city) 
    {
        city.setSciencePerTurn(city.getSciencePerTurn() + 2);
    }

    public void applyBonus(MoveableUnit unit) 
    {
        unit.setHealthPoints(unit.getHealthPoints() + 1);
    }

    public int getProductionPoints()
    {
        return 20;
    }

    public Technology getNeededTechnology()
    {
        return Technology.MYSTICISM;
    }
    
}
