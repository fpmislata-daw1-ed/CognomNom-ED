package ud4.exercises.objects.shapes;

public abstract class Shape {
    protected double x;
    protected double y;

    protected Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void move(double x, double y){
        this.x += x;
        this.y += y;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract boolean contains(double x, double y);
}
