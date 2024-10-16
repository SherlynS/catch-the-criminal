import java.util.Timer;

public class World {
    public Wario wario;
    public Luigi[] luigis;
    public int sumLuigi;
    public Timer reminder;
    public Mario [] marios;
    public Yoshi yoshi;
    public Mushroom mushroom;
    public int sumMario;


    public World(int SumLuigi, int SumMario){
        this.wario = new Wario(Math.random() * 10,Math.random() *8, Math.random() * 0.2,  Math.random() * 0.05, 1);
        this.yoshi = new Yoshi(Math.random() * 10,Math.random() *8, Math.random() * 0.2,  Math.random() * 0.05, 1);
        this.mushroom = new Mushroom(Math.random() * 10,Math.random() *8, Math.random() * 0.2,  Math.random() * 0.05, 1);
        this.sumLuigi = SumLuigi;
        this.sumMario = SumMario;
        this.reminder =  new Timer();
        luigis = new Luigi[sumLuigi];
        marios = new Mario[sumMario];
        for (int i = 0; i <luigis.length; i++) {
            luigis[i] = new Luigi(Math.random() * 10,Math.random() *8, Math.random() * 0.4,  Math.random() * 0.09, .001);
        }

        for (int i = 0; i <marios.length; i++) {
            marios[i] = new Mario(Math.random() * 10,Math.random() *8, Math.random() * 0.2,  Math.random() * 0.09, .001);
        }
    }

    public void drawLuigis(){
        for (int i = 0; i < luigis.length; i++){
            luigis[i].draw();
        }
    }

    public void moveLuigis(){
        for (int i = 0; i < luigis.length; i++){
            luigis[i].move();
        }
    }

    public void drawMarios(){
        for (int i = 0; i < marios.length; i++){
            marios[i].draw();
        }

    }

    public void moveMarios(){
        for (int i = 0; i < marios.length; i++){
            marios[i].move();
        }
    }
    public void drawWario(){
        wario.draw();
    }
    public void moveWario(){
        wario.move();
    }
    public void drawYoshi(){yoshi.draw();}
    public void moveYoshi(){yoshi.move();}
    public void drawMushroom(){mushroom.draw();}
    public void moveMushroom(){mushroom.move();}

}
