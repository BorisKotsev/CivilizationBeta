package gameFiles;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

public class Player 
{
    private static int currID = 1;
    private int ID;

    private String name;
    
    private List <City> cities;
    private List <MoveableUnit> units;

    private EnumSet <Technology> technologies;

    private GameUnit selectedUnit;

    public Player(String name) 
    {
        this.name = name;

        cities = new LinkedList<>();
        units = new LinkedList<>();

        technologies = EnumSet.noneOf(Technology.class);

        selectedUnit = null;

        ID = currID ++;
    }

    public int getID() 
    {
        return ID;
    }

    public List<GameUnit> getAllUnits()
    {
        List<GameUnit> all = new LinkedList<>(units);

        all.addAll(all);

        return all;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public List<City> getCities() 
    {
        return cities;
    }

    public void setCities(List<City> cities) 
    {
        this.cities = cities;
    }

    public List<MoveableUnit> getUnits() 
    {
        return units;
    }

    public void setUnits(List<MoveableUnit> units) 
    {
        this.units = units;
    }

    public EnumSet<Technology> getTechnologies() 
    {
        return technologies;
    }

    public void setTechnologies(EnumSet<Technology> technologies)
    {
        this.technologies = technologies;
    }

    public GameUnit getSelectedUnit() 
    {
        return selectedUnit;
    }

    public void setSelectedUnit(GameUnit selectedUnit)
    {
        this.selectedUnit = selectedUnit;
    }

}
