import java.util.Arrays;

public class Substitution implements Cypher{
	
	protected char[] encryptKey = new char[26];
	protected char[] decryptKey = new char[26];


	public Substitution(String key){
		if(key.length() != 26) 
			throw new IllegalArgumentException("Array out of bounds");

		key = key.toUpperCase();
		char[] text = key.toCharArray();
		Arrays.sort(text);

		if(!("ABCDEFGHIJKLMNOPQRSTUVWXYZ").equals(new String(text)))
			throw new IllegalArgumentException("Must contain all letters of the alphabet");

		encryptKey = key.toCharArray();

		decryptKey = encrypt(new String(encryptKey)).toCharArray();
	}

	public String encrypt(String unencrypted){
		char[] word = unencrypted.toCharArray();

		for(int i = 0; i < word.length; i++){
			if(Character.isLetter(word[i])){
				word[i] = encryptKey[word[i] - 'A'];
			}
		}
		return new String(word);
	}

	public String decrypt(String encrypted){
		char[] word = encrypted.toCharArray();

		for(int i = 0; i < 26; i++){
			if(Character.isLetter(word[i])){
				word[i] = decryptKey[word[i] - 'A'];
			}
		}
		return new String(word);

	}
}