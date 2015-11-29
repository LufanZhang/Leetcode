package array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public static  List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(k > 9 || n < 1){
            return res;
        }
        helper(res,list,k,n,1,9);
        return res;
    }
    public static void helper(List<List<Integer>> res,List<Integer> list,int k,int target,int start,int end){
    	//System.out.println(list);
    	//System.out.println("start = "+start+"  "+"target = "+target+"  "+"k = "+k);
    	if(target == 0 && k == 0){
           // list.add(start);
            //System.out.println(list);
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(start > end || start > target || k <= 0){
            return;
        }
        for(int i=start;i<=end;i++){
            list.add(i);
            helper(res,list,k-1,target-i,i+1,end);
            list.remove(list.size()-1);
        }
    }
    public static void main(String args[]){
    	int k = 2;
    	int n = 6;
    	List<List<Integer>> res = combinationSum3(k,n);
    	System.out.println(res);
    }
}
