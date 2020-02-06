import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frog
{
   int fx, fy, size;
   boolean dead = false, win = false;
   Frog frogger;
   Image myFrogPic, myDeadFrog;
   Rectangle frogRect;
   public Frog(Image frog, Image frogGuts)
   {
      fx = 225;
      fy = 420;
      myFrogPic = frog;
      myDeadFrog = frogGuts;
      frogRect = new Rectangle(fx, fy, 50, 54);
   }
   public void draw(Graphics2D gr)
   {
      if(!dead)
         gr.drawImage(myFrogPic, fx, fy, null);
      else if(dead)
         gr.drawImage(myDeadFrog, fx, fy, null);
   }
   public void moveLeft()
   {
      int left = 0;
      if (fx > left)
      fx -= 43;
      frogRect.setLocation(fx, fy);
   }
   public void moveRight()
   {
      int right = 500 - 50;
      if (fx < right)
      fx += 43;
      frogRect.setLocation(fx, fy);
   }
   public void moveUp()
   {
      int top = 0;
      if (fy > top)
      fy -= 86;
      if (fy < 20)
      win = true;
      frogRect.setLocation(fx, fy);
   }
   public void moveDown()
   {
      int bottom = 500 - 54;
      if (fy < bottom)
      fy += 86;
      frogRect.setLocation(fx, fy);
   }
   public Rectangle getRect()
   {
      return frogRect;
   }
   public Image getImage()
   {
      return myFrogPic;
   }
   public boolean getDead()
   {
      return dead;
   }
   public boolean getWin()
   {
      return win;
   }
}
