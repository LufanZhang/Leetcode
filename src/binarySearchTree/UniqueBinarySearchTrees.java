package binarySearchTree;

import java.util.HashMap;

/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */
public class UniqueBinarySearchTrees {
//	  public int numTrees(int n) {
//	        if(n<=0)
//	        return 0;
//	        if(n==1)
//	        return 1;
//	        return numTreesHelper(1,n);
//	    }
//	    public static int numTreesHelper(int i,int j){
//	        if(i>=j)
//	        return 1;
//	        int result = 0;
//	        for(int m=i;m<=j;m++){
//	            int left = numTreesHelper(i,m-1);
//	            int right = numTreesHelper(m+1,j);
//	            result+=left*right;
//	        }
//	        return result;
//	    }
/*
 * the method above may cause TLE,because tree(1,2,3) and tree(4,5,6) return the same value, but the method above calculate
 * the value twice, in order to avoid repeated calculation, use DP to optimize time complexity.
 */
	 public int numTrees(int n) {
         if(n<=1)
	        	return 1;
	        int num = 0;
	       HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	       return helper(map,n);
	       
    }
	 public int helper(HashMap<Integer,Integer> map,int n){
	        if(n <= 1){
	            return 1;
	        }
	        int result = 0;
	        for(int i=1;i<=n;i++){
	            int leftIndex = i-1;
	            int left = 0;
	            if(map.containsKey(leftIndex)){
	                left = map.get(leftIndex);
	            }
	            else{
	                left = helper(map,leftIndex);
	                map.put(leftIndex,left);
	            }
	            int rightIndex = n-i;
	            int right = 0;
	            if(map.containsKey(rightIndex)){
	                right = map.get(rightIndex);
	            }
	            else{
	                right = helper(map,rightIndex);
	                map.put(rightIndex,right);
	            }
	            result += left*right;
	        }
	        return result;
	    }
	   
}
