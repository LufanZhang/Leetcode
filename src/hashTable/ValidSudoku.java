package hashTable;

import java.util.HashSet;

/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated. 
 */
public class ValidSudoku {
	   public boolean isValidSudoku(char[][] board) {
	        if(board.length!=9||board[0].length!=9)
	        	return false;    
	        HashSet<Character> set =new HashSet<Character>();
	        for(int i=0;i<9;i++){
	        	set.clear();
	        	for(int m=0;m<9;m++){
	        		if(board[i][m]!='.'){
	        			if(set.contains(board[i][m]))
	        				return false;
	        			else
	        				set.add(board[i][m]);
	        		}
	        	}
	        	set.clear();
	        	for(int n=0;n<9;n++){
	        		if(board[n][i]!='.'){
	        			if(set.contains(board[n][i]))
	        				return false;
	        			else
	        				set.add(board[n][i]);
	        		}
	        	}
	        }
	        for(int i=0;i<9;i=i+3){
	        	for(int j=0;j<9;j=j+3){
	        		set.clear();
	        		for(int m=0;m<3;m++){
	        			for(int n=0;n<3;n++){
	        				if(board[i+m][j+n]!='.'){
	        					if(set.contains(board[i+m][j+n]))
	        						return false;
	        					else
	        						set.add(board[i+m][j+n]);
	        				}
	        					
	        			}
	        		}
	        	}
	        }
	        return true;
	    }
}
