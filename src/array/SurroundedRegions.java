package array;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

 */
public class SurroundedRegions {
	 public void solve(char[][] board) {
		    int m = board.length;
		    if(board==null||m==0)
		    return;
		    int n = board[0].length;
		    Queue<Integer> queue = new LinkedList<Integer>();
		    for(int i=0;i<m;i++){
		        if(board[i][0]=='O')
		        queue.offer(i*n);
		        if(board[i][n-1]=='O')
		        queue.offer(i*n+n-1);
		        
		    }
		    for(int i=0;i<n;i++){
		        if(board[0][i]=='O')
		        queue.offer(i);
		        if(board[m-1][i]=='O')
		        queue.offer((m-1)*n+i);
		        
		    }
		    spread(queue,board);
		    for(int i=0;i<m;i++){
		        for(int j=0;j<n;j++){
		            if(board[i][j]=='L')
		            board[i][j] = 'O';
		            else
		            board[i][j] = 'X';
		        }
		    }
	    }
	    public void spread(Queue<Integer> queue,char[][] board){
	        
	        while(!queue.isEmpty()){
	            int cur = queue.poll();
	            int m = cur/board[0].length;
	            int n = cur%board[0].length;
	            board[m][n] = 'L';
	            if(m-1>=0&&board[m-1][n]=='O')
	            queue.offer(cur-board[0].length);
	            if(m+1<board.length&&board[m+1][n]=='O')
	            queue.offer(cur+board[0].length);
	            if(n-1>=0&&board[m][n-1]=='O')
	            queue.offer(cur-1);
	            if(n+1<board[0].length&&board[m][n+1]=='O')
	            queue.offer(cur+1);
	        }
	    }
}
