package backTracking;

import java.util.ArrayList;

/*
 * Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII {
	public int totalNQueens(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       if(n<=0)
       return 0;
       ArrayList<Integer> list = new ArrayList<Integer>();
       queenHelper(n,list,result);
       return result.size();
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
}
