int x;
int y;
boolean directed = false;
int WIDTH = 640;
int HEIGHT = 640;
int j;

color[] blues = {#256CA6, #1C87BD, #99AABB};
color[] primaries = {#BBBB44, #BB8966, #99AABB};
color[] pinks = {#FFBBCC, #BB8888, #880000, #FFEEEE};
color[] wintry = {#B3E3F4, #D6FFFB, #E3E3FF};
color[] autumnal = {#A32A2A, #D4851C, #D83000, #AE700A, #FF6804};
color[] uchicago = {#770026, #770026, #7B7672, #C5C4C2, #537D95, #3A222F};

color[] colors = blues;

void setup()
{
 size(WIDTH,HEIGHT); 
 x = WIDTH/2;
 y = HEIGHT/2;
 background(color(255,255,255));
 frameRate(1000);
 j=20;
}

void draw()
{
  int r = 0;
  if (directed) {
   r = int(random(0,5));
  } else {
   r = int(random(0,4));
  }
 if (r >= 4)
 {
   if (mouseX == 0 && mouseY == 0) {
     r = int(random(0,4));
   } else {
       if (mouseX > x) {
         if (mouseY > y) {
           r = int(random(1,3));
         } else {
           r = int(random(0,2));
         }
       } else {
         if (mouseY > y) {
           r = int(random(2,4));
         } else {
           r = int(random(3,5));
         }
       }
   }
   print(r);
 }
 move(r);
 int choice = int(random(colors.length));
 stroke(colors[choice]);
 fill(colors[choice]);
 rect(x,y, j/2,j/2);
}

void move(int rand)
{
  if (rand == 0)
 {
   if (y <= j-1)
   {
    move(int(random(4)));
   }
   else
   y-=j;
 }
 if (rand == 1)
 {
   if (x >= WIDTH-j)
   {
    move(int(random(4))); 
   }
   else
   x+=j;
 }
 if (rand == 2)
 {
   if (y >= HEIGHT-j)
   {
    move(int(random(4))); 
   }
   else
   y+=j;
 }
 if (rand == 3)
 {
   if (x <= j-1)
   {
    move(int(random(4))); 
   }
   else
   x-=j;
 }
}
