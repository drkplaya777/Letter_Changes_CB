/*
 *  For this challenge you will be manipulating characters in a string based off their positions in the alphabet.
 */
class Function{
	
	String LetterChanges(String str){
		String alphabet = "abcdefghijklmnopqrstuvwxyz"; //Alphabet to check against
		String vowels = "aeiou"; //Vowels to check against
		char[] charVowels = vowels.toCharArray(); //covert string of vowels to characters
		char[] charAlphabet = alphabet.toCharArray(); //Covert string of alphabet to characters
		char[] letters = str.toCharArray(); //Convert the pass in string to characters
		
		StringBuilder sb = new StringBuilder(); //Create stringbuilder to store new string
		for(int i=0; i<letters.length; i++){
			boolean addedToFirstSb = false;
			for(int j=0; j<charAlphabet.length; j++){
				if(letters[i] == charAlphabet[j]){ //Means character from charArray matches the alphabet character.
					if((j+1) == charAlphabet.length){//This would mean it's on the last item and you want to keep the array in bounds
						sb.append(charAlphabet[0]); //Append the first item
						addedToFirstSb = true;
					}else{
						sb.append(charAlphabet[j+1]); //Add the next letter that would follow the char in the alphabet e.g. c->d
						addedToFirstSb = true;
						break;
					}
					
				}
			}
			if(!addedToFirstSb){ //If the value doesn't have any matches, then add it to the stringbuilder
				sb.append(letters[i]);

			}
		}
		String newWord =  sb.toString(); //Store string builder in string
		char[] modifiedString =  newWord.toCharArray(); //Convert string to charArray
		StringBuilder finalString = new StringBuilder(); //Create new stringbuilder to hold new string

				
		for(int i=0; i<modifiedString.length; i++){
			int j=0;
			boolean added = false; //reset the added state back to false when moving to new character to check
			while(j < charVowels.length){
				if(modifiedString[i] == charVowels[j]){ //If the character is a vowel, make it uppercase
					char upper = Character.toUpperCase(modifiedString[i]);
					finalString.append(upper); //Add variable to string builder
					added = true; //Set added state to true
					break; //Break out of loop as no need to check every value once match is found
				}
				j++;
			}
			if(!added){ //if you didn't find any matches, then add value to new string builder
				finalString.append(modifiedString[i]);
			}
		}
		return finalString.toString(); //Return the Stringbuilder value
	}
}
public class Application {

	public static void main(String[] args) {
		Function f = new Function();
		System.out.println(f.LetterChanges("hello*3"));
	}

}
