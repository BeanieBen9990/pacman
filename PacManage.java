import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class PacManage extends JFrame implements Runnable, KeyListener
{
    //declare/instantiate global variables
    Container con = getContentPane();
    Thread t = new Thread(this);
    PackMann p;
    ArrayList<GoldCoin> coins = new ArrayList<GoldCoin>();
    ArrayList<Rectangle> barriers = new ArrayList<Rectangle>();
    ArrayList<Ghosts> ghosts = new ArrayList<Ghosts>();
    ArrayList<powerCoin> pellets = new ArrayList<powerCoin>();
    int coinCounter = 0; int score=0;
    double scale;

    //give names to common integers for comprehension
    int xOffset = 25;
    int yOffset = 50;
    int coinOffset = 7;
    int pelletOffset = 2;
    int ghostOffset = 0;
    int gridMultiplier = 25;

    public PacManage()
    {
        //add pacman
        p = new PackMann(((13)*gridMultiplier)+xOffset, ((23)*gridMultiplier)+yOffset);
        //
        //add ghost objects
        //please add ghosts with fitting size and position, as determined by the below instantiation */
        ghosts.add(new Ghosts(((11)*gridMultiplier)+xOffset, ((11)*gridMultiplier)+yOffset));//(300,325) The working ghost
        ghosts.add(new Ghosts(((3)*gridMultiplier)+xOffset, ((2)*gridMultiplier)+yOffset));//(100,100)
        ghosts.add(new Ghosts(((3)*gridMultiplier)+xOffset,((2)*gridMultiplier)+yOffset));
        ghosts.add(new Ghosts(((15)*gridMultiplier)+xOffset,((14)*gridMultiplier)+yOffset));//(400,400)       
        ghosts.add(new Ghosts(((15)*gridMultiplier)+xOffset,((14)*gridMultiplier)+yOffset));

        //add power pellet objects
        pellets.add(new powerCoin(((1)*gridMultiplier)+xOffset+pelletOffset,  ((4)*gridMultiplier)+xOffset+pelletOffset));
        pellets.add(new powerCoin(((1)*gridMultiplier)+xOffset+pelletOffset,  ((23)*gridMultiplier)+xOffset+pelletOffset));
        pellets.add(new powerCoin(((26)*gridMultiplier)+xOffset+pelletOffset, ((4)*gridMultiplier)+xOffset+pelletOffset));
        pellets.add(new powerCoin(((26)*gridMultiplier)+xOffset+pelletOffset, ((23)*gridMultiplier)+xOffset+pelletOffset));

        //add coin objects
        for (int i = 1; i <= 12; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((1)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 8; i++) {
            coins.add(new GoldCoin(((1)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 25; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((5)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 4; i++) {
            coins.add(new GoldCoin(((6)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 5; i++) {
            coins.add(new GoldCoin(((12)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 5; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((8)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 15; i <= 26; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((1)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 8; i++) {
            coins.add(new GoldCoin(((26)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 4; i++) {
            coins.add(new GoldCoin(((15)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 4; i++) {
            coins.add(new GoldCoin(((21)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 22; i <= 26; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((8)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 6; i <= 26; i++) {
            coins.add(new GoldCoin(((6)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 6; i <= 26; i++) {
            coins.add(new GoldCoin(((21)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 6; i <= 8; i++) {
            coins.add(new GoldCoin(((9)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 6; i <= 8; i++) {
            coins.add(new GoldCoin(((18)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 10; i <= 12; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((8)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 15; i <= 17; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((8)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 25; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((29)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 26; i <= 29; i++) {
            coins.add(new GoldCoin(((1)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 26; i <= 29; i++) {
            coins.add(new GoldCoin(((26)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 1; i <= 5; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((20)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 7; i <= 12; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((20)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 15; i <= 20; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((20)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 22; i <= 26; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((20)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 21; i <= 23; i++) {
            coins.add(new GoldCoin(((1)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 21; i <= 23; i++) {
            coins.add(new GoldCoin(((26)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 2; i <= 5; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((26)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 22; i <= 25; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((26)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 7; i <= 12; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((23)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 15; i <= 20; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((23)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 23; i <= 25; i++) {
            coins.add(new GoldCoin(((3)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 23; i <= 25; i++) {
            coins.add(new GoldCoin(((24)*gridMultiplier)+xOffset+coinOffset, ((i)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 9; i <= 12; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((26)*gridMultiplier)+yOffset+coinOffset));
        }
        for (int i = 15; i <= 18; i++) {
            coins.add(new GoldCoin(((i)*gridMultiplier)+xOffset+coinOffset, ((26)*gridMultiplier)+yOffset+coinOffset));
        }
        coins.add(new GoldCoin(((2)*gridMultiplier)+xOffset+coinOffset, ((23)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((25)*gridMultiplier)+xOffset+coinOffset, ((23)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((9)*gridMultiplier)+xOffset+coinOffset, ((24)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((9)*gridMultiplier)+xOffset+coinOffset, ((25)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((18)*gridMultiplier)+xOffset+coinOffset, ((24)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((18)*gridMultiplier)+xOffset+coinOffset, ((25)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((12)*gridMultiplier)+xOffset+coinOffset, ((21)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((12)*gridMultiplier)+xOffset+coinOffset, ((22)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((12)*gridMultiplier)+xOffset+coinOffset, ((27)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((12)*gridMultiplier)+xOffset+coinOffset, ((28)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((15)*gridMultiplier)+xOffset+coinOffset, ((21)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((15)*gridMultiplier)+xOffset+coinOffset, ((22)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((15)*gridMultiplier)+xOffset+coinOffset, ((27)*gridMultiplier)+yOffset+coinOffset));
        coins.add(new GoldCoin(((15)*gridMultiplier)+xOffset+coinOffset, ((28)*gridMultiplier)+yOffset+coinOffset));

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

                //move all ghosts and pacman
                p.move();
                if (p.getR().getX() < 20/*0*/ || p.getR().getX() > 720 /*750*/) { //Uncomment integers that match with line in p.wrapAround()
                    p.wrapAround();
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
                        if(ghosts.get(y).getR2().intersects(barriers.get(x))) 
                        {
                            ghosts.get(y).wallGhost();
                        }
                    }
                }

                //check collision with pacman and coin/pellet
                for(int x = 0; x < coins.size(); x++) {
                    if(p.getR().intersects(coins.get(x).getR())) {
                        coins.get(x).eatCoin();
                        coinCounter++;
                        if (coinCounter == coins.size()) { //THIS SHOULD BE 240 COINS FIX LATER
                            System.exit(0);
                        }
                    }
                }

                for(int x = 0; x < pellets.size(); x++) {
                    for(int y = 0; y < ghosts.size(); y++) 
                    {
                        if(p.getR().intersects(pellets.get(x).getR())) 
                        {
                            pellets.get(x).eatCoin();
                            ghosts.get(y).ppActive();
                        }
                    }
                }
                for(int y = 0; y < ghosts.size(); y++) 
                {
                    if(p.getR().intersects(ghosts.get(y).getR2()))
                    {
                        score+=100;
                        ghosts.get(y).center();
                    }                
                }

                //check collision with pacman/ghosts and barrier 
                for(int x = 0; x < barriers.size(); x++) {
                    if(p.getR().intersects(barriers.get(x)) && !p.didMoveBack()) {
                        p.moveBack();
                    }
                }
                if (p.getR().getX() < 0 || p.getR().getX() > 750) {
                    for(int x = 0; x < barriers.size(); x++) {
                        for(int y = 0; y < ghosts.size(); y++) {
                            if(ghosts.get(y).getR().intersects(barriers.get(x))) 
                            {
                                ghosts.get(y).wallGhost();
                            }
                            if(ghosts.get(y).getR2().intersects(barriers.get(x))) 
                            {
                                ghosts.get(y).wallGhost();
                            }
                        }
                    }
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
        painter.fillRect(0, 0, 750, 850);

        //draw coins
        for(int x = 0; x < coins.size(); x++)
        {
            coins.get(x).drawCoin(painter);
        }

        //draw barriers
        painter.setColor(Color.blue);
        painter.setStroke(new BasicStroke(4));
        for(int x = 0; x < barriers.size(); x++)
        {
            painter.draw(barriers.get(x));
        }

        //draw ghosts
        for(int x = 0; x < ghosts.size(); x++)
        {           
            ghosts.get(x).drawGhosts(painter);       
        }

        //draw pellets
        for(int x = 0; x < pellets.size(); x++) {
            pellets.get(x).drawCoin(painter);
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

    public void keyPressed(KeyEvent k){}

    public void keyTyped(KeyEvent k){}

}
