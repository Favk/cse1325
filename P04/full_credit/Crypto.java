import java.util.Scanner;

public class Crypto {
	public static void main(String[] args) {

		char c;
		String text, randKey;
		Scanner in = new Scanner(System.in);

		if(args.length > 0){
			args[2] = randKey;
		}
		
		while(c != 'q'){
			System.out.print("(e)ncrypt, (d)ecrypt, or (q)uit? ");
			c = in.next().charAt(0);

			switch (c) {
				case 'e':
					System.out.println("Enter text to encrypt");
					text = in.next(); in.nextLine();
					text = Substitution(text);
					System.out.println(text);
					break;

				case 'd':
					System.out.println("Enter text to decrypt");
					text = in.next(); in.nextLine();
					text = Substitution(text);
					System.out.println(text);
					break;

				case 'q':
					break;
			}
		}
	}
}