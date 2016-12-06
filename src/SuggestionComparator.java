/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Comparator;

/**
 * This class helps us to compare the TrieNode in the PriorityQueue. This 
 * helps us print the TrieNode in order.
 * @authors Vladimir Fomene and Kwame Odame
 */
public class SuggestionComparator implements Comparator<Word> {
    
    @Override
    public int compare(Word firstWord, Word secondWord){
        //1 when the firstWord is less in frequency
        if(firstWord.getFrequency() < secondWord.getFrequency()){
            return 1;
        }
        
        //-1 when the firstWord is more in frequency
        if(firstWord.getFrequency() > secondWord.getFrequency()){
            return -1;
        }
        
        //0 when they have thesame frequency
        return 0;
    }
    
}
