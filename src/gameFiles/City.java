package gameFiles;

import views.UnitView;

public class City extends GameUnit 
{
    private final String name;

    public City(String name, int x, int y)
    {
        super(x, y);

        this.name = name;
    }

    public UnitView getView() 
    {
        return null;
    }

}
