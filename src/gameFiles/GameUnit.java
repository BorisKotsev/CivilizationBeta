package gameFiles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import views.UnitView;

public abstract class GameUnit 
{
    protected int x;
    protected int y;

    private boolean selected;

    private int productionPoints;

    private BufferedImage image;

    public BufferedImage getImage() 
    {
        return image;
    }

    protected void initImage(String path) 
    {
        File src = new File(path);
        BufferedImage img = null;

        try 
        {
            img = ImageIO.read(src);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        image = img;        
    }

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
