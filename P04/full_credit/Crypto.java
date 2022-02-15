import java.util.Scanner;
import java.util.Random;

public class Crypto {

	public static String generateKey(){
		char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] randomKey = new char[26]; 

		int numOfAlphabets = 0;
		while(numOfAlphabets < 26){
			
			int swapIndex = (int) (26 * Math.random());

			if(letters[swapIndex] == ' ') continue;
			randomKey[numOfAlphabets] = letters[swapIndex];
			letters[swapIndex] = ' ';
			numOfAlphabets++;
		}
		return new String(randomKey);
	}

	public static void main(String[] args) {
		Cypher cypher = null;
		String key = "";

		if(args.length == 0){
			key = generateKey();
			System.out.println("Key = " + key);
		}
		else {
			switch (args[0]) {
				case "rot13":
					cypher = new Rot13();
					break;

				default:
					key = args[0];
					break;
			}
		}

		if(cypher == null){
			try{
				cypher = new Substitution(key);
			}
			catch(IllegalArgumentException error) {
				System.err.print(error.getMessage());
				System.exit(0);
			}
		}

		String text;
		Scanner in = new Scanner(System.in);

		boolean guesses;

		while(true){
			guesses = false;

			System.out.print("(e)ncrypt, (d)ecrypt, or (q)uit? ");
			char c = in.next().charAt(0);
			in.nextLine();
			switch (c) {
				case 'e':
					System.out.println("Enter text to encrypt");
					System.out.println(cypher.encrypt(in.nextLine()));
					break;

				case 'd':
					System.out.println("Enter text to decrypt");
					System.out.println(cypher.decrypt(in.nextLine()));
					break;

				case 'q':
					System.exit(0);
					break;

				default:
					guesses = true;
					System.err.println("Invalid option");
					break;
			}
		}
	}
}