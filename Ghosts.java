import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Ghosts
{
    private Color c, rc, cpp;    
    private int x, y;
    private double xv, yv;   
    private int ran, ran1;
    private Rectangle r, r2;  
    private boolean pp;
    public Ghosts(int x, int y)
    {  
        rc = new Color((int)(Math.random()*(216)+39),(int)(Math.random()*(216)+39),(int)(Math.random()*(216)+39)); 
        cpp = new Color(70, 165, 238);        
        this.x = x;  
        this.y = y;    
        ran = (int)(Math.random()*(100)+5);
        pp = false;
        if(ran % 2 ==0)
        { 
            xv = ((int)(Math.random()*21)-10);           
            yv = 0;
        }
        else
        {        
            yv = ((int)(Math.random()*21)-10);
            xv = 0;
        }   
        if((ran % 2 ==0) && (xv==0))
        {xv = ((int)(Math.random()*11)-5);}
        if(ran % 2 !=0 && (yv==0))
        {yv = ((int)(Math.random()*11)-5);}

        r = new Rectangle(x-1, y+4, 3, 3);
        r2= new Rectangle(-10, -10, 3, 3);
    }

    public Rectangle getR()  
    {       
        return r;  
    }

    public Rectangle getR2()  
    {       
        return r2;  
    }

    public void drawGhosts(Graphics2D gr)    
    {
        if(pp == false)
        {   c = rc;
            gr.setColor(c);
        }
        if(pp == true)
        {   c = cpp;           
        }
        gr.setColor(c);
        gr.fillRect(x, y, 3, 1);
        gr.fillRect(x-2, y+1, 7, 1);
        gr.fillRect(x-3, y+2, 9, 1);
        if(xv>0){
            gr.fillRect(x-4, y+3, 4, 1);
            gr.setColor(Color.white);
            gr.fillRect(x, y+3, 2, 1);
            gr.setColor(c);   
            gr.fillRect(x+2, y+3, 4, 1);
            gr.setColor(Color.white);
            gr.fillRect(x+6, y+3, 2, 1);
            gr.setColor(c);   
            gr.fillRect(x-4, y+4, 3, 1);
            gr.setColor(Color.white);
            gr.fillRect(x-1, y+4, 1, 1);
            gr.setColor(Color.blue); if(pp == true){gr.setColor(Color.white);}
            gr.fillRect(x, y+4, 2, 1);
            gr.setColor(c);   gr.fillRect(x+2, y+4, 3, 1);
            gr.setColor(Color.white);
            gr.fillRect(x+5, y+4, 1, 1);
            gr.setColor(Color.blue); if(pp == true){gr.setColor(Color.white);}
            gr.fillRect(x+6, y+4, 2, 1);
            gr.setColor(c);   gr.fillRect(x-4, y+5, 3, 1);
            gr.setColor(Color.white);
            gr.fillRect(x-1, y+5, 1, 1);
            gr.setColor(Color.blue); if(pp == true){gr.setColor(Color.white);}
            gr.fillRect(x, y+5, 2, 1);
            gr.setColor(c);   gr.fillRect(x+2, y+5, 3, 1);
            gr.setColor(Color.white);
            gr.fillRect(x+5, y+5, 1, 1);
            gr.setColor(Color.blue); if(pp == true){gr.setColor(Color.white);}
            gr.fillRect(x+6, y+5, 2, 1);   
            gr.setColor(c);   gr.fillRect(x+8, y+5, 1, 8);     

            gr.setColor(c);   gr.fillRect(x-5, y+6, 5, 1);
            gr.setColor(Color.white);
            gr.fillRect(x, y+6, 2, 1);
            gr.setColor(c);   gr.fillRect(x+2, y+6, 4, 1);
            gr.setColor(Color.white);
            gr.fillRect(x+6, y+6, 2, 1);
        }
        if(xv<=0)
        {
            gr.setColor(Color.white);
            gr.fillRect(x-4, y+3, 2, 1);
            gr.setColor(c);
            gr.fillRect(x-2, y+3, 4, 1);
            gr.setColor(Color.white);   
            gr.fillRect(x+2, y+3, 2, 1);
            gr.setColor(c);            
            gr.fillRect(x+4, y+3, 3, 1);

            gr.setColor(Color.blue); if(pp == true){gr.setColor(Color.white);}
            gr.fillRect(x-4, y+4, 2, 2);
            gr.setColor(Color.white);
            gr.fillRect(x-2, y+4, 1, 2);
            gr.setColor(c);
            gr.fillRect(x-1, y+4, 4, 2);
            gr.setColor(Color.blue);   if(pp == true){gr.setColor(Color.white);}
            gr.fillRect(x+2, y+4, 2, 2);
            gr.setColor(Color.white);
            gr.fillRect(x+4, y+4, 1, 2);
            gr.setColor(c);            
            gr.fillRect(x+5, y+4, 3, 2);

            gr.setColor(Color.white);
            gr.fillRect(x-4, y+6, 2, 1);
            gr.setColor(c);
            gr.fillRect(x-2, y+6, 4, 1);
            gr.setColor(Color.white);   
            gr.fillRect(x+2, y+6, 2, 1);
            gr.setColor(c);            
            gr.fillRect(x+4, y+6, 4, 1);

            gr.setColor(c);   gr.fillRect(x-5, y+5, 1, 8);
            gr.setColor(c);   gr.fillRect(x+8, y+6, 1, 7);

        }

        gr.setColor(c);   gr.fillRect(x-5, y+7, 13, 4);        
        gr.setColor(c);   gr.fillRect(x-5, y+11, 1, 2);
        gr.setColor(c);   gr.fillRect(x-4, y+11, 1, 1);
        gr.setColor(c);   gr.fillRect(x-2, y+11, 1, 1);
        gr.setColor(c);   gr.fillRect(x-1, y+11, 2, 2);
        gr.setColor(c);   gr.fillRect(x+3, y+11, 2, 2);
        gr.setColor(c);   gr.fillRect(x+5, y+11, 1, 1);
        gr.setColor(c);   gr.fillRect(x+7, y+11, 1, 1);

    }

    public void move()
    {
        x += xv;    
        y += yv;    

        if(x<0)
            x=750;//600
        if(x>750)
            x=0;
        if(y<0)
            y=850;//700
        if(y>850)
            y=0;
        if(pp==false)
        {
            r.setLocation(x, y+5);
        }
           
        if(pp==true)
        {
            r2.setLocation(x, y+5);
        }
    }

    public void wallGhost()
    {
        ran1 = (int)(Math.random()*(100)+5);
        if(xv!=0)
        {
            x-=(xv*1.23);
            xv = 0;
            if(ran1%2==0)
            { 
                yv =7;}
            else
            {
                yv=-7;
            }
        }
        else
        {
            y-=(yv*1.23); 
            yv = 0;
            if(ran1%2==0)
            { xv = 7;}
            else
            {xv = -7;}
        }             
        if(pp==false)
        {
            r.setLocation(x, y+5);
        }           
        if(pp==true)
        {
            r2.setLocation(x, y+5);
        }     
    } 

    public void ppActive()
    {
        //r2.setLocation(x, y+5);
        r.setLocation(-1000, -1000);
        pp = true;
    }
    //

    public void center()
    {
        pp = false;
        //r.setLocation(x, y+5);
        r2.setLocation(-1000, -1000);
        x= 350;
        y=350;
    }
}

