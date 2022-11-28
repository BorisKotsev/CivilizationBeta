package gameFiles;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

public class Player 
{
    private static int currID = 1;
    private int ID;
    private int scienceInProgress;

    private String name;
    
    private List <City> cities;
    private List <MoveableUnit> units;
    
    private EnumSet <Technology> technologies;
    private Technology technologyInProgress;

    private GameUnit selectedUnit;

    public Player(String name) 
    {
        this.name = name;

        cities = new LinkedList<>();
        units = new LinkedList<>();

        technologies = EnumSet.noneOf(Technology.class);

        selectedUnit = null;
        technologyInProgress = null;

        ID = currID ++;

        scienceInProgress = 0;
    }

    public void incrementSciencePoints()
    {
        int sum = 0;

        for (City city : cities) 
        {
            sum += city.getScincePerTurn();    
        }

        scienceInProgress += sum;

        if(technologyInProgress == null)
        {
            return;
        }

        if(scienceInProgress >= technologyInProgress.getSciencePoints())
        {
            technologies.add(technologyInProgress);

            scienceInProgress -= technologyInProgress.getSciencePoints();

            technologyInProgress = null;
        }
    }
    
    public List<GameUnit> getAllUnits()
    {
        List<GameUnit> all = new LinkedList<>(units);

        all.addAll(all);

        return all;
    }

    public int getID() 
    {
        return ID;
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
        if(this.selectedUnit != null)
        {
            this.selectedUnit.setSelected(false);
        }

        this.selectedUnit = selectedUnit;
        
        if(this.selectedUnit != null)
        {
            this.selectedUnit.setSelected(true);
        }
    }

    public Technology getTechnologyInProgress() 
    {
        return technologyInProgress;
    }

    public void setTechnologyInProgress(Technology technologyInProgress) 
    {
        this.technologyInProgress = technologyInProgress;
    }

    public List<Technology> getPossibleTechnologies()
    {
        List<Technology> result = new LinkedList<>(List.of(Technology.values()));

        technologies.forEach(technology -> result.remove(technology));
        
        List<Technology> toRemove = new LinkedList<>();

        for(int i = result.size() - 1; i >= 0; i --)
        {
            for(Technology needed : result.get(i).getNeededTechnologies())
            {
                if(!technologies.contains(needed))
                {
                    toRemove.add(result.get(i));
                }
            }
        }

        toRemove.forEach(t -> result.remove(t));

        return result;
    }
}
