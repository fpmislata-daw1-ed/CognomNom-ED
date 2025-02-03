package ud4.exercises.objects.robot;

public class Robot {
    private double x;
    private double y;
    private double speed;

    public Robot(){
        this.speed = 1;
    }

    public Robot(double x, double y){
        this.x = x;
        this.y = y;
        this.speed = 1;
    }

    public Robot(double x, double y, double speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
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
        this.speed = Math.min(this.speed + 0.5, 10);
    }

    public void decelerate(){
        this.speed = Math.max(this.speed - 0.5, 0);
    }

    public void up(){
        this.y += this.speed;
    }
}
