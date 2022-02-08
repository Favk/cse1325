public class Word{
	
		private char[] letters =  new char[5];

		public Word(String word){
			letters = word.toCharArray();
		}

		public char charAt(int position){
			return letters[position];
		}

		public void setCharAt(char c, int position){
			letters[position] = c;
		} 

		public String toString(){
			String array = new String(letters);
			return array;
		}
}