package array;
/*
 *  Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class WordSearch {
	 public boolean exist(char[][] board, String word) {
	        if(board==null||board.length==0)
	        return false;
	        if(word==null||word.length()==0)
	        return true;
	        int m = board.length;
	        int n = board[0].length;
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(board[i][j]==word.charAt(0)){
	                boolean res = find(board,word,i,j,0);
	                if(res)
	                return true;
	                }
	            }
	        }
	        return false;
	    }
	    public boolean find(char[][] board,String word,int i,int j,int start){
	        if(start>=word.length())
	        return true;
	        if(i<0||i>=board.length||j<0||j>=board[0].length)
	        return false;
	        if(board[i][j]==word.charAt(start)){
	            board[i][j] = '#';
	            boolean res = find(board,word,i-1,j,start+1)||
	                    find(board,word,i+1,j,start+1)||
	                    find(board,word,i,j-1,start+1)||
	                    find(board,word,i,j+1,start+1);
	            board[i][j] = word.charAt(start);
	            return res;
	        }
	        return false;
	    }
}
