/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This class helps you store a word value and the frequency.
 * @author Kwame Odame and Vladimir Fomene
 */
public class Word {
    
    /* Store the string value */
    private String value;
    
    /* Stores the frequency of the word */
    private int frequency;
    
    //constructor
    public Word(int freq, String str){
        value = str;
        frequency = freq;
        
    }
    
    /* getter for frequency */
    public int getFrequency(){
        return frequency;
    }
    
    /* getter for String value */
    public String getValue(){
        return value;
    }
}
