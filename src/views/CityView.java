package views;

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

    void draw(Graphics2D g, int width, int height, Color playerColor) 
    {
        Rectangle2D rect = new Rectangle2D.Double(0, 0, width, height);

        g.setColor(playerColor);
        g.fill(rect);
        g.translate(0, 2 * height);
        g.setColor(Color.white);
        g.drawString(city.getName(), 0, 0);
        g.translate(0, -2 * height);
    }
}
