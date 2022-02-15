import java.util.Scanner;
import java.lang.Math;

public class Crypto {
	public static void main(String[] args) {

	String Key = " ";
	Cypher cypher;

	if(args.length == 0){
		Key = generateKey();
		System.out.println("Key = " + Key);
	}
	else {
		switch (args[0]) {
			case "rot13":
				cypher = new Rot13();
				break;

			default:
				Key = args[0];
				break;
		}
	}

	if(cypher == null){
		cypher = new Substitution(Key);
	}

	char c;
	String text;
	Scanner in = new Scanner(System.in);

	while(true){
		System.out.print("(e)ncrypt, (d)ecrypt, or (q)uit? ");
		c = in.next().charAt(0);

		switch (c) {
			case 'e':
				System.out.println("Enter text to encrypt");
				text = in.next(); in.nextLine();
				System.out.println(text);
				break;

			case 'd':
				System.out.println("Enter text to decrypt");
				text = in.next(); in.nextLine();
				System.out.println(text);
				break;

			case 'q':
				break;
		}
	}
}

public static String generateKey(){

	String charcatersOfTheAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	char[] letters = charcatersOfTheAlphabets .toLowerCase().toCharArray();

	char[] randKey = new char[26];

	int numOfAlphabets = 0;
	while(numOfAlphabets < 26) {
		int point = (int) (26 * Math.random());
		if(letters[point] == ' ') continue;

		randKey[point] = letters[point];
		letters[point] = ' ';
		point++;
	}

	return new String(randKey);
}
