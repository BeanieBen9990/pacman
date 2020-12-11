import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class powerCoin
{
    private Color c;
    private int x, y;
    private Rectangle r;
    private boolean visible;
    public powerCoin(int x, int y)
    {
        c = Color.yellow;
        this.x = x;
        this.y = y;
        visible = true;
        r = new Rectangle(x, y, 20, 20);
    }

    public Rectangle getR()
    {
        return r;
    }

    public void drawCoin(Graphics2D gr)
    {
        gr.setColor(c);
        if(visible)
            gr.fillOval(x, y, 20, 20);
    }

    public void eatCoin()
    {
        visible = false;
        r = new Rectangle(0,0,0,0);
    }
}
