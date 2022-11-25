package views;

import java.awt.Graphics2D;
import java.awt.Color;

public abstract class UnitView 
{
    abstract void draw(Graphics2D g, int width, int height, Color playerColor);
}
