<<<<<<< HEAD
//Testing
=======
/* ioweuhwioeufhowefuhweofuh */
>>>>>>> 8f664d920084ca7d3e8745988c995e7c57f27ef9
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class PacManage extends JFrame implements Runnable, KeyListener
{
    Container con = getContentPane();
    Thread t = new Thread(this);
    PackMann p;
    ArrayList<GoldCoin> coins = new ArrayList<GoldCoin>();
    ArrayList<Rectangle> barriers = new ArrayList<Rectangle>();
    ArrayList<Ghosts> ghosts = new ArrayList<Ghosts>();
    public PacManage()
    {
        p = new PackMann(400, 400);
        ghosts.add(new Ghosts(100,100));
        coins.add(new GoldCoin(70, 70));
        coins.add(new GoldCoin(100, 70));
        coins.add(new GoldCoin(130, 70));
        coins.add(new GoldCoin(160, 70));
        coins.add(new GoldCoin(190, 70));
        coins.add(new GoldCoin(220, 70));
        coins.add(new GoldCoin(250, 70));
        coins.add(new GoldCoin(280, 70));
        coins.add(new GoldCoin(310, 70));
        coins.add(new GoldCoin(340, 70));
        coins.add(new GoldCoin(370, 70));
        coins.add(new GoldCoin(400, 70));
        coins.add(new GoldCoin(430, 70));
        coins.add(new GoldCoin(460, 70));
        coins.add(new GoldCoin(490, 70));
        coins.add(new GoldCoin(520, 70));
        coins.add(new GoldCoin(520, 100));
        coins.add(new GoldCoin(520, 130));
        coins.add(new GoldCoin(520, 160));
        coins.add(new GoldCoin(520, 190));
        coins.add(new GoldCoin(520, 220));
        coins.add(new GoldCoin(520, 250));
        coins.add(new GoldCoin(70, 100));
        coins.add(new GoldCoin(70, 130));
        coins.add(new GoldCoin(70, 160));
        coins.add(new GoldCoin(70, 190));
        coins.add(new GoldCoin(70, 220));
        coins.add(new GoldCoin(70, 250));
        
        barriers.add(new Rectangle(0,  0, 700, 25));
        barriers.add(new Rectangle(0,  0, 25,  250));
        barriers.add(new Rectangle(700,0, 700, 25));
        
        con.setLayout(new FlowLayout());
        addKeyListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.start();
    }

    public void run()
    {
        try{
            while(true)
            {
                t.sleep(33);//Smaller number == faster, larger == slower
                p.move();
                for(int x = 0; x < coins.size(); x++)
                {
                    if(p.getR().intersects(coins.get(x).getR()))
                    {
                        coins.get(x).eatCoin();
                    }
                }
                for(int x = 0; x < barriers.size(); x++) {
                    if(p.getR().intersects(barriers.get(x))) {
                        p.moveBack();
                    }
                }
                if (p.getR().getX() < 0 || p.getR().getX() > 600) {
                    p.wrapAround();
                }
                repaint();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void paint(Graphics gr)
    {
        Image i=createImage(getSize().width, getSize().height);
        Graphics2D painter = (Graphics2D)i.getGraphics();
        painter.fillRect(0, 0, 600, 700);
        for(int x = 0; x < coins.size(); x++)
        {
            coins.get(x).drawCoin(painter);
        }
        painter.setColor(Color.blue);
        painter.setStroke(new BasicStroke(4));
        for(int x = 0; x < barriers.size(); x++)
        {
            painter.draw(barriers.get(x));
        }

        for(int x = 0; x < ghosts.size(); x++)
        {           
            ghosts.get(x).drawGhosts(painter);       
        }    
        
        p.drawPacMan(painter);
        painter.dispose();
        gr.drawImage(i, 0, 0, this);
    }

    public static void main(String[] args)
    {
        PacManage frame = new PacManage();
        frame.setSize(600, 700);//determines size of screen
        frame.setVisible(true);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void keyPressed(KeyEvent k){}

    public void keyReleased(KeyEvent k){
        if(k.getKeyCode() == 37){
            p.moveLeft();
        }
        if(k.getKeyCode() == 38){
            p.moveUp();
        }
        if(k.getKeyCode() == 39){
            p.moveRight();
        }
        if(k.getKeyCode() == 40){
            p.moveDown();
        }
    }

    public void keyTyped(KeyEvent k){}
}
