package Lesson_6_Shape_Hierarchy;

/**
 *
 * @author mike
 */
public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle(String color, double width, double length) {
	super(color);
	this.width = width;
	this.length = length;
    }

    @Override
    public double area() {
	return (this.length * this.width);
    }

    @Override
    public String toString() {
	return this.getColor() + " rectangle with length of " + this.length + " and width of " + this.width + " and area of " + area();
    }
}
