import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class Window extends JPanel implements ActionListener
{
    private int x,y,width,height,nbRain;
    private Rain tabRain [];
    private Timer time;

    private Image background;
    private Image tree;
    private Image ground;

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
        
        background = new ImageIcon(this.getClass().getResource("background.png")).getImage();
        tree = new ImageIcon(this.getClass().getResource("tree.png")).getImage();
        ground = new ImageIcon(this.getClass().getResource("ground.png")).getImage();

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
        g.drawImage(background,0,0,this);
        g.drawImage(ground,0,500,this);
        g.drawImage(tree,600,650,this);
        g.drawImage(tree,350,450,this);
        g.drawImage(tree,100,500,this);
        g.drawImage(tree,300,600,this);

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