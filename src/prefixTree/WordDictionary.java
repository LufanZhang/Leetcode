package prefixTree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//public class WordDictionary {
//	 public class TrieNode {
//	        HashMap<Character,TrieNode> map = new HashMap<Character,TrieNode>();
//	        boolean fullword = false;
//	        // public TrieNode(){
//	        //     fullword = false;
//	        //     map = new HashMap<Character,TrieNode>();
//	        // }
//	    }
//	    TrieNode root;
//	    public WordDictionary(){
//	        root = new TrieNode();
//	    }
//	    // Adds a word into the data structure.
//	    public void addWord(String word) {
//	    	//System.out.println("add   " + word);
//	        TrieNode pre = root;
//	        if(word == null || word.length() == 0){
//	            return;
//	        }
//	        int length = word.length();
//	        int i = 0;
//	        while(i < length){
//	            char cur = word.charAt(i);
//	            if(!pre.map.containsKey(cur)){
//	                break;
//	            }
//	            else{
//	                pre = pre.map.get(cur);
//	                i++;
//	            }
//	        }
//	        //System.out.println("i = "+i);
//	        while(i < length){
//	            char cur = word.charAt(i);
//	            TrieNode newNode = new TrieNode();
//	            pre.map.put(cur,newNode);
//	            pre = newNode;
//	            if(i == length - 1){
//	                pre.fullword = true;
//	            }
//	            i++;
//	        }
//	        //System.out.println("add end............");
//	    }
//
//	    // Returns if the word is in the data structure. A word could
//	    // contain the dot character '.' to represent any one letter.
//	    public boolean search(String word) {
//	        if(word == null || word.length() == 0){
//	            return true;
//	        }
//	        return searchFrom(word,root);
//	    }
//	    public boolean searchFrom(String word,TrieNode root){
//	    	//System.out.println("searchFrom  " + word);
//	        if(word == null || word.length() == 0){
//	        	if(root.fullword){
//	        		return true;
//	        	}
//	            return false;
//	        }
//	        char cur = word.charAt(0);
//	        if(cur != '.'){
//	            if(root.map.isEmpty() || !root.map.containsKey(cur)){
//	                 return false;
//	            }
//	            TrieNode next = root.map.get(cur);
//	            return searchFrom(word.substring(1),next);
//	        }
//	        else{
//	            if(root.map.isEmpty()){
//	                return false;
//	            }
//	            Iterator iter = root.map.entrySet().iterator(); 
//	            while (iter.hasNext()) { 
//	                Map.Entry entry = (Map.Entry) iter.next(); 
//	                TrieNode next = (TrieNode)entry.getValue(); 
//	                if(searchFrom(word.substring(1),next)){
//	                    return true;
//	                }
//	            } 
//	        }
//	        return false;
//	    }
////	static class TrieNode {
////	    final TrieNode[] children = new TrieNode[26];
////	    boolean end = false;
////
////	    public void addWord(String word, int idx) {
////	        if (idx == word.length()) {
////	            end = true;
////	            return;
////	        }
////	        char c = word.charAt(idx);
////	        if(children[c - 'a'] == null) {
////	            children[c - 'a'] = new TrieNode();
////	        }
////	        children[c - 'a'].addWord(word, idx + 1);
////	    }
////
////	    public boolean search(String word, int idx) {
////	        if (idx == word.length()) {
////	            return end;
////	        }
////
////	        char c = word.charAt(idx);
////	        if (c != '.') {
////	            return children[c - 'a'] != null && children[c - 'a'].search(word, idx + 1);
////	        } else {
////	            for (int i = 0; i < 26; i++) {
////	                if (children[i] != null && children[i].search(word, idx + 1)) {
////	                    return true;
////	                }
////	            }
////	            return false;
////	        }
////	    }
////	}
////
////	final TrieNode root = new TrieNode();
////
////	// Adds a word into the data structure.
////	public void addWord(String word) {
////	    root.addWord(word, 0);
////	}
////
////	// Returns if the word is in the data structure. A word could
////	// contain the dot character '.' to represent any one letter.
////	public boolean search(String word) {
////	    return root.search(word, 0);
////	}
public class WordDictionary {
	   class TrieNode{
	       TrieNode[] children;
	       boolean fullword;
	       public TrieNode(){
	           fullword = false;
	           children = new TrieNode[26];
	       }
	   }
	   TrieNode root;
	    // Adds a word into the data structure.
	    public WordDictionary(){
	        root = new TrieNode();
	    }
	    public void addWord(String word) {
	        if(word == null || word.length() == 0){
	            return;
	        }
	        int length = word.length();
	        TrieNode cur = root;
	        for(int i=0;i<length;i++){
	            char curChar = word.charAt(i);
	            int pos = curChar - 'a';
	            if(cur != null){
	            	System.out.println("cur != null");
	            }
	            System.out.println("pos = "+pos);
	            System.out.println("cur.children = "+cur.children);
	            if(cur.children[pos] == null){
	                TrieNode curNode = new TrieNode();
	                cur.children[pos] = curNode;
	                cur = curNode;
	            }
	            else{
	                cur = cur.children[pos];
	            }
	        }
	        cur.fullword = true;
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	       return searchFrom(word,root);
	    }
	    public boolean searchFrom(String word,TrieNode node){
	        if(word == null || word.length() == 0){
	            return node.fullword == true;
	        }
	        char first = word.charAt(0);
	        if(first == '.'){
	            for(int i=0;i<26;i++){
	                if(node.children[i] != null && searchFrom(word.substring(1),node.children[i])){
	                    return true;
	                }
	            }
	        }
	        else{
	            int pos = first - 'a';
	            if(node.children[pos] != null){
	                return searchFrom(word.substring(1),node.children[pos]);
	            }
	        }
	        return false;
	    }
	public static void main(String[] args) {
	    WordDictionary wordDictionary = new WordDictionary();
	    wordDictionary.addWord("a");
	    wordDictionary.addWord("and");
	    wordDictionary.addWord("an");
	    wordDictionary.addWord("add");
	    System.out.println(wordDictionary.search("a"));
	    System.out.println(wordDictionary.search(".at"));
	    wordDictionary.addWord("bat");
	    System.out.println(wordDictionary.search(".at"));
	    System.out.println(wordDictionary.search("an."));
	    System.out.println(wordDictionary.search("a.d."));
	    System.out.println(wordDictionary.search("b."));
	    System.out.println(wordDictionary.search("a.d."));
	    System.out.println(wordDictionary.search("."));
//	    wordDictionary.addWord(".at");
//	    System.out.println(wordDictionary.search("pad"));
//	    System.out.println(wordDictionary.search("bad"));
//	    System.out.println(wordDictionary.search(".ad"));
//	    System.out.println(wordDictionary.search("b.."));
	}
}
