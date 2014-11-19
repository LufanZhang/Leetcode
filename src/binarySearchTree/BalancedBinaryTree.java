package binarySearchTree;
/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
 */
public class BalancedBinaryTree {
	   public boolean isBalanced(TreeNode root) {
	        if(root==null)
	        return true;
	        int differ = Math.abs(maxDepth(root.left)-maxDepth(root.right));
	        if(isBalanced(root.left)&&isBalanced(root.right)&&differ<=1)
	        return true;
	        return false;
	    }
	    public int maxDepth(TreeNode root){
	        if(root==null)
	        return 0;
	        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
	    }
}
