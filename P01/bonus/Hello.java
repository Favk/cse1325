import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("What is your name? ");
		String s = in.nextLine();
		System.out.print("Hello " +s);
		System.out.println("!");
	}
}