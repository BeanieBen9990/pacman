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
    int xOffset = 25;
    int yOffset = 50;
    int coinOffset = 7;
    int ghostOffset = 0;
    int gridMultiplier = 25;
    double scale;
    public PacManage()
    {
        p = new PackMann(((13)*gridMultiplier)+xOffset, ((17)*gridMultiplier)+yOffset);
        //add ghost objects
        //please add ghosts with fitting size and position, as determined by the below instantiation */

        ghosts.add(new Ghosts(((11)*gridMultiplier)+xOffset, ((11)*gridMultiplier)+yOffset));
        ghosts.add(new Ghosts(100,100));
        ghosts.add(new Ghosts(400,400));
        ghosts.add(new Ghosts(100,100));
        ghosts.add(new Ghosts(400,400));

        for (int i = 2; i <= 8; i++) {
            coins.add(new GoldCoin(((1)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 25; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((5)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 4; i++) {
            coins.add(new GoldCoin(((6)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }

        // add barrier objects
        barriers.add(new Rectangle(((0)*gridMultiplier)+xOffset,  ((0)*gridMultiplier)+yOffset,  (28)*gridMultiplier, (1)*gridMultiplier));
        barriers.add(new Rectangle(((0)*gridMultiplier)+xOffset,  ((0)*gridMultiplier)+yOffset,  (1)*gridMultiplier,  (10)*gridMultiplier));
        barriers.add(new Rectangle(((27)*gridMultiplier)+xOffset, ((0)*gridMultiplier)+yOffset,  (1)*gridMultiplier,  (10)*gridMultiplier));
        barriers.add(new Rectangle(((13)*gridMultiplier)+xOffset, ((0)*gridMultiplier)+yOffset,  (2)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((2)*gridMultiplier)+xOffset,  ((2)*gridMultiplier)+yOffset,  (4)*gridMultiplier,  (3)*gridMultiplier));
        barriers.add(new Rectangle(((7)*gridMultiplier)+xOffset,  ((2)*gridMultiplier)+yOffset,  (5)*gridMultiplier,  (3)*gridMultiplier));
        barriers.add(new Rectangle(((16)*gridMultiplier)+xOffset, ((2)*gridMultiplier)+yOffset,  (5)*gridMultiplier,  (3)*gridMultiplier));
        barriers.add(new Rectangle(((22)*gridMultiplier)+xOffset, ((2)*gridMultiplier)+yOffset,  (4)*gridMultiplier,  (3)*gridMultiplier));
        barriers.add(new Rectangle(((2)*gridMultiplier)+xOffset,  ((6)*gridMultiplier)+yOffset,  (4)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((22)*gridMultiplier)+xOffset, ((6)*gridMultiplier)+yOffset,  (4)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((7)*gridMultiplier)+xOffset,  ((6)*gridMultiplier)+yOffset,  (2)*gridMultiplier,  (8)*gridMultiplier));
        barriers.add(new Rectangle(((7)*gridMultiplier)+xOffset,  ((9)*gridMultiplier)+yOffset,  (5)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((19)*gridMultiplier)+xOffset, ((6)*gridMultiplier)+yOffset,  (2)*gridMultiplier,  (8)*gridMultiplier));
        barriers.add(new Rectangle(((16)*gridMultiplier)+xOffset, ((9)*gridMultiplier)+yOffset,  (5)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((10)*gridMultiplier)+xOffset, ((6)*gridMultiplier)+yOffset,  (8)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((13)*gridMultiplier)+xOffset, ((6)*gridMultiplier)+yOffset,  (2)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((0)*gridMultiplier)+xOffset,  ((9)*gridMultiplier)+yOffset,  (6)*gridMultiplier,  (1)*gridMultiplier));
        barriers.add(new Rectangle(((5)*gridMultiplier)+xOffset,  ((9)*gridMultiplier)+yOffset,  (1)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((0)*gridMultiplier)+xOffset,  ((13)*gridMultiplier)+yOffset, (6)*gridMultiplier,  (1)*gridMultiplier));
        barriers.add(new Rectangle(((7)*gridMultiplier)+xOffset,  ((15)*gridMultiplier)+yOffset, (2)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((19)*gridMultiplier)+xOffset, ((15)*gridMultiplier)+yOffset, (2)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((22)*gridMultiplier)+xOffset, ((9)*gridMultiplier)+yOffset,  (6)*gridMultiplier,  (1)*gridMultiplier));
        barriers.add(new Rectangle(((22)*gridMultiplier)+xOffset, ((9)*gridMultiplier)+yOffset,  (1)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((22)*gridMultiplier)+xOffset, ((13)*gridMultiplier)+yOffset, (6)*gridMultiplier,  (1)*gridMultiplier));
        barriers.add(new Rectangle(((10)*gridMultiplier)+xOffset, ((12)*gridMultiplier)+yOffset, (8)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((10)*gridMultiplier)+xOffset, ((18)*gridMultiplier)+yOffset, (8)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((13)*gridMultiplier)+xOffset, ((18)*gridMultiplier)+yOffset, (2)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((0)*gridMultiplier)+xOffset,  ((15)*gridMultiplier)+yOffset, (6)*gridMultiplier,  (1)*gridMultiplier));
        barriers.add(new Rectangle(((5)*gridMultiplier)+xOffset,  ((15)*gridMultiplier)+yOffset, (1)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((0)*gridMultiplier)+xOffset,  ((19)*gridMultiplier)+yOffset, (6)*gridMultiplier,  (1)*gridMultiplier));
        barriers.add(new Rectangle(((0)*gridMultiplier)+xOffset,  ((19)*gridMultiplier)+yOffset, (1)*gridMultiplier,  (12)*gridMultiplier));
        barriers.add(new Rectangle(((22)*gridMultiplier)+xOffset, ((15)*gridMultiplier)+yOffset, (6)*gridMultiplier,  (1)*gridMultiplier));
        barriers.add(new Rectangle(((22)*gridMultiplier)+xOffset, ((15)*gridMultiplier)+yOffset, (1)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((22)*gridMultiplier)+xOffset, ((19)*gridMultiplier)+yOffset, (6)*gridMultiplier,  (1)*gridMultiplier));
        barriers.add(new Rectangle(((27)*gridMultiplier)+xOffset, ((19)*gridMultiplier)+yOffset, (1)*gridMultiplier,  (12)*gridMultiplier));
        barriers.add(new Rectangle(((0)*gridMultiplier)+xOffset,  ((30)*gridMultiplier)+yOffset, (28)*gridMultiplier, (1)*gridMultiplier));
        barriers.add(new Rectangle(((2)*gridMultiplier)+xOffset,  ((21)*gridMultiplier)+yOffset, (4)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((4)*gridMultiplier)+xOffset,  ((21)*gridMultiplier)+yOffset, (2)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((7)*gridMultiplier)+xOffset,  ((21)*gridMultiplier)+yOffset, (5)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((0)*gridMultiplier)+xOffset,  ((24)*gridMultiplier)+yOffset, (3)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((16)*gridMultiplier)+xOffset, ((21)*gridMultiplier)+yOffset, (5)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((22)*gridMultiplier)+xOffset, ((21)*gridMultiplier)+yOffset, (4)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((22)*gridMultiplier)+xOffset, ((21)*gridMultiplier)+yOffset, (2)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((25)*gridMultiplier)+xOffset, ((24)*gridMultiplier)+yOffset, (3)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((10)*gridMultiplier)+xOffset, ((24)*gridMultiplier)+yOffset, (8)*gridMultiplier,  (2)*gridMultiplier));
        barriers.add(new Rectangle(((13)*gridMultiplier)+xOffset, ((24)*gridMultiplier)+yOffset, (2)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((7)*gridMultiplier)+xOffset,  ((24)*gridMultiplier)+yOffset, (2)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((2)*gridMultiplier)+xOffset,  ((27)*gridMultiplier)+yOffset, (10)*gridMultiplier, (2)*gridMultiplier));
        barriers.add(new Rectangle(((19)*gridMultiplier)+xOffset,  ((24)*gridMultiplier)+yOffset, (2)*gridMultiplier,  (5)*gridMultiplier));
        barriers.add(new Rectangle(((16)*gridMultiplier)+xOffset,  ((27)*gridMultiplier)+yOffset, (10)*gridMultiplier, (2)*gridMultiplier));

        scale = .5; 
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
                for(int x = 0; x < coins.size(); x++) {
                    if(p.getR().intersects(coins.get(x).getR())) {
                        coins.get(x).eatCoin();
                    }
                }
                for(int x = 0; x < barriers.size(); x++) {
                    if(p.getR().intersects(barriers.get(x)) && !p.didMoveBack()) {
                        p.moveBack();
                    }
                }
                if (p.getR().getX() < 0 || p.getR().getX() > 750) {
                    for(int x = 0; x < barriers.size(); x++) {
                        for(int y = 0; y < ghosts.size(); y++) {
                            if(ghosts.get(y).getR().intersects(barriers.get(x))) {
                                ghosts.get(y).wallGhost();
                            }
                        }
                    }
                }

                for(int y = 0; y < ghosts.size(); y++) {
                    ghosts.get(y).move();
                }
                for(int y = 0; y < ghosts.size(); y++) {
                    if(ghosts.get(y).getR().intersects(p.getR())) {
                        System.exit(0);
                    }
                }
                for(int x = 0; x < barriers.size(); x++) {
                    for(int y = 0; y < ghosts.size(); y++) {
                        if(ghosts.get(y).getR().intersects(barriers.get(x))) 
                        {
                            ghosts.get(y).wallGhost();
                        }
                    }
                }

                if (p.getR().getX() < 0 || p.getR().getX() > 750) {
                    p.wrapAround();
                }
                //add for(int x = 0; x < coins.size(); x++) {if all the coins dissapeared, then System.exit(0);}
                repaint();

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /*
    public void addCoin(int xCells, int yCells) {
    for(int coin = 0; coin < coins.size(); coin++) { 
    if (!(coins.get(coin).equals(GoldCoin(((xCells)*gridMultiplier)+xOffset+coinOffset, ((yCells)*gridMultiplier)+yOffset+coinOffset)))) {
    coins.add(new GoldCoin(((xCells)*gridMultiplier)+xOffset+coinOffset, ((yCells)*gridMultiplier)+yOffset+coinOffset));
    }
    }
    }
     */

    public void paint(Graphics gr)
    {
        Image i=createImage(getSize().width, getSize().height);
        Graphics2D painter = (Graphics2D)i.getGraphics();
        painter.fillRect(0, 0, 750, 850);
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
        frame.setSize(750, 850);//determines size of screen
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
