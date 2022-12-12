package gameFiles;

public abstract class MoveableUnit extends GameUnit
{    
    private boolean moved;
    private boolean freezed;

    private int attackPoints;
    private int defensePoints;
    private int healthPoints;

    public int getAttackPoints() 
    {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) 
    {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() 
    {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) 
    {
        this.defensePoints = defensePoints;
    }

    public int getHealthPoints() 
    {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) 
    {
        this.healthPoints = healthPoints;
    }

    public MoveableUnit(int x, int y)
    {
        super(x, y);
        
        moved = false;
        freezed = false;
    }

    public void setSelected(boolean selected)
    {
        super.setSelected(selected);

        if(selected)
        {
            setFreezed(false);
        }
    }

    public void setMoved(boolean moved)
    {
        this.moved = moved;
    }

    public boolean isMoved()
    {
        return moved;
    }

    public boolean isFreezed() 
    {
        return freezed;
    }

    public void setFreezed(boolean freezed) 
    {
        this.freezed = freezed;
    }

    public void setX(int x)
    {
        if(moved)
        {
            return;
        }

        this.x = x;

        moved = true;
    }

    public void setY(int y)
    {
        if(moved)
        {
            return;
        }

        this.y = y;

        moved = true;
    }

    public boolean isMoveable()
    {
        return true;
    }

    public void setXY(int x, int y)
    {
        if(moved)
        {
            return;
        }
        
        this.x = x;
        this.y = y;

        moved = true;
    }
    
    abstract void buildField();
    abstract void buildMine();
    abstract void buildRoad();
    abstract void buildCity();
}