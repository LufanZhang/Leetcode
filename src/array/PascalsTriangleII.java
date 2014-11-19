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
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if(rowIndex<0)
	        return result;
	        result.add(1);
	        if(rowIndex==0)
	        return result;
	        for(int j=0;j<rowIndex;j++){
	            int length = result.size();
	            result.add(0,1);
	            for(int i=1;i<=length;i++){
	                if(i==length)
	                result.set(i,1);
	                else{
	                    result.set(i,result.get(i)+result.get(i+1));
	                }
	            }
	        }
	        return result;
	    }
}
