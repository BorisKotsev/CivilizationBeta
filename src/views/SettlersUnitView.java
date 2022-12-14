package views;

import gameFiles.SettlersUnit;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class SettlersUnitView extends UnitView
{
    private SettlersUnit unit;
    
    public SettlersUnitView(SettlersUnit unit)
    {
        this.unit = unit;
    }

    public void draw(Graphics2D g, int width, int height, Color playerColor)
    {
        Rectangle2D rect = new Rectangle2D.Double(0, 0, width, height);

        g.setColor(playerColor);

        g.fill(rect);

        if(unit.isSelected())
        {
            g.setColor(Color.green);
            g.setStroke(new BasicStroke(2)); 
            g.draw(rect);
        }

        g.drawImage(unit.getImage(), 0, 0, null);
    }
}
