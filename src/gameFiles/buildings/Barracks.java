package gameFiles.buildings;

import gameFiles.City;
import gameFiles.MoveableUnit;

public class Barracks implements Building
{
    public void applyBonus(City city) 
    {
        
    }

    public void applyBonus(MoveableUnit unit) 
    {
        unit.setAttackPoints(unit.getAttackPoints() + 1);
        unit.setDefensePoints(unit.getDefensePoints() + 1);
    }

}
