package backTracking;

import java.util.ArrayList;

/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

 */
public class NQueens {
	 public ArrayList<String[]> solveNQueens(int n) {
	        ArrayList<String[]> result = new ArrayList<String[]>();
	        if(n<=0)
	        return result;
	        String[] array = new String[n];
	        ArrayList<ArrayList<Integer>> resultHelper = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        queenHelper(n,list,resultHelper);
	        for(ArrayList<Integer> cur:resultHelper){
	            transform(cur,array);
	            result.add(array.clone());
	        }
	        return result;
		}
		public void queenHelper(int n,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> result){
		    if(list.size()==n){
		        result.add(new ArrayList<Integer>(list));
		        return;
		    }
		    for(int i=0;i<n;i++){
		        if(check(list,i)){
		            list.add(i);
		            queenHelper(n,list,result);
		            list.remove(list.size()-1);
		        }
		    }
		}
		boolean check(ArrayList<Integer> list,int n){
		    if(list.size()==0)
		    return true;
		    for(int i=0;i<list.size();i++){
		        int cur = list.get(i);
		        if(cur==n)
		        return false;
		        if(Math.abs(list.size()-i)==Math.abs(n-cur))
		        return false;
		    }
		    return true;
		}
		public void transform(ArrayList<Integer> list,String[] kind){
		    for(int i=0;i<list.size();i++){
		        String res = "";
		        int j = list.get(i);
		        for(int m=0;m<list.size();m++){
		            if(m==j)
		            res = res+"Q";
		            else
		            res = res+".";
		        }
		        kind[i] = res;
		    }
		}
}
