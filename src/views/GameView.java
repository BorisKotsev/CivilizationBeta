package views;

import gameFiles.Game;
import gameFiles.GameUnit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

import gameFiles.MoveableUnit;

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

        addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e)
            {
                int x = e.getX(), y = e.getY();
                int fieldWidth = width / game.cols, fieldHeight = height / game.rows;
                int topLeftX = 0, topLeftY = 0;    
                int unitX = topLeftX / fieldWidth, unitY = topLeftY / fieldHeight;
                
                outer: for(int i = 0; i < game.rows; i ++)
                {
                    for(int j = 0; j < game.cols; j ++)
                    {
                        int currTopLeftX = j * fieldWidth;
                        int currTopLeftY = i * fieldHeight;
                        
                        if(currTopLeftX <= x && x <= currTopLeftX + fieldWidth &&
                        currTopLeftY <= y && y <= currTopLeftY + fieldHeight)
                        {
                            topLeftX = currTopLeftX;
                            topLeftY = currTopLeftY;

                            break outer;
                        }
                    }
                }

                if(e.getButton() == MouseEvent.BUTTON1)
                {   
                    if(game.selectedUnit != null)
                    {
                        game.selectedUnit.setSelected(false);
                        game.selectedUnit = null;
                    }

                    for(GameUnit unit: game.units)
                    {
                        if(unitX == unit.getX() && unitY == unit.getY())
                        {
                            game.selectedUnit = unit;
                            unit.setSelected(true);

                            break;
                        }
                    }

                    repaint();
                }

                if(e.getButton() == MouseEvent.BUTTON3)
                {
                    if(game.selectedUnit == null)
                    {
                        return;
                    }

                    if(!game.selectedUnit.isMoveable())
                    {
                        return;
                    }

                    if(Math.abs(game.selectedUnit.getX() - unitX) <= 1 || 
                       Math.abs(game.selectedUnit.getY() - unitY) <= 1)
                    {
                        //((MoveableUnit)game.selectedUnit);
                    }
                }
            }

            public void mousePressed(MouseEvent e) 
            {
                
            }

            public void mouseReleased(MouseEvent e) 
            {
                
            }

            public void mouseEntered(MouseEvent e) 
            {
               
            }

            public void mouseExited(MouseEvent e)
            {
                
            }
            
        });
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D graphics = (Graphics2D) g;

        int fieldWidth = width / game.cols, fieldHeight = height / game.rows;

        for(int i = 0; i < width; i += fieldWidth)
        {
            graphics.draw(new Line2D.Double(i, 0, i, height));
        }

        for(int i = 0; i < height; i += fieldHeight)
        {
            graphics.draw(new Line2D.Double(0, i, width, i));
        }

        for(GameUnit unit : game.units)
        {
            graphics.translate(fieldWidth * unit.getX(), fieldHeight * unit.getY());

            unit.getView().draw(graphics, fieldWidth, fieldHeight);

            graphics.translate(-fieldWidth * unit.getX(), -fieldHeight * unit.getY());
        }
    }
}
