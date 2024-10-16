public class Mario {
    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity;
    private double radius;

    public Mario(double xPosition, double yPosition, double xVelocity, double yVelocity, double radius) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.radius = radius;

    }
    public void move(){
        if (xPosition + radius >= 8) xVelocity = -xVelocity;
        if (xPosition - radius <= 0) xVelocity = -xVelocity;
        if (yPosition + radius >= 8) yVelocity = -yVelocity;
        if (yPosition - radius <= 0) yVelocity = -yVelocity;

        xPosition += xVelocity;
        yPosition += yVelocity;

    }

    public void draw(){
        StdDraw.picture(xPosition, yPosition, "mario.png", 1.0, 1.5);

    }
}
