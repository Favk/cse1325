public class Word{
	
		private char[] letters =  new char[5];

		private boolean validateCharacter(char c){
			if(!(c >= 'A' || c <= 'Z' || c == '.' || c == ' ')){
				System.err.println("Invalid entry: Not a letter: " + c);
				return false;
			}
			else
				return true;
		}

		public Word(String word){
			letters = word.toCharArray();

			if(letters.length > 5)
				System.err.println("Invalid entry: Not 5 letters: " + word);

			for(int i = 0; i < letters.length; i++){
				validateCharacter(letters[i]);
			}
		}

		public char charAt(int position){
			if((position < 0) || (position > 4))
				System.err.println("Invalid entry: Out of bounds for array");

			return letters[position];
		}

		public void setCharAt(char c, int position){
			if((position < 0) || (position > 4))
				System.err.println("Invalid entry: Out of bounds for array");
			
			if(validateCharacter(c) == true)
				letters[position] = c;
		} 

		public String toString(){
			String array = new String(letters);
			return array;
		}
}