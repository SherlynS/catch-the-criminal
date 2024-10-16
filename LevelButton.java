import java.awt.*;
public class LevelButton {
        public int xPos;
        public int yPos;
        public int halfwidth;
        public int halfheight;
        public Color color;

        public LevelButton(int x, int y, int w, int h, Color c){
            xPos = x;
            yPos = y;
            halfwidth = w;
            halfheight = h;
            color = c;
        }

        public void setColor(Color colorrr){
            color = colorrr;
            drawLevelButton();
        }

        public void drawLevelButton(){
            StdDraw.setPenRadius(20);
            StdDraw.setPenColor(color);
            StdDraw.filledRectangle(5, 5, halfwidth, halfheight);
            StdDraw.setPenColor(new Color(0,0,0));
            StdDraw.text(5, 5, "NEXT LEVEL");

        }

    }


