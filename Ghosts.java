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
    private int x, y, xv, yv;   
    int ran;
    private Rectangle r;  
    public Ghosts(int xx, int yy)
    {  
        c = new Color((int)(Math.random()*(216)+39),(int)(Math.random()*(216)+39),(int)(Math.random()*(216)+39)); 
        x = xx;  
        y = yy;    
        ran = (int)(Math.random()*(10)+5);
        if(ran % 2 ==0)
        { 
            xv = (int)(Math.random()*11)-5;
            yv = 0;
        }
        else
        {        
            yv = (int)(Math.random()*11)-5;
            xv = 0;
        }     

        r = new Rectangle(x-50, y, 140, 130);
    }

    public Rectangle getR()  
    {       
        return r;  
    }

    public void drawGhosts(Graphics2D gr)    
    {
        gr.setColor(c);   
        gr.fillRect(x, y, 30, 10);
        gr.fillRect(x-20, y+10, 70, 10);
        gr.fillRect(x-30, y+20, 90, 10);
        if(xv>0){
            gr.fillRect(x-40, y+30, 40, 10);
            gr.setColor(Color.white);
            gr.fillRect(x, y+30, 20, 10);
            gr.setColor(c);   
            gr.fillRect(x+20, y+30, 40, 10);
            gr.setColor(Color.white);
            gr.fillRect(x+60, y+30, 20, 10);
            gr.setColor(c);   
            gr.fillRect(x-40, y+40, 30, 10);
            gr.setColor(Color.white);
            gr.fillRect(x-10, y+40, 10, 10);
            gr.setColor(Color.blue);
            gr.fillRect(x, y+40, 20, 10);
            gr.setColor(c);   gr.fillRect(x+20, y+40, 30, 10);
            gr.setColor(Color.white);
            gr.fillRect(x+50, y+40, 10, 10);
            gr.setColor(Color.blue);
            gr.fillRect(x+60, y+40, 20, 10);
            gr.setColor(c);   gr.fillRect(x-40, y+50, 30, 10);
            gr.setColor(Color.white);
            gr.fillRect(x-10, y+50, 10, 10);
            gr.setColor(Color.blue);
            gr.fillRect(x, y+50, 20, 10);
            gr.setColor(c);   gr.fillRect(x+20, y+50, 30, 10);
            gr.setColor(Color.white);
            gr.fillRect(x+50, y+50, 10, 10);
            gr.setColor(Color.blue);
            gr.fillRect(x+60, y+50, 20, 10);   
            gr.setColor(c);   gr.fillRect(x+80, y+50, 10, 80);     

            gr.setColor(c);   gr.fillRect(x-50, y+60, 50, 10);
            gr.setColor(Color.white);
            gr.fillRect(x, y+60, 20, 10);
            gr.setColor(c);   gr.fillRect(x+20, y+60, 40, 10);
            gr.setColor(Color.white);
            gr.fillRect(x+60, y+60, 20, 10);
        }
        if(xv<=0)
        {
            gr.setColor(Color.white);
            gr.fillRect(x-40, y+30, 20, 10);
            gr.setColor(c);
            gr.fillRect(x-20, y+30, 40, 10);
            gr.setColor(Color.white);   
            gr.fillRect(x+20, y+30, 20, 10);
            gr.setColor(c);            
            gr.fillRect(x+40, y+30, 30, 10);

            gr.setColor(Color.blue);
            gr.fillRect(x-40, y+40, 20, 20);
            gr.setColor(Color.white);
            gr.fillRect(x-20, y+40, 10, 20);
            gr.setColor(c);
            gr.fillRect(x-10, y+40, 40, 20);
            gr.setColor(Color.blue);   
            gr.fillRect(x+20, y+40, 20, 20);
            gr.setColor(Color.white);
            gr.fillRect(x+40, y+40, 10, 20);
            gr.setColor(c);            
            gr.fillRect(x+50, y+40, 30, 20);

            gr.setColor(Color.white);
            gr.fillRect(x-40, y+60, 20, 10);
            gr.setColor(c);
            gr.fillRect(x-20, y+60, 40, 10);
            gr.setColor(Color.white);   
            gr.fillRect(x+20, y+60, 20, 10);
            gr.setColor(c);            
            gr.fillRect(x+40, y+60, 40, 10);

            gr.setColor(c);   gr.fillRect(x-50, y+50, 10, 80);
            gr.setColor(c);   gr.fillRect(x+80, y+60, 10, 70);

        }

        gr.setColor(c);   gr.fillRect(x-50, y+70, 130, 40);        
        gr.setColor(c);   gr.fillRect(x-50, y+110, 10, 20);
        gr.setColor(c);   gr.fillRect(x-40, y+110, 10, 10);
        gr.setColor(c);   gr.fillRect(x-20, y+110, 10, 10);
        gr.setColor(c);   gr.fillRect(x-10, y+110, 20, 20);
        gr.setColor(c);   gr.fillRect(x+30, y+110, 20, 20);
        gr.setColor(c);   gr.fillRect(x+50, y+110, 10, 10);
        gr.setColor(c);   gr.fillRect(x+70, y+110, 10, 10);

    }

    public void move()
    {
        x += xv;    
        y += yv;    
        
        if(x<0)
            x=600;
        if(x>600)
            x=-7;
        if(y<0)
            y=700;
        if(y>700)
            y=0;
            r.setLocation(x-50, y);
    }

    public void wallGhost()
    {
        if(xv!=0)
        {
            xv=0;
            yv = (int)(Math.random()*11)-5;
        }
        else
        {
            yv=0;
            xv = (int)(Math.random()*11)-5;
        }             
        r.setLocation(x-50,y);      
    } 
}

