package hashTable;

import java.util.Stack;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area. 
 */
public class MaximalRectangle {
	   public int maximalRectangle(char[][] matrix) {
	    	int m = matrix.length;
	    	if(matrix==null||m==0)
	    	return 0;
	    	int n = matrix[0].length;
	    	int[] num = new int[n];
	    	int max = 0;
	    	for(int i=0;i<m;i++){
	    	    for(int j=0;j<n;j++){
	    	        if(matrix[i][j]=='0')
	    	        num[j] = 0;
	    	        else{
	    	            if(i==0)
	    	            num[j] = 1;
	    	            else{
	    	            num[j]+= 1;
	    	            }
	    	        }
	    	    }
	    	    if(rowHistogram(num)>max)
	    	    max = rowHistogram(num);
	    	}
	    	return max;
	    }
	    public int rowHistogram(int[] number){
	        int max = 0;
	        int[] num = new int[number.length+1];
	        num[number.length] = 0;
	        for(int i=0;i<number.length;i++){
	            num[i] = number[i];
	        }
	        Stack<Integer> height = new Stack<Integer>();
	        Stack<Integer> pos = new Stack<Integer>();
	        height.push(-1);
	        pos.push(-1);
	        int i = 0;
	        while(i<num.length){
	            if(num[i]>=height.peek()){
	                height.push(num[i]);
	                pos.push(i);
	                i++;
	            }
	            else{
	                int high = height.pop();
	                pos.pop();
	                int width = i-pos.peek()-1;
	                int area = high*width;
	                if(area>max)
	                max = area;
	            }
	        }
	        return max;
	    }
}
