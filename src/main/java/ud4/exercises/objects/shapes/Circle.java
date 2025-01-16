package ud4.exercises.objects.shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(){
        this(0, 0, 1);
    }

    public Circle(double radius){
        this(0, 0, radius);
    }

    public Circle(double x, double y){
        this(x, y, 1);
    }

    public Circle(double x, double y, double radius){
        super(x, y);
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean contains(double x, double y){
        double d = Math.sqrt(
                Math.pow(this.x - x, 2)
                + Math.pow(this.y - y, 2)
        );
        return d <= radius;
    }
}
