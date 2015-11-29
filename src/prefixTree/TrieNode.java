package prefixTree;

import java.util.HashMap;

public class TrieNode {
	char letter;
    HashMap<Character,TrieNode> children; 
    boolean fullword;

    // Initialize your data structure here.
    public TrieNode() {
        this.children = new HashMap<Character,TrieNode>();
        fullword = false;
    }
    public TrieNode(char c){
        this.letter = c;
        this.children = new HashMap<Character,TrieNode>();
        fullword = false;
    }
}
