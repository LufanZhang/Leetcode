package array;

import java.util.List;

/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null)
        return 0;
        int[] result = new int[triangle.size()];
        for(List<Integer> list:triangle){
            for(int i=list.size()-1;i>=0;i--){
                if(i==0)
                result[i] = list.get(i)+result[i];
                else if(i==list.size()-1)
                result[i] = list.get(i)+result[i-1];
                else
                result[i] = list.get(i)+Math.min(result[i],result[i-1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<result.length;i++){
            if(min>result[i])
            min = result[i];
        }
        return min;
    }
}
