
/**
 * Write a description of class EjemploRectanguloMovimiento here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;

public class EjemploMoverRectangulo
{

    public static int myX;
    public static int myY;
    
    public static void Start()
    {
        
        DrawingPanel panel = new DrawingPanel(800, 600);
        panel.setBackground(Color.white);
        Graphics g = panel.getGraphics();
        g.setColor(Color.BLACK);
        
        int frame=0;
        int seconds=0;
        Draw(g,350,500);
        panel.sleep(1000);
        
        panel.onMouseMove((x,y) -> {myX=x;myY=y;} );
        
        while (seconds<10)
        {
            panel.clear();
            Draw(g,myX,500);
            g.drawString("Time: " + seconds,700 , 10);
            if(frame%30==0)
            {
               seconds++; 
            }
            frame++;
            panel.sleep(33);
        }
    }
    
    public static void Draw(Graphics graphics, int x, int y)
    {
        graphics.fillRect(x,y,100,100);
    }

}
