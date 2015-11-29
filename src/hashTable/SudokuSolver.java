package hashTable;

import java.util.ArrayList;

/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red. 
 */
/*
 * 第一种是更接近于backtrack的一般做法
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        ArrayList<Integer> posI = new ArrayList<Integer>();
        ArrayList<Integer> posJ = new ArrayList<Integer>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char cur = board[i][j];
                if(cur != '.'){
                    continue;
                }
                else{
                    posI.add(i);
                    posJ.add(j);
                }
            }
        }
        solveHelper(board,posI,posJ,0,0);
    }
    public boolean solveHelper(char[][] board,ArrayList<Integer> posI,ArrayList<Integer> posJ,int a,int b){
        if(a == posI.size() && b == posJ.size()){
            return true;
        }
        else{
            int i = posI.get(a);
            int j = posJ.get(b);
            for(char c='1';c<='9';c++){
                if(check(board,i,j,c)){
                    board[i][j] = c;
                    if(solveHelper(board,posI,posJ,a+1,b+1)){
                        return true;
                    }
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
    public boolean check(char[][] board,int posI,int posJ,char c){
        for(int i=0;i<9;i++){
            char cur = board[posI][i];
            if(cur == '.'){
                continue;
            }
            else{
                if(cur == c){
                    return false;
                }
            }
        }
        for(int i=0;i<9;i++){
            char cur = board[i][posJ];
            if(cur == '.'){
                continue;
            }
            else{
                if(cur == c){
                    return false;
                }
            }
        }
        int row = posI / 3;
        int column = posJ / 3;
        for(int i=row*3;i<row*3+3;i++){
            for(int j=column*3;j<column*3+3;j++){
                char cur = board[i][j];
                if(cur == '.'){
                    continue;
                }
                else{
                    if(cur == c){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
//public class SudokuSolver {
//	  public void solveSudoku(char[][] board){
//	        solve(board);
//	    }
//
//	    public boolean solve(char[][] board){
//	        for(int i=0;i<9;i++){
//	            for(int j=0;j<9;j++){
//	                if(board[i][j] != '.'){
//	                    continue;
//	                }
//	                for(int k = 1; k <= 9; k++){
//	                    board[i][j] = (char) (k + '0');
//	                    if (isValid(board, i, j) && solve(board)){
//	                        return true;
//	                    }
//	                    board[i][j] = '.';
//	                }
//	                return false;
//	            }
//	        }
//	        return true;
//	    }
//	    public boolean isValid(char[][] board, int a, int b){
//	        Set<Character> contained = new HashSet<Character>();
//	        for(int j=0;j<9;j++){
//	            if(contained.contains(board[a][j])) return false;
//	            if(board[a][j]>'0' && board[a][j]<='9')
//	                contained.add(board[a][j]);
//	        }
//	            
//	        
//	    
//	        contained = new HashSet<Character>();
//	        for(int j=0;j<9;j++){
//	            if (contained.contains(board[j][b])) {
//	                return false;
//	            }
//	            if (board[j][b]>'0' && board[j][b]<='9') {
//	                contained.add(board[j][b]);
//	            }
//	        }
//	        
//	    
//	        contained = new HashSet<Character>();
//	        for (int m = 0; m < 3; m++) {
//	            for (int n = 0; n < 3; n++){
//	                int x = a / 3 * 3 + m, y = b / 3 * 3 + n;
//	                if (contained.contains(board[x][y])) {
//	                    return false;
//	                }
//	                if (board[x][y] > '0' && board[x][y] <= '9') {
//	                        contained.add(board[x][y]);
//	                }
//	            } 
//	        }
//	    
//	        return true;
//	    }
//}
