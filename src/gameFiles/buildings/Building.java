package gameFiles.buildings;

import gameFiles.City;
import gameFiles.MoveableUnit;
import gameFiles.Production;
import gameFiles.Technology;

public interface Building extends Production
{
    void applyBonus(City city);
    void applyBonus(MoveableUnit unit);

    default int getProductionPoints() { return 10; }
    default Technology getNeededTechnology() { return null; }
}
