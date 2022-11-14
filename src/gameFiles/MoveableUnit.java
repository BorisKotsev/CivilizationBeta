package gameFiles;

public abstract class MoveableUnit extends GameUnit
{
    private MoveListener moveListener;

    public void addMoveListener(MoveListener listener)
    {
        this.moveListener = listener;
    }

    public MoveableUnit(int x, int y)
    {
        super(x, y);
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public boolean isMoveable()
    {
        return true;
    }

    public void moveUp()
    {
        if(!isSelected())
        {
            return;
        }

        setY(getY() - 1);

        if(moveListener != null)
        {
            moveListener.onUnitMoved(this);
        }
    }

    public void moveUpRight()
    {
        if(!isSelected())
        {
            return;
        }

        setX(getX() + 1);
        setY(getY() - 1);

        if(moveListener != null)
        {
            moveListener.onUnitMoved(this);
        }
    }

    public void moveRight()
    {
        if(!isSelected())
        {
            return;
        }

        setX(getX() + 1);

        if(moveListener != null)
        {
            moveListener.onUnitMoved(this);
        }
    }

    public void moveDownRight()
    {
        if(!isSelected())
        {
            return;
        }

        setX(getX() + 1);
        setY(getY() + 1);

        if(moveListener != null)
        {
            moveListener.onUnitMoved(this);
        }
    }

    public void moveDown()
    {
        if(!isSelected())
        {
            return;
        }

        setY(getY() + 1);

        if(moveListener != null)
        {
            moveListener.onUnitMoved(this);
        }
    }

    public void moveDownLeft()
    {
        if(!isSelected())
        {
            return;
        }

        setX(getX() - 1);
        setY(getY() + 1);

        if(moveListener != null)
        {
            moveListener.onUnitMoved(this);
        }
    }

    public void moveLeft()
    {
        if(!isSelected())
        {
            return;
        }

        setX(getX() - 1);

        if(moveListener != null)
        {
            moveListener.onUnitMoved(this);
        }
    }

    public void moveUpLeft()
    {
        if(!isSelected())
        {
            return;
        }

        setX(getX() - 1);
        setY(getY() - 1);

        if(moveListener != null)
        {
            moveListener.onUnitMoved(this);
        }
    }
    
    abstract void buildField();
    abstract void buildMine();
    abstract void buildRoad();
    abstract void buildCity();

}