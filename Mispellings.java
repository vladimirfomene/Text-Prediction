import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.IOException;

public class Mispellings {
    
  private static int wordCounter = 0;
  
  //Prints Mispelled words
    public void printMispelled() {
    System.out.println("The following words have been mispelled: ");
    //Open stream to read from the file to be spellcheck
    BufferedReader reader = getBufferedReader("mispellings.txt");
    try{
        String value;
        while((value = reader.readLine()) != null){
            StringTokenizer strToken = new StringTokenizer(value);
            while (strToken.hasMoreTokens()) {
              String tmpValue = strToken.nextToken();
              tmpValue = tmpValue.replaceAll("[()!,.' ]", "");
              if(!dictionaryMap.containsKey(tmpValue.hashCode())){
                  System.out.println(tmpValue.toLowerCase());
                  wordCounter++;
              }

            }
        }
    }catch(IOException exception){
        System.out.println(exception.getMessage());
    }
    
    //Summary of number of mispelled words
    System.out.println("This file has a total of " + wordCounter + " mispelled words.");
    }
  
  public static void main(String[] args) {
    Dictionary dictionary = new Dictionary();
    HashMap<Integer,String> dictionaryMap = new HashMap<Integer,String>();
    
    dictionaryMap = dictionary.readIn("dictionary.txt");
    
    //Word Collection from dictionary
    Collection wordCollection = dictionaryMap.values();
    
    //Initialize an iterator
    Iterator iter = wordCollection.iterator();
    
//    //iterate through the word and print each word
//    while(iter.hasNext()){
//      System.out.println(iter.next());
//    }
    
    printMispelled();

  }
  
  private static BufferedReader getBufferedReader(String filename) {
    BufferedReader reader = null;
    try{
      reader = new BufferedReader(new FileReader(filename)); 
    }
    catch (IOException exception) {
      System.out.println(exception.getMessage());
    }
    return reader;
  }
  
  } //End of Mispellings class

