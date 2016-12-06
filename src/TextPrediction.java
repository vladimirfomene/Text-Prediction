import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Iterator;

/* This class tests the methods in the Dictionary class */

public class TextPrediction {
  public static void main (String[] args) {
  
  Dictionary testDictionary = new Dictionary();
  
  // Test the readFromFrequencyFile method

  testDictionary.readFromFrequencyFile("frequencyfile.txt");
  
  //Read words from dictionary and place them in trie.
  testDictionary.readFromDictionaryFile(testDictionary.returnReader("dictionary.txt"));
  
   // Check if some words are in the dictionary
   if (testDictionary.getDictionaryTrie().contains("accelerator")) {
    System.out.println("Test Passed. The word is in the dictionary");
   }else{
    System.out.println("Test Failed. The word is not in the dictionary.");
   }
   
    //Instructions for the text prediction
    System.out.println("Welcome to our Text Prediction Application:");
    System.out.println("This application is a simulation for an autocomplete "
            + "feature of the Ashesi Website search functionality.");
    System.out.println("You have to enter a prefix and application will give you words based on that prefix.");
    System.out.println("Your prefix should be a three-letter-word:");
    System.out.println("You can now enter your prefix: ");
    Scanner keyboard = new Scanner(System.in);
    String prefix = keyboard.next();
    
    //Get the word suggestions from the dictionary trie and stores it in an ArrayList
    testDictionary.getDictionaryTrie().getWordSuggestions(testDictionary.getDictionaryTrie().getLastPrefixCharacterNode(prefix),prefix);
    
    ArrayList<Word> wordSuggestions = testDictionary.getDictionaryTrie().getListOfWordSuggestions();
    
    //Sort the list of word suggestions
    Collections.sort(wordSuggestions, new SuggestionComparator());
    
    //Initializes the iterator for wordSuggestions
    Iterator queueIter = wordSuggestions.iterator();
    
    //Announcing the list of word suggestion
    System.out.println("\n\nHere is your list of word suggestions.....");
    
    //Iterates through the list of word suggestion and prints each word at a time.
    while(queueIter.hasNext()){
        Word tmpWord = (Word) queueIter.next();
        System.out.println(tmpWord.getValue()+ "  "+ tmpWord.getFrequency());
    }
  }
  
  
} 