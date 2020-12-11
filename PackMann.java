import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class PackMann
{
    private Color c;
    private int x, y, arcAngle, xv, yv, mouth;
    private Rectangle r;
    private boolean movedBack;
    public PackMann(int x, int y)
    {
        c = Color.yellow;
        this.x = x;
        this.y = y;
        xv = 5;
        yv = 0;
        mouth = 6;
        arcAngle = 321;
        r = new Rectangle(x, y, 17, 17);
    }

    public Rectangle getR()
    {
        return r;
    }

    public void drawPacMan(Graphics2D gr)
    {
        gr.setColor(c);
        if(xv>0)
            gr.fillArc(x-2, y-2, 25, 25, 0, arcAngle);
        if(xv<0)
            gr.fillArc(x-2, y-2, 25, 25, 180, arcAngle);
        if(yv>0)
            gr.fillArc(x-2, y-2, 25, 25, 270, arcAngle);
        if(yv<0)
            gr.fillArc(x-2, y-2, 25, 25, 90, arcAngle);

        arcAngle += mouth;
        if(arcAngle >360 || arcAngle<320)
            mouth *= -1;
        this.movedBack = false;
    }

    public void move()
    {
        x += xv;
        y += yv;
        r.setLocation(x, y);
    }

    public void moveUp(){
        xv = 0;
        yv = -5;
    }

    public void moveDown(){
        xv = 0;
        yv = 5;
    }

    public void moveLeft(){
        xv = -5;
        yv = 0;
    }

    public void moveRight(){
        xv = 5;
        yv = 0;
    }
    public void moveBack() {
        x -= xv;
        y -= yv;
        this.movedBack = true;
    }
    public boolean didMoveBack() {
        return this.movedBack;
    }
    public void wrapAround() {
        //for whole screen wrap around
        //x = 750 - x
        //for partial screen wrap around
        x = (720 - x)+20;
        
        //NOTE: uncommented line here must match line in Pacmanage
    }
}
