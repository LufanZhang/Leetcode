package binarySearchTree;
/*
 *  Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return 6. 
 */
public class BinaryTreeMaximumPathSum {
	 private class ResultType {
	        int singlePath, maxPath;
	        ResultType(int singlePath, int maxPath) {
	            this.singlePath = singlePath;
	            this.maxPath = maxPath;
	        }
	    }

	    private ResultType helper(TreeNode root) {
	        if (root == null) {
	            return new ResultType(0, Integer.MIN_VALUE);
	        }
	        // Divide
	        ResultType left = helper(root.left);
	        ResultType right = helper(root.right);

	        // Conquer
	        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
	        singlePath = Math.max(singlePath, 0);

	        int maxPath = Math.max(left.maxPath, right.maxPath);
	        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

	        return new ResultType(singlePath, maxPath);
	    }

	    public int maxPathSum(TreeNode root) {
	        ResultType result = helper(root);
	        return result.maxPath;
	    }
/*
 * this method is  clearer and code seems simpler, but actually, it needs more time, because the previous method just
 * need traverse the whole tree once to maintain two arguments - singlePath and sumPath, this method calculate those two
 * arguments separately which means it needs traverse the tree twice. To sum up, the method above is better.
 * public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null){
            return Integer.MIN_VALUE;
        }
        int leftSingle = maxSingleSum(root.left);
        int rightSingle = maxSingleSum(root.right);
        int maxWithRoot = root.val + leftSingle + rightSingle;
        
        int leftPath  = maxPathSum(root.left);
        int rightPath = maxPathSum(root.right);
        return Math.max(maxWithRoot, Math.max(leftPath, rightPath));
    }
    //this function return the single max path of a tree
    public int maxSingleSum(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftMax = maxSingleSum(root.left);
        int rightMax = maxSingleSum(root.right);
        return Math.max(0, root.val + Math.max(leftMax, rightMax));
    }
 */

}
