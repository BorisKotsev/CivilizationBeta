package views;

import gameFiles.Game;
import gameFiles.GameUnit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JTextField;

import gameFiles.SettlersUnit;
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
        
        setBackground(new Color(58, 224, 103));
        
        setVisible(true);

        setFocusable(true);

        JTextField field = new JTextField();

        this.add(field);

        addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e)
            {
                requestFocusInWindow();

                int x = e.getX(), y = e.getY();
                int fieldWidth = width / game.cols, fieldHeight = height / game.rows;
                int topLeftX = 0, topLeftY = 0;    
                
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
                
                int unitX = topLeftX / fieldWidth, unitY = topLeftY / fieldHeight;

                if(e.getButton() == MouseEvent.BUTTON1) //left
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

                if(e.getButton() == MouseEvent.BUTTON3) //right
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
                        MoveableUnit unit = ((MoveableUnit)game.selectedUnit);

                        unit.setX(unitX);
                        unit.setY(unitY);

                        repaint();
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

        addKeyListener(new KeyListener()
        {
            public void keyTyped(KeyEvent e) 
            {
                
            }

            public void keyPressed(KeyEvent e) 
            {
                if(e.getKeyChar() == 'b' ||
                   e.getKeyChar() == 'B') 
                {
                    if(game.selectedUnit == null)
                    {
                        return;
                    }

                    if(!(game.selectedUnit instanceof SettlersUnit))
                    {
                        return;
                    }

                    ((SettlersUnit)game.selectedUnit).buildCity();

                    repaint();
                }             
            }

            public void keyReleased(KeyEvent e) 
            {
                  
            }
            
        });
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D graphics = (Graphics2D) g;

        graphics.setColor(getBackground());
        graphics.fill(new Rectangle2D.Double(0, 0, width, height));
        graphics.setColor(Color.black);

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

    public boolean isFocusable()
    {
        return true;
    }
}
