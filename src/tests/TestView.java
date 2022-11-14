package tests;

import javax.swing.JFrame;

import gameFiles.Game;
import views.GameView;

public class TestView 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Game");
        
        frame.setBounds(10, 10, 500, 500);

        frame.add(new GameView(new Game(), 500, 500));

        frame.pack();

        frame.setVisible(true);
    }    
}
