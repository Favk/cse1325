import java.util.Scanner;

public class Crypto {
	public static void main(String[] args) {

		char c;
		String text;
		Scanner in = new Scanner(System.in);

		System.out.print("(e)ncrypt, (d)ecrypt, or (q)uit? ");
		c = in.next().charAt(0);
		System.out.println("Enter text to encrypt");
		text = in.next(); in.nextLine();
	}
}