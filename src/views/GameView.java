package views;

import files.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class GameView extends JComponent
{
    private Game game;

    private int width;
    private int height;

    public GameView(Game game, int width, int height)
    {
        this.game = game;
        this.width = width;
        this.height = height;

        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        
        setBackground(Color.white);
        
        setVisible(true);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D graphics = (Graphics2D) g;

        int fieldWidth = width / game.cols;
        int fieldHeight = height / game.rows;

        for(int i = 0; i < width; i += fieldWidth)
        {
            graphics.draw(new Line2D.Double(i, 0, i, height));
        }

        for(int i = 0; i < height; i += fieldHeight)
        {
            graphics.draw(new Line2D.Double(0, i, width, i));
        }
    }
}
