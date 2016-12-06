import java.util.ArrayList;

public class Trie{

  /* root node of our trie */
  private TrieNode root;
  
  /* stores word suggestions */
  private ArrayList<Word> wordSuggestions;

  //Constructor
  public Trie(){
    root = new TrieNode();
    wordSuggestions = new ArrayList<>();
  }
  
  /**
   * Return an Arraylist with list of word suggestions.
   * @return the list of word suggestion.
   */
  public ArrayList getListOfWordSuggestions(){
      return wordSuggestions;
  }
  
  /**
   * This method takes in words and frequencies, then create a trieNode 
   * and stores it in a trie.
   * @param word
   * @param frequency 
   */
  public void insert(String word, int frequency){
    word = word.toLowerCase();
    TrieNode tmpNode = root;
    //Iterate through the word
    for(int i = 0; i < word.length(); i++){
      char c = word.charAt(i);
      int index = Character.toLowerCase(c) - 'a';

      //Insert every character at its right location after creating its node.
      if(tmpNode.children[index] == null){
        TrieNode node = new TrieNode(c);
        tmpNode.children[index] = node;
        tmpNode = node;
      }else{
        //If the position corresponding to this character is point to the a particular node, follow that node.
        tmpNode = tmpNode.children[index];
      }
      
    }
    
    //Set the frequency in the lastNode
    tmpNode.frequency = frequency;
    
    
    //We just entered a word.
    tmpNode.isWord = true; 
      
  }

  /**
   * Uses the prefix to find the node corresponding to the end of that prefix
   * @param prefix
   * @return Trie node with the prefix's last character
   */
  public TrieNode getLastPrefixCharacterNode(String prefix){
    TrieNode tmpNode = root;
    for(int i = 0; i < prefix.length(); i++){
      char c = prefix.charAt(i);
      int index = Character.toLowerCase(c) - 'a';
      if(tmpNode.children[index]!= null){
        tmpNode = tmpNode.children[index];
      }else{
        return null;
      }
    }

    //If the prefix is an empty String
    if(tmpNode == root) return null;

    return tmpNode;
  }
  
  
  /**
   * Check whether a particular word is in the trie by using the word's 
   * character to traverse the trie.
   * @param word
   * @return true if the word is in the trie and false otherwise.
   */
  public boolean contains(String word){
      TrieNode tmpNode = root;

      //Iterate through the word
      for(int i = 0; i < word.length(); i++){
        char c = word.charAt(i);
        int index = Character.toLowerCase(c) - 'a';

        //Is the current character in the array
        if(tmpNode.children[index] != null){
          tmpNode = tmpNode.children[index];
        }else{
          //character not in children array so word is definitely not in trie.
          return false;
        }
      }

      //return true if node contains the word we are searching.
       return true;
  }


  //Get the word suggestions from prefixNode in a recursive fashion
  //Create a priority queue to store the suggestions nodes.
  public void getWordSuggestions(TrieNode lastPrefixCharacterNode, String prefix){
    
      
    //sanity check for empty string
    if(prefix.isEmpty()) System.out.println("You did not entered a proper word.");
    
    //Could not find the node with the last character of your prefix.
    if(lastPrefixCharacterNode == null) System.out.println("Sorry, I could not find your word.");
    
    String tmpString = prefix;
    if(lastPrefixCharacterNode.isWord){
        wordSuggestions.add(new Word(lastPrefixCharacterNode.frequency, prefix));
       
    }
    
    for (TrieNode children : lastPrefixCharacterNode.children) {
        
        if (children != null) {
            tmpString = prefix;
            //System.out.println(String.valueOf(children.c));
            tmpString += String.valueOf(children.c);
            getWordSuggestions(children, tmpString);
        }
    }
  }

}
