
/**
 *
 * @author mike
 */
public class Square extends Shape {

    private double length;

    public Square(String color, double length) {
	super(color);
	this.length = length;
    }
    @Override
    public double area(){
	return Math.pow(length, 2); // Squared. Duh.
    }    
    @Override
    public String toString(){
	return this.getColor() + " square with side length of " + this.length + " and area of " + area();
    }
}
