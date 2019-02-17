public class Rain
{   
    private int x,length,size,iteration;
    private double speed,y, z;
    private int frameHeight;

    public Rain (double a, double b, double c, int d)
    {
        this.x = (int) (a*Math.random());
        this.y = -100;
        this.z = c*Math.random();
        this.speed = z*10;
        this.iteration = 0;
        this.frameHeight = d;
        this.size = 2*(int)(speed*0.2);
        this.length = 10*(int)(speed*0.3);
    }

    public void move ()
    {
        if(this.y > frameHeight)
        {
            this.y = -100;
            this.iteration = 0;
        }
        else
        {
            this.y = 0.03*(this.y + this.iteration*this.speed);
            this.iteration++;
        }
    }

    public int getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public int getSize()
    {
        return this.size;
    }

    public int getLength()
    {
        return this.length;
    }
}