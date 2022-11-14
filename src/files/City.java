package files;

public class City extends GameUnit 
{
    private final String name;

    public City(String name, int x, int y)
    {
        super(x, y);

        this.name = name;
    }

}
