public class Substitution implements Cypher{
	
	protected char[] encryptKey = new char[26];
	protected char[] decryptKey = new char[26];


	public Substitution(String key){
		encryptKey = key.toCharArray();
		if(encryptkey.length() != 26) 
			throw IllegalArgumentException("Array out of bounds" + encryptKey.length());
	}

	public String encrypt(String unencrypted){

	}

	public String decrypt(String encrypted){
		
	}
}