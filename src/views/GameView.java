package views;

import gameFiles.City;
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

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gameFiles.SettlersUnit;
import gameFiles.Technology;
import gameFiles.MoveableUnit;
import gameFiles.Player;
import gameFiles.SelectionManager;

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
                    Player currPlayer = game.players.get(game.playerIndex);
                    
                    if(currPlayer.getSelectedUnit() != null)
                    {
                        currPlayer.getSelectedUnit().setSelected(false);
                        currPlayer.setSelectedUnit(null);
                    }

                    for(GameUnit unit : currPlayer.getAllUnits())
                    {
                        if(unitX == unit.getX() && unitY == unit.getY())
                        {
                            currPlayer.setSelectedUnit(unit);
                            unit.setSelected(true);

                            break;
                        }
                    }

                    repaint();
                }

                if(e.getButton() == MouseEvent.BUTTON3) //right
                {
                    Player currPlayer = game.players.get(game.playerIndex);
                    
                    if(currPlayer.getSelectedUnit() == null)
                    {
                        return;
                    }

                    if(!currPlayer.getSelectedUnit().isMoveable())
                    {
                        return;
                    }

                    if(Math.abs(currPlayer.getSelectedUnit().getX() - unitX) <= 1 && 
                       Math.abs(currPlayer.getSelectedUnit().getY() - unitY) <= 1)
                    {
                        MoveableUnit unit = ((MoveableUnit)currPlayer.getSelectedUnit());

                        unit.setXY(unitX, unitY);

                        if(unit.isMoved())
                        {
                            MoveableUnit next = SelectionManager.nextUnit(currPlayer);
                        
                            currPlayer.setSelectedUnit(next);
                        }

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
                    Player currPlayer = game.players.get(game.playerIndex);
                    
                    if(currPlayer.getSelectedUnit() == null)
                    {
                        return;
                    }

                    if(!(currPlayer.getSelectedUnit() instanceof SettlersUnit))
                    {
                        return;
                    }

                    ((SettlersUnit)currPlayer.getSelectedUnit()).buildCity();

                    repaint();
                }       
                
                if(e.getKeyCode() == 10) //enter
                {
                    Player currPlayer = game.players.get(game.playerIndex);

                    currPlayer.getCities().forEach(city -> {city.incrementProductionInProgress(); city.setSelected(false);});

                    currPlayer.getUnits().forEach(moveableUnit -> {moveableUnit.setMoved(false); moveableUnit.setSelected(false);});
                    
                    currPlayer.incrementSciencePoints();

                    game.nextPlayer();
                    
                    Player nextPlayer = game.players.get(game.playerIndex);

                    JOptionPane.showMessageDialog(null, nextPlayer.getName() + "'s on turn!");

                    if(nextPlayer.getTechnologyInProgress() == null && nextPlayer.getCities().size() > 0)
                    {
                        JComboBox<?> comboBox = new JComboBox<>(nextPlayer.getPossibleTechnologies().toArray());

                        JOptionPane.showMessageDialog(null, comboBox, "Select technology: ", JOptionPane.QUESTION_MESSAGE);
                   
                        nextPlayer.setTechnologyInProgress((Technology)comboBox.getSelectedItem());
                    }

                    MoveableUnit next = SelectionManager.nextUnit(currPlayer);
                        
                    currPlayer.setSelectedUnit(next);                    

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

        for(Player player : game.players)
        {
            for(MoveableUnit unit : player.getUnits())
            {
                graphics.translate(fieldWidth * unit.getX(), fieldHeight * unit.getY());
                
                unit.getView().draw(graphics, fieldWidth, fieldHeight, game.playerColorsMap.get(player.getID()));
                
                graphics.translate(-fieldWidth * unit.getX(), -fieldHeight * unit.getY());
            }

            for(City city : player.getCities())
            {
                graphics.translate(fieldWidth * city.getX(), fieldHeight * city.getY());
                
                city.getView().draw(graphics, fieldWidth, fieldHeight, game.playerColorsMap.get(player.getID()));
                
                graphics.translate(-fieldWidth * city.getX(), -fieldHeight * city.getY());
            }
        }
    }

    public boolean isFocusable()
    {
        return true;
    }
}
