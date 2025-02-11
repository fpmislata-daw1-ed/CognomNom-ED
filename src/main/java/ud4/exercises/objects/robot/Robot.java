package ud4.exercises.objects.robot;

public class Robot {
    private double x;
    private double y;
    private double speed;

    public Robot(){
        this(0,0,1);
    }
    public Robot(double x, double y){
        this(x,y,1);
    }
    public Robot(double x, double y, double speed){
        this.x = x;
        this.y = y;
        this.speed = Math.max(0, Math.min(10, speed));
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getSpeed(){
        return this.speed;
    }

    public void accelerate(){
        this.speed = Math.min(10, this.speed + 0.5);
    }

    public void decelerate(){
        this.speed = Math.max(0, this.speed - 0.5);
    }

    public void up(){
        this.y += this.speed;
    }
}
