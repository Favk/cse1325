import java.util.Scanner;

public class Quint {
	public static void main(String[] args) {

		WordList words = new WordList();
		Puzzle puzzle = new Puzzle(words.getWord());
		int guesses = 0;

		Scanner in = new Scanner(System.in);
		String guess, answer;

		System.out.print("\n\n\n");
		System.out.println("==========");
		System.out.println("Q U I N T");
		System.out.println("==========");

		System.out.println("Guess a 5 letter word");
		System.out.print("guess\t");

		while(!puzzle.isSolved()){
			guess = in.next();
			guess = guess.toUpperCase();

			answer = puzzle.compareGuess(guess);
			guesses++;
			System.out.print(answer + "\t");
		}

		System.out.println("\n\nGuessed in " + guesses + " tries.");
	}
}