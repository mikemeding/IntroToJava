

/**
 *
 * @author mike
 */
public class Circle extends Shape {

    private double radius;

    public Circle(String color, double radius) {
	super(color);
	this.radius = radius;
    }

    @Override
    public double area() {
	// pi*r^2 = A
	return (Math.PI * Math.pow(this.radius, 2));
    }

    @Override
    public String toString() {
	return this.getColor() + " circle with radius of " + this.radius + " and area of " + area();
    }
}
