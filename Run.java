import java.awt.*;
import javax.swing.*;

public class Run extends JFrame 
{
    private Window myWindow;
    private int x,y,width,height;

    public Run(int x, int y, int width, int height, int nbRain)
    {
        this.setLayout(null);
        this.setBounds(x,y,width,height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow = new Window(0,0,width,height,nbRain);
        this.setContentPane(myWindow);
        this.setVisible(true);
    }
    public static void main (String[] args)
    {
        Run runMain = new Run(100,100,800,800,1000);
    }
}