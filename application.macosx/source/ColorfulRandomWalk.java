import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ColorfulRandomWalk extends PApplet {

int x;
int y;
boolean directed = false;
int WIDTH = 640;
int HEIGHT = 640;
int j;

int[] blues = {0xff256CA6, 0xff1C87BD, 0xff99AABB};
int[] primaries = {0xffBBBB44, 0xffBB8966, 0xff99AABB};
int[] pinks = {0xffFFBBCC, 0xffBB8888, 0xff880000, 0xffFFEEEE};
int[] wintry = {0xffB3E3F4, 0xffD6FFFB, 0xffE3E3FF};
int[] autumnal = {0xffA32A2A, 0xffD4851C, 0xffD83000, 0xffAE700A, 0xffFF6804};
int[] uchicago = {0xff770026, 0xff770026, 0xff7B7672, 0xffC5C4C2, 0xff537D95, 0xff3A222F};

int[] colors = blues;

public void setup()
{
 size(WIDTH,HEIGHT); 
 x = WIDTH/2;
 y = HEIGHT/2;
 background(color(255,255,255));
 frameRate(1000);
 j=20;
}

public void draw()
{
  int r = 0;
  if (directed) {
   r = PApplet.parseInt(random(0,5));
  } else {
   r = PApplet.parseInt(random(0,4));
  }
 if (r >= 4)
 {
   if (mouseX == 0 && mouseY == 0) {
     r = PApplet.parseInt(random(0,4));
   } else {
       if (mouseX > x) {
         if (mouseY > y) {
           r = PApplet.parseInt(random(1,3));
         } else {
           r = PApplet.parseInt(random(0,2));
         }
       } else {
         if (mouseY > y) {
           r = PApplet.parseInt(random(2,4));
         } else {
           r = PApplet.parseInt(random(3,5));
         }
       }
   }
   print(r);
 }
 move(r);
 int choice = PApplet.parseInt(random(colors.length));
 stroke(colors[choice]);
 fill(colors[choice]);
 rect(x,y, j/2,j/2);
}

public void move(int rand)
{
  if (rand == 0)
 {
   if (y <= j-1)
   {
    move(PApplet.parseInt(random(4)));
   }
   else
   y-=j;
 }
 if (rand == 1)
 {
   if (x >= WIDTH-j)
   {
    move(PApplet.parseInt(random(4))); 
   }
   else
   x+=j;
 }
 if (rand == 2)
 {
   if (y >= HEIGHT-j)
   {
    move(PApplet.parseInt(random(4))); 
   }
   else
   y+=j;
 }
 if (rand == 3)
 {
   if (x <= j-1)
   {
    move(PApplet.parseInt(random(4))); 
   }
   else
   x-=j;
 }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ColorfulRandomWalk" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
