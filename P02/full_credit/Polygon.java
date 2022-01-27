import java.util.Scanner;

public class Polygon {
	/*public static int addSides(int x) {
		int sum = 0;
		sum = sum + x;
		return sum;
	}*/
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int s = 0;
		int sides = 1;
		int sum = 0;
		double perimeter = 0.0;

		while(sides != 0){
			System.out.print("Side length (0 when done): ");
			sides = in.nextInt(); in.nextLine();
			s++;
			sum+=sides;
			perimeter = (double)sum;
		}
		System.out.println("Perimeter of a " + (s - 1) + "-sided polygon is " + perimeter);
	}
}