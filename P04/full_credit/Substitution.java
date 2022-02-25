import java.util.Arrays;

public class Substitution implements Cypher{
	
	protected char[] encryptKey = new char[26];
	protected char[] decryptKey = new char[26];

	public Substitution(String key){
		if(key.length() != 26) 
			throw new IllegalArgumentException("Array out of bounds\n");

		key = key.toUpperCase();
		char[] test = key.toCharArray();
		Arrays.sort(test);

		if(!("ABCDEFGHIJKLMNOPQRSTUVWXYZ").equals(new String(test)))
			throw new IllegalArgumentException("Must contain all letters of the alphabet\n");

		encryptKey = key.toCharArray();

		char letter = 'A';
		for(char a : encryptKey){
			decryptKey[a - 'A'] = letter++;
		}
	}

	@Override
	public String encrypt(String unencrypted){
		char[] word = unencrypted.toUpperCase().toCharArray();

		for(int i = 0; i < word.length; i++){
			if(Character.isLetter(word[i])){
				word[i] = encryptKey[word[i] - 'A'];
			}
		}
		return new String(word);
	}

	@Override
	public String decrypt(String encrypted){
		char[] word = encrypted.toUpperCase().toCharArray();

		for(int i = 0; i < word.length; i++){
			if(Character.isLetter(word[i])){
				word[i] = decryptKey[word[i] - 'A'];
			}
		}
		return new String(word);
	}
}