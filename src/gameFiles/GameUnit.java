package gameFiles;

import views.UnitView;

public abstract class GameUnit 
{
    protected int x;
    protected int y;

    private boolean selected;

    private int productionPoints;

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

    public void setProductionPoints(int productionPoints)
    {
        this.productionPoints = productionPoints;
    }

    public int getProductionPoints()
    {
        return productionPoints;
    }

    public boolean isCity()
    {
        return false;
    }

    public abstract UnitView getView();
}
