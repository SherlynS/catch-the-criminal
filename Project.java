import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;

public class Project {
    private World world;
    public boolean found;
    static Timer timer;
    static Timer timer2;
    static Timer timer3;
    static int second;
    public boolean startClicked;
    public boolean levelClicked;
    public boolean yoshiFound;


    public boolean mushroomFound;

    public Project() {
        world = new World(100,100);
        second = 0;
    }

    //MAIN BUTTON

    public static void main(String[] args) {
        String guess = "";
        System.out.println("Welcome to !Wanted");
        System.out.print("What would you want your gamer name to be?");
        guess = StdIn.readString();
        System.out.print("Gamer Tag: " + guess);

        /// set up canvas + pen
        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);
        StdDraw.enableDoubleBuffering();

        Project game = new Project();

        Font font1 = new Font("Georgia", Font.BOLD, 17);
        Font font2 = new Font("Impact", Font.BOLD, 15);
        StdDraw.picture(2,6,"Clouds.png");


        StdAudio.playInBackground("Music.wav");


        ///INTRO SCREEN


        while(!StdDraw.isMousePressed()){
            game.startClicked = false;
            StdDraw.setPenColor(new Color(95,192,255));
            StdDraw.filledSquare(5, 5, 5);
            StdDraw.setPenColor(Color.black);
            StdDraw.setFont(font1);
            StdDraw.text(5, 7.5, "!WANTED");
            StdDraw.text(5, 6.8, "Press BELOW to begin!");
            StdDraw.setFont(font2);
            StdDraw.setPenColor(new Color(117, 16, 16));
            StdDraw.text(8.5, 9.7, "Gamer tag: "+ guess);
            StdDraw.setFont(font1);

            //BUTTON Process
            StartButton start = new StartButton(5, 5, 3, 1, new Color(252,175,155));
            start.drawStartButton();
            StdDraw.show();
            if (StdDraw.mouseY() > start.yPos - start.halfheight && StdDraw.mouseY() < start.yPos + start.halfheight &&
                    StdDraw.mouseX() > start.xPos - start.halfwidth && StdDraw.mouseX() < start.xPos + start.halfwidth) {
                start.setColor(new Color(167,255,149));
                start.drawStartButton();
                StdDraw.show();
                StdDraw.pause(20);
            }
        }





        ///NEW TIMER1
        timer = new Timer();
        RemindTask remind = new RemindTask(timer);
        long startTime = System.currentTimeMillis();

        StdDraw.setFont(font2);
        StdDraw.setPenColor(new Color(117, 16, 16));
        StdDraw.text(8.5, 9.7, "Gamer tag: "+ guess);
        StdDraw.setFont(font1);



        ///WHEN WARIO & LUIGI ARE DISPLAYED
        while(StdDraw.isMousePressed()) {

            while (!game.found) {
                StdDraw.clear(new Color(20, 16, 50));
                StdDraw.setFont(font2);
                StdDraw.setPenColor(new Color(228, 241, 45));
                StdDraw.text(8.5, 9.7, "Gamer tag: "+ guess);
                StdDraw.setFont(font1);
                game.world.drawWario();
                game.world.moveWario();
                game.world.drawLuigis();
                game.world.moveLuigis();
                System.out.println("Task scheduled.");
                StdDraw.show();

                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime;


                int seconds = (int) (elapsedTime / 1000);
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.text(5, 9.5, "FIND WARIO");
                StdDraw.text(5, 9.2, "Timer: " + seconds + " seconds");

                System.out.println("Task scheduled.");
                StdDraw.show();
                StdDraw.pause(100);

                timer.schedule(new TimerTask() {
                    public void run() {
                        remind.run();
                    }

                }, 5000);

                ///WHEN WE FIND WARIO
                if (StdDraw.isMousePressed()) {
                    System.out.println("MOUSE PRESSED");
                    if (StdDraw.mouseX() > game.world.wario.xPosition - game.world.wario.radius && StdDraw.mouseX() < game.world.wario.xPosition + game.world.wario.radius) {
                        game.found = true;
                        StdAudio.play("wario.wav");

                    }
                }
            }

            ///CANCELING TIMER & DISPLAYING NEXT LEVEL
            timer.cancel();
            StdDraw.clear(new Color(253, 208, 28));
            game.world.drawWario();
            StdDraw.setPenColor(new Color(0,0,0));
            StdDraw.text(5.3, 7.8, "CONGRATS U FOUND WARIO !!! ");
            //StdDraw.text(5.3, 5.2, "W's IN THE CHAT");
            StdDraw.text(5.3, 6.2, "ON TO THE NEXT LEVEL! WAIT ONE MOMENT :)");
            StdDraw.show();
            StdDraw.pause(2000);
        }

       // StdDraw.clear();

        while(!StdDraw.isMousePressed()){
            game.levelClicked = false;
            StdDraw.setPenColor(new Color(10, 84, 168));
            StdDraw.filledSquare(5, 5, 5);
            StdDraw.setPenColor(Color.black);
            StdDraw.setFont(font1);
            LevelButton next = new LevelButton(5, 5, 3, 1, new Color(252,128,155));
            next.drawLevelButton();
            StdDraw.show();
            if (StdDraw.mouseY() > next.yPos - next.halfheight && StdDraw.mouseY() < next.yPos + next.halfheight &&
                    StdDraw.mouseX() > next.xPos - next.halfwidth && StdDraw.mouseX() < next.xPos + next.halfwidth) {
                next.setColor(new Color(167,255,149));
                next.drawLevelButton();;
                StdDraw.show();
                StdDraw.pause(20);
            }
        }

        Project game2 = new Project();


        //NEW TIMER 2

        timer2 = new Timer();
        RemindTask remind2 = new RemindTask(timer2);
        long startTime2 = System.currentTimeMillis();


        while(StdDraw.isMousePressed()) {
            while (!game2.yoshiFound) {
                StdDraw.clear(new Color(20, 16, 50));
                StdDraw.setFont(font2);
                StdDraw.setPenColor(new Color(228, 241, 45));
                StdDraw.text(8.5, 9.7, "Gamer tag: "+ guess);
                StdDraw.setFont(font1);
                game2.world.drawYoshi();
                game2.world.moveYoshi();
                game2.world.drawMarios();
                game2.world.moveMarios();
                System.out.println("Task scheduled.");
                StdDraw.show();

                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime2;


                int seconds = (int) (elapsedTime / 1000);
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.text(5, 9.5, "FIND YOSHI");
                StdDraw.text(5, 9.2, "Timer: " + seconds + " seconds");

                System.out.println("Task scheduled.");
                StdDraw.show();
                StdDraw.pause(100);


                timer2.schedule(new TimerTask() {
                    public void run() {
                        remind2.run();
                    }

                }, 5000);

                if (StdDraw.isMousePressed()) {
                    System.out.println("MOUSE PRESSED");
                    if (StdDraw.mouseX() > game.world.yoshi.xPosition - game.world.yoshi.radius && StdDraw.mouseX() < game.world.yoshi.xPosition + game.world.yoshi.radius) {
                        game2.yoshiFound = true;
                        StdAudio.play("yoshi.wav");

                    }
                }
            }

            timer2.cancel();
            StdDraw.clear(new Color(119, 255, 123, 255));
            game.world.drawYoshi();
            StdDraw.setPenColor(new Color(0,0,0));
            StdDraw.text(5.3, 7.8, "Congrats You Found Yoshi !!! ");
            StdDraw.text(5.3, 6.2, "ON TO THE NEXT LEVEL !");
            StdDraw.show();
            StdDraw.pause(2000);
        }


        while(!StdDraw.isMousePressed()){
            game.levelClicked = false;
            StdDraw.setPenColor(new Color(9, 45, 86));
            StdDraw.filledSquare(5, 5, 5);
            StdDraw.setPenColor(Color.black);
            StdDraw.setFont(font1);
            LevelButton next = new LevelButton(5, 5, 3, 1, new Color(252,128,155));
            next.drawLevelButton();
            StdDraw.show();
            if (StdDraw.mouseY() > next.yPos - next.halfheight && StdDraw.mouseY() < next.yPos + next.halfheight &&
                    StdDraw.mouseX() > next.xPos - next.halfwidth && StdDraw.mouseX() < next.xPos + next.halfwidth) {
                next.setColor(new Color(167,255,149));
                next.drawLevelButton();;
                StdDraw.show();
                StdDraw.pause(20);
            }
        }


        Project game3 = new Project();

        //NEW TIMER 3

        timer3 = new Timer();
        RemindTask remind3= new RemindTask(timer3);
        long startTime3 = System.currentTimeMillis();


        while(StdDraw.isMousePressed()) {
            while (!game3.mushroomFound) {
                StdDraw.clear(new Color(20, 16, 50));
                StdDraw.setFont(font2);
                StdDraw.setPenColor(new Color(228, 241, 45));
                StdDraw.text(8.5, 9.7, "Gamer tag: "+ guess);
                StdDraw.setFont(font1);
                game3.world.drawMushroom();
                game3.world.moveMushroom();
                game3.world.drawLuigis();
                game3.world.moveLuigis();
                game3.world.drawMarios();
                game3.world.moveMarios();
                System.out.println("Task scheduled.");
                StdDraw.show();

                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime3;


                int seconds = (int) (elapsedTime / 1000);
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.text(5, 9.5, "FIND THE MUSHROOM");
                StdDraw.text(5, 9.2, "Timer: " + seconds + " seconds");

                System.out.println("Task scheduled.");
                StdDraw.show();
                StdDraw.pause(100);


                timer3.schedule(new TimerTask() {
                    public void run() {
                        remind3.run();
                    }

                }, 10000);

                if (StdDraw.isMousePressed()) {
                    System.out.println("MOUSE PRESSED");
                    if (StdDraw.mouseX() > game.world.mushroom.xPosition - game.world.mushroom.radius && StdDraw.mouseX() < game.world.mushroom.xPosition + game.world.mushroom.radius) {
                        game3.mushroomFound = true;
                        StdAudio.play("mushroom.wav");


                    }
                }
            }

            timer3.cancel();
            StdDraw.clear(new Color(228, 241, 45, 255));
            game.world.drawMushroom();
            StdDraw.setPenColor(new Color(0,0,0));
            StdDraw.text(5.3, 7.8, "Congrats You Found Mushroom !!! ");
            StdDraw.text(5.3, 6.2, guess + " U WON THE GAME !!");
            StdDraw.show();
            StdAudio.play("Win.wav");
        }

    }
}
