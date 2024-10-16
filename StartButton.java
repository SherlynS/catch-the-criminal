import java.awt.*;
public class StartButton {
        public int xPos;
        public int yPos;
        public int halfwidth;
        public int halfheight;
        public Color color;

        public StartButton(int x, int y, int w, int h, Color c){
            xPos = x;
            yPos = y;
            halfwidth = w;
            halfheight = h;
            color = c;
        }

        public void setColor(Color colorrr){
            color = colorrr;
            drawStartButton();
        }

        public void drawStartButton(){
            StdDraw.setPenRadius(20);
            StdDraw.setPenColor(color);
            StdDraw.picture(2,6,"Clouds.png",18,10);
            StdDraw.filledRectangle(5, 5, halfwidth, halfheight);
            StdDraw.setPenColor(new Color(0,0,0));
            StdDraw.text(5, 5.3, "LOOK AT THE TOP OF THE PAGE ");
            StdDraw.text(5, 4.9, "TO FIGURE OUT WHO TO FIND");

        }

    }


