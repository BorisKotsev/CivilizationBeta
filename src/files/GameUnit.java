package files;
public abstract class GameUnit 
{
    protected int x;
    protected int y;

    protected boolean selected;

    public int getX() 
    {
        return x;
    }

    public int getY() 
    {
        return y;
    }

    public void setSelected(boolean selected) 
    {
        this.selected = selected;
    }

    public boolean isSelected() 
    {
        return selected;
    }

    public GameUnit(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        selected = false;
    }

    public boolean isMoveable()
    {
        return false;
    }
}
