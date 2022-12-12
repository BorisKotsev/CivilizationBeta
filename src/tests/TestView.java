package tests;

import javax.swing.JFrame;

import gameFiles.Game;
import views.GameView;

public class TestView 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Civilization");
        
        frame.setBounds(10, 10, 960, 960);

        frame.add(new GameView(Game.getInstance(), 960, 960));

        frame.pack();

        frame.setVisible(true);
    }    
}
