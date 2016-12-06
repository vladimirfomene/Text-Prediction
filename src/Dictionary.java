

/* authors: Kwame Odame & Vladimir Fomene */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.String;

/* This class reads from the file which contains the frequency of each word,
 * and populates the trie. The class also reads from the dictionary file containing
 * a dictionary of words, and compares the words already read into the file,
 * and populates the trie with the words that do not exist in the try.
 */
public class Dictionary {
  
  // Instance Variables
  private Trie dictionaryTrie = new Trie();
  
  //stores the word line in an array
  private String[] row = new String[2];
  
  
  // Public method that returns the dictionaryTrie
  public Trie getDictionaryTrie() {
    return this.dictionaryTrie;
  }
  
  /* This method reads from the frequency file and populates the Trie with the words and their frequencies */
  public void readFromFrequencyFile(String filename) {
    Scanner myscanner = null;
    BufferedReader reader = returnReader(filename);
     
     int counter = 0;
     String str;
     try{
       
       while ((str = reader.readLine()) != null){
         
         myscanner = new Scanner(str);
         
         //Skip the line number column in the file
         myscanner.next();
         
         //Read the word from the second column
         row[counter++] = myscanner.next();
         
         //Reads the second file
         row[counter++] = myscanner.next();
         
         if(isWord(row[0])){
           dictionaryTrie.insert(row[0], Integer.parseInt(row[1]));
         }
         
         
         
         
         counter = 0;
       }
       
     }catch(IOException ex){
       System.out.println(ex.getMessage());
     }
     
  }
  
  
  private boolean isWord(String word){
    for(int i = 0; i < word.length(); i++){
      if(((Character.toLowerCase(word.charAt(i)) - 'a') >= 26) || ((Character.toLowerCase(word.charAt(i)) - 'a') < 0)){
        return false;
      }
    }
    return true;
  }
   
  
   /*This method returns a reader to a file */
   public BufferedReader returnReader(String filename) {
     BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader (filename));
   }
    catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    
    return reader;
  }
 
   /* This method reads from the dictionary file */
   public void readFromDictionaryFile (BufferedReader reader) {
    String s;
    
     
     try {
      while ((s = reader.readLine()) != null) {
         if (!dictionaryTrie.contains(s)) {
           dictionaryTrie.insert(s, Integer.parseInt("0"));
        }
      }
     }
     catch(IOException e) {
       System.out.println(e.getMessage());
     }
     
     
   }

}
  

    // End of class
 