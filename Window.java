import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.Color;

public class Window extends JPanel implements ActionListener
{
    private int x,y,width,height,nbRain;
    private Rain tabRain [];
    private Timer time;

    public Window (int x, int y, int width, int height, int nbRain)
    {   
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.nbRain = nbRain;
        tabRain = new Rain [nbRain];
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        time = new Timer(1,this);
        time.addActionListener(this);
        time.start();
        initializeRain();
        this.setVisible(true);
    }

    public void initializeRain()
    {   
        for(int i = 0; i < nbRain; i++)
        {
            tabRain[i] = new Rain(width, height, 1, this.height);
        }
    }

    public void paint (Graphics g)
    {
        g.setColor(new Color(0,7,30));
        g.fillRect(x, y, width, height);
        g.setColor(new Color(0,79,48));
        for(int i = 0; i < nbRain; i++)
        {
            g.fillRect(tabRain[i].getX(),(int)(tabRain[i].getY()),tabRain[i].getSize(),tabRain[i].getLength());
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        repaint();
        for(int i = 0; i < nbRain -1 ; i++)
        {
            tabRain[i].move();
        }

    }

}