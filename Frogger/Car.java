import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Car
{
    int cx, cy, cxVel, width, height;
    int lane, laneY1, laneY2, laneY3, laneY4;
    Random ran = new Random();
    boolean visible = true;
    Car v, v2, v3, v4, v5, v6, v7, v8;
    Image myCarPic;
    Rectangle carRect;
    int difficulty = 0, dif1 = 0;
    public Car(int vx, int vy, int inputLevel, Image car)
    {
       difficulty = inputLevel;
       dif1 = difficulty / 2;
       dif1 *= 3;
       dif1 += 2;
       cx = vx;
       cy = vy;
       myCarPic = car;
       cxVel = ran.nextInt(difficulty)+ dif1;
       width = 74;
       height = 35;
       carRect = new Rectangle(cx, cy, width, height);
    }
    public void draw(Graphics2D gr)
    {
       if(visible)
          gr.drawImage(myCarPic, cx, cy, null);
    }
    public void move()
    {
       cx += cxVel;
       if(cx > 500)
       {
          cxVel = ran.nextInt(difficulty)+ dif1;
          cx = -100;
       }
       carRect.setLocation(cx, cy);
    }
    public Rectangle getRect()
    {
       return carRect;
    }
}
