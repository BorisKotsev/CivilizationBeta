package gameFiles.buildings;

import gameFiles.City;
import gameFiles.MoveableUnit;
import gameFiles.Technology;

public class Library implements Building
{
    public void applyBonus(City city) 
    {
        city.setSciencePerTurn(city.getSciencePerTurn() + 10);
        city.setProductionPerTurn(city.getProductionPerTurn() + 1);
    }

    public void applyBonus(MoveableUnit unit) 
    {
        
    }

    public Technology getNeededTechnology()
    {
        return Technology.ALPHABET;
    }

    public int getProductionPoints()
    {
        return 15;
    }
}
