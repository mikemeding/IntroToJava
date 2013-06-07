

/**
 *
 * @author mike
 */
public class Shape {
    private String color;

    public Shape(String color) {
	this.color = color;
    }
    public String getColor(){
	return this.color;
    }
    public double area(){
	return 0.0;
    }
    @Override
    public String toString(){
	return "Generic Shape";
    }    
}
