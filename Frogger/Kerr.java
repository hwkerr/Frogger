import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Kerr extends JFrame implements Runnable, KeyListener//, MouseListener
{
    Container con = getContentPane();
    Thread t = new Thread(this);
    Frog frogger;
    Car v, v2, v3, v4, v5, v6, v7 ,v8;
    Image road, frog, frogGuts, car, gameOver, youWin, shadow;
    boolean restart = false, dead = false, win = false;
    String inputLevel = JOptionPane.showInputDialog("Choose your level of Difficulty from 1-15");
    int lvl = Integer.parseInt(inputLevel);
    public Kerr()
    {
       addKeyListener(this);
       //addMouseListener(this);
       road = Toolkit.getDefaultToolkit().getImage(getClass().getResource("road.png"));
       frog = Toolkit.getDefaultToolkit().getImage(getClass().getResource("frog.png"));
       frogGuts = Toolkit.getDefaultToolkit().getImage(getClass().getResource("frogGuts.png"));
       car = Toolkit.getDefaultToolkit().getImage(getClass().getResource("car.png"));
       gameOver = Toolkit.getDefaultToolkit().getImage(getClass().getResource("gameOverText.png"));
       youWin = Toolkit.getDefaultToolkit().getImage(getClass().getResource("youWinText.png"));
       shadow = Toolkit.getDefaultToolkit().getImage(getClass().getResource("darkLayer.png"));
       frogger = new Frog(frog, frogGuts);
       if(lvl > 15)
          lvl = 15;
       if(lvl < 1)
          lvl = 1;
       v = new Car(450, 325, lvl, car);
       v2 = new Car(10, 239, lvl,  car);
       v3 = new Car(80, 158, lvl,  car);
       v4 = new Car(370, 72, lvl,  car);
       v5 = new Car(255, 340, lvl,  car);
       v6 = new Car(480, 254, lvl,  car);
       v7 = new Car(290, 173, lvl,  car);
       v8 = new Car(200, 87, lvl,  car);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       t.start();
    }
    public void run()
    {
    try{
        while(true)
        {
           t.sleep(100);
           if(!restart)
           {
              v.move();
              v2.move();
              v3.move();
              v4.move();
              v5.move();
              v6.move();
              v7.move();
              v8.move();
           }
           if(frogger.getRect().intersects(v.getRect()))
              dead = true;
           if(frogger.getRect().intersects(v2.getRect()))
              dead = true;
           if(frogger.getRect().intersects(v3.getRect()))
              dead = true;
           if(frogger.getRect().intersects(v4.getRect()))
              dead = true;
           if(frogger.getRect().intersects(v5.getRect()))
              dead = true;
           if(frogger.getRect().intersects(v6.getRect()))
              dead = true;
           if(frogger.getRect().intersects(v7.getRect()))
              dead = true;
           if(frogger.getRect().intersects(v8.getRect()))
              dead = true;
           if(dead || frogger.getWin())
              restart = true;
           repaint();
        }
    }
    catch(Exception e){}
    }
    public void update(Graphics g)
    {
        paint(g);
    } 
    public void paint(Graphics gr)
    {
       Image i=createImage(getSize().width, getSize().height);
       Graphics2D g2 = (Graphics2D)i.getGraphics();  
       if (!restart)
       {
          g2.drawImage(road, 0, 0, this);
          frogger.draw(g2);
          v.draw(g2);
          v2.draw(g2);
          v3.draw(g2);
          v4.draw(g2);
          v5.draw(g2);
          v6.draw(g2);
          v7.draw(g2);
          v8.draw(g2);
       }
       else
       {
          g2.drawImage(road, 0, 0, this);
          frogger.draw(g2);
          v.draw(g2);
          v2.draw(g2);
          v3.draw(g2);
          v4.draw(g2);
          v5.draw(g2);
          v6.draw(g2);
          v7.draw(g2);
          v8.draw(g2);
          if (dead)
          {
             g2.drawImage(shadow, 0, 0, this);
             g2.drawImage(gameOver, 70, 182, this);
             g2.setColor(Color.WHITE);
             g2.drawString("Press the Spacebar to Continue", 160, 380);
          }
          else if (frogger.getWin())
             {
             g2.drawImage(youWin, 102, 146, this);
             g2.setColor(Color.WHITE);
             g2.drawString("Press the Spacebar to Continue", 160, 380);
             }
       }
       g2.dispose();
       gr.drawImage(i, 0, 0, this);
    }
    public static void main(String[] args)
    {
       Kerr frame = new Kerr();
       frame.setSize(500, 500);
       frame.setVisible(true);
    }
    public void keyReleased(KeyEvent keyz)
    {}
    public void keyTyped(KeyEvent keyz)
    {}
    public void keyPressed(KeyEvent keyz)
    {
       if(!restart)
       {
          if(keyz.getKeyCode() == 37)//left
             frogger.moveLeft();
          if(keyz.getKeyCode() == 39)//right
             frogger.moveRight();
          if(keyz.getKeyCode() == 40)//down
             frogger.moveDown();
          if(keyz.getKeyCode() == 38)//up
             frogger.moveUp();
       }
       if(keyz.getKeyCode() == 32)//spacebar
       {
          frogger = new Frog(frog, frogGuts);
          if(lvl > 15)
             lvl = 15;
          if(lvl < 1)
             lvl = 1;
          v = new Car(450, 325, lvl, car);
          v2 = new Car(10, 239, lvl,  car);
          v3 = new Car(80, 158, lvl,  car);
          v4 = new Car(370, 72, lvl,  car);
          v5 = new Car(255, 340, lvl,  car);
          v6 = new Car(480, 254, lvl,  car);
          v7 = new Car(290, 173, lvl,  car);
          v8 = new Car(200, 87, lvl,  car);
          dead = false;
          restart = false;
       }
    }
}
