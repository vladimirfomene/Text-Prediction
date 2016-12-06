
public class TrieNode {

    //word character stored in this node.
    char c;

    //Tells you whether you have reached the end of word
    boolean isWord;

    //Stores the frequency of the word.
    int frequency;

    //Array with references to children nodes
    TrieNode[] children;

    //Default Constructor
    public TrieNode() {
        children = new TrieNode[26];
    }

    public TrieNode(char letter) {
        c = letter;
        children = new TrieNode[26];

    }

}
