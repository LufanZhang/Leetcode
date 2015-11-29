package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class wordSearchII {
	TrieNode root;
    public class TrieNode{
        TrieNode[] links;
        boolean fullword;
        TrieNode(boolean fullword){
            links = new TrieNode[26];
            this.fullword = fullword;
        }
    }
    public void insertWord(TrieNode root,String word){
            int offset = 'a';
            int l = word.length();
            TrieNode curNode = root;
            for(int i=0;i<l;i++){
                char cur = word.charAt(i);
                if(curNode.links[cur-offset] == null){
                    curNode.links[cur-offset] = new TrieNode(false);
                }
                curNode = curNode.links[cur-offset];
            }
            curNode.fullword = true;
        }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        if(board == null || board.length == 0 || words == null || words.length == 0){
            return res;
        }
        int m = board.length;
        int n = board[0].length;
        root = new TrieNode(false);
        //insert the dictionary's words into trie
        for(int i=0;i<words.length;i++){
            insertWord(root,words[i]);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                StringBuilder sb = new StringBuilder();
                helper(board,root,res,sb,i,j,set);
            }
        }
        return res;
    }
    public void helper(char[][] board,TrieNode root,List<String> res,StringBuilder sb,int i,int j,HashSet<String> set){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*'){
            return;
        }
        char cur = board[i][j];
        if(root.links[cur-'a'] == null){
            return;
        }
        sb.append(cur);
        board[i][j] = '*';
        if(root.links[cur-'a'].fullword == true){
            String temp = sb.toString();
            if(!set.contains(temp)){
            	res.add(temp);
            	set.add(temp);
            }
        }
        helper(board,root.links[cur-'a'],res,sb,i-1,j,set);
        helper(board,root.links[cur-'a'],res,sb,i+1,j,set);
        helper(board,root.links[cur-'a'],res,sb,i,j-1,set);
        helper(board,root.links[cur-'a'],res,sb,i,j+1,set);
        board[i][j] = cur;
        sb.deleteCharAt(sb.length()-1);;
    }
    public static void main(String args[]){
    	char[][] board = {{'a','a'}};
    	String[] words = {"aa"};
    	wordSearchII cur = new wordSearchII();
    	System.out.println(cur.findWords(board,words));
    }
}
