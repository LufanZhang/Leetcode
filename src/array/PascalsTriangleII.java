package array;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space? 
 */
public class PascalsTriangleII {
	 public List<Integer> getRow(int rowIndex) {
	        List<Integer> res = new ArrayList<Integer>();
	        if(rowIndex < 0){
	            return res;
	        }
	        res.add(1);
	        for(int i=1;i<=rowIndex;i++){
	            res.add(1);
	            for(int j=i-1;j>0;j--){
	                res.set(j,res.get(j)+res.get(j-1));
	            }
	        }
	        return res;
	    }
}
