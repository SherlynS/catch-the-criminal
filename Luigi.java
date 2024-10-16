
public class Luigi {
    public double xPosition;
    public double yPosition;
    public double xVelocity;
    public double yVelocity;
    public double radius;

    public Luigi(double xPosition, double yPosition, double xVelocity, double yVelocity, double radius) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.radius = radius;
       // Luigi = new Players[];

    }
    public void move(){
        xPosition += xVelocity;
        yPosition += yVelocity;

        if (xPosition + radius >= 8) xVelocity = -xVelocity;
        if (xPosition - radius <= 0) xVelocity = -xVelocity;
        if (yPosition + radius >= 8) yVelocity = -yVelocity;
        if (yPosition - radius <= 0) yVelocity = -yVelocity;


    }

    public void draw(){
        StdDraw.picture(xPosition, yPosition, "luigi.png", 1.5, 1.5);

    }



}
