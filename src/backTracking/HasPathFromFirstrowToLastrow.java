package backTracking;

public class HasPathFromFirstrowToLastrow {
	public static boolean hasPath(int[][] board){
		if(board == null || board.length <= 1){
			return true;
		}
		int m = board.length;
		int n = board[0].length;
		for(int i=0;i<n;i++){
			if(findPath(board,0,i)){
				return true;
			}
		}
		return false;
	}
	public static boolean findPath(int[][] board,int i,int j){
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 0){
			return false;
		}
		System.out.println("i="+i+"  j="+j);
		if(i == board.length-1){
			return true;
		}
		board[i][j] = 0;
		return findPath(board,i,j-1) || findPath(board,i,j+1) || findPath(board,i+1,j);
	}
	public static void main(String args[]){
		int[][] board = {{0,1,1,1,1,0},{0,1,0,0,0,0},{0,1,1,1,0,0},{0,0,0,1,0,0},{0,0,0,0,1,0}};
		boolean res = hasPath(board);
		System.out.println(res);
		char a = 'a';
		String s = "JDFIniosIKFMi";
		s = s.toLowerCase();
		System.out.println(s);
	}
}
