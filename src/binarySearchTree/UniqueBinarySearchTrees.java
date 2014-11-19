package binarySearchTree;
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
	  public int numTrees(int n) {
	        if(n<=0)
	        return 0;
	        if(n==1)
	        return 1;
	        return numTreesHelper(1,n);
	    }
	    public static int numTreesHelper(int i,int j){
	        if(i>=j)
	        return 1;
	        int result = 0;
	        for(int m=i;m<=j;m++){
	            int left = numTreesHelper(i,m-1);
	            int right = numTreesHelper(m+1,j);
	            result+=left*right;
	        }
	        return result;
	    }
}
