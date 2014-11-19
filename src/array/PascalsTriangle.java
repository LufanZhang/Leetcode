package array;

import java.util.ArrayList;

/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */
public class PascalsTriangle {
	   public ArrayList<ArrayList<Integer>> generate(int numRows) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        if(numRows<=0)
	        return result;
	        list.add(1);
	        result.add(new ArrayList<Integer>(list));
	        if(numRows==1){
	        return result;
	        }
	        for(int j=1;j<numRows;j++){
	            int length = list.size();
	            list.add(0,1);
	            for(int i=1;i<=length;i++){
	                if(i==length)
	                list.set(i,1);
	                else{
	                    list.set(i,list.get(i)+list.get(i+1));
	                }
	            }
	            result.add(new ArrayList<Integer>(list));
	        }
	        return result;
	    }
}
