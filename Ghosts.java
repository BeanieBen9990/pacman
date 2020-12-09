import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Ghosts
{
    private Color c;    
    private int x, y, arcAngle, xv, yv, mouth;   
    private Rectangle r;  
    public Ghosts(int xx, int yy)
    {
        c = Color.red; 
        x = xx;  
        y = yy;    
        //xv = 0;    
        //yv = 7;        
        
        r = new Rectangle(x, y, 30, 30);
    }

    public Rectangle getR()  
    {       
        return r;  
    }

    public void drawGhosts(Graphics2D gr)    
    {
        gr.setColor(c);   
        gr.fillRect(x, y, 30, 10);
        gr.fillRect(x-20, y, 70, 10);
        gr.fillRect(x-30, y, 90, 10);
        gr.fillRect(x-40, y, 40, 10);
            gr.fillRect(x, y, 20, 10);
        gr.fillRect(x+20, y, 40, 10);
            gr.fillRect(x+60, y, 20, 10);
        gr.fillRect(x-40, y, 30, 10);
            gr.fillRect(x-10, y, 10, 10);
                gr.fillRect(x, y, 20, 10);
        gr.fillRect(x+20, y, 30, 10);
            gr.fillRect(x+50, y, 10, 10);
                gr.fillRect(x+60, y, 20, 10);
         gr.fillRect(x-40, y, 30, 10);
            gr.fillRect(x-10, y, 10, 10);
                gr.fillRect(x, y, 20, 10);
        gr.fillRect(x+20, y, 30, 10);
            gr.fillRect(x+50, y, 10, 10);
                gr.fillRect(x+60, y, 20, 10);     
        gr.fillRect(x-50, y, 40, 10);
            gr.fillRect(x, y, 20, 10);
        gr.fillRect(x+20, y, 40, 10);
            gr.fillRect(x+60, y, 20, 10);
        gr.fillRect(x-50, y, 130, 40);
                
        
        
    }

    /*public void move()
    {
           x += xv;    
          y += yv;    
        r.setLocation(x, y);
        if(x<-7)
        x=760;
        if(x>760)
        x=-7;
    }

    public void moveUp()
    {     
        xv = 0;   
        yv = -7;   
    }

    public void moveDown()
    {
        xv = 0;     
        yv = 7;    
    }

    public void moveLeft(){
        xv = -7;   
        yv = 0;    
    } 

    public void moveRight()
    {       
        xv = 7;    
        yv = 0;  
    }

    public void moveBack(Rectangle z)
    {
       if(r.intersects(z))
       {
        x-=xv;
        y-=yv;     
        r.setLocation(x,y);
        //xv*=-1;
        //yv*=-1;
        }
              
       //r.setLocation(z.get(x), z.get(y), 30,30);
       //x-=xv;
       //y-=yv;
      
    } */
}

