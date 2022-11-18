package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import gameFiles.City;

public class CityView extends UnitView
{
    private City city;  
    
    public CityView(City city)
    {
        this.city = city;
    }

    void draw(Graphics2D g, int width, int height) 
    {
        Rectangle2D rect = new Rectangle2D.Double(0, 0, width, height);

        g.setColor(Color.pink);

        g.fill(rect);
    }
}
