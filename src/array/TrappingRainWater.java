package array;
/*
 *  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 */
public class TrappingRainWater {
	 public int trap(int[] A) {
	        int length = A.length;
	        if(A==null||length<=2)
	        return 0;
	        int result = 0;
	        int[] left = new int[A.length];
	        int[] right = new int[A.length];
	        int max = 0;
	        for(int i=0;i<A.length;i++){
	            if(A[i]>max)
	            max = A[i];
	            left[i] = max;
	        }
	         max = 0;
	        for(int i=A.length-1;i>=0;i--){
	            if(A[i]>max)
	            max = A[i];
	            right[i] = max;
	        }
	        for(int i=0;i<length;i++){
	            if(A[i]<Math.min(left[i],right[i])){
	                result+=Math.min(left[i],right[i])-A[i];
	            }
	        }
	        return result;
	    }
	    
}
