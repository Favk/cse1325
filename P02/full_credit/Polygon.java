import java.util.Scanner;

public class Polygon {
	private int sides = 0;
	private double perimeter = 0.0;

	public void addSide(double length) {
		perimeter+=length;
		sides++;
	}

	public int getSides(){
		return sides;
	}

	public double getPerimeter(){
		return perimeter;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int s = 1;
		double length = 0.0;
		Polygon polygon = new Polygon();

		while(s != 0){
			System.out.print("Side length (0 when done): ");
			length = in.nextDouble(); in.nextLine();

			if(length <= 0) {
				s = 0;
			}
			polygon.addSide(length);
		}
		System.out.println("Perimeter of a " + (polygon.sides - 1) + "-sided polygon is " + polygon.perimeter);
	}
}