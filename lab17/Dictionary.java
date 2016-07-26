import java.util.HashMap;

public class Dictionary {

	/*
	 * Since a trie node can have so many children, the children it has are
	 * stored in a map.
	 */
	private HashMap<Character, TrieNode> myStartingLetters;

	public Dictionary() {
		myStartingLetters = new HashMap<>();
	}

	/**
	 * Associates the input word with the input definition in the dictionary.
	 */
	public void addDefinition(String word, String definition) {
		// YOUR CODE HERE
		myStartingLetters.put(word.charAt(0),new TrieNode());
		TrieNode p = myStartingLetters.get(word.charAt(0));
		for (int i = 1; i < word.length(); i++){
			p.myNextLetters.put(word.charAt(i), new TrieNode());
			if (i == word.length()-1){
				p.myDefinition = definition;
			}
			p = p.myNextLetters.get(word.charAt(i));
		}
	}

	/**
	 * Return the definition associated with this word in the Dictionary. Return
	 * null if there is no definition for the word.
	 */
	public String lookupDefinition(String word) {
		// YOUR CODE HERE
		TrieNode p=myStartingLetters.get(word.charAt(0));
		for(int i = 1; i < word.length();i++) {
			p=p.myNextLetters.get(word.charAt(i));
		}
		return p.myDefinition;
	}

	private class TrieNode {
		private HashMap<Character, TrieNode> myNextLetters;

		// Leave this null if this TrieNode is not the end of a complete word.
		private String myDefinition;

		private TrieNode() {
			myNextLetters = new HashMap<>();
		}

		// FEEL FREE TO ADD ADDITIONAL METHODS.
	}
}