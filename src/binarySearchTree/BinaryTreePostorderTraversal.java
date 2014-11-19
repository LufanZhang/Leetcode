package binarySearchTree;

import java.util.ArrayList;

/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {
	 public ArrayList<Integer> postorderTraversal(TreeNode root) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if(root==null)
	        return result;
	        ArrayList<Integer> left = postorderTraversal(root.left);
	        ArrayList<Integer> right = postorderTraversal(root.right);
	        result.addAll(left);
	        result.addAll(right);
	        result.add(root.val);
	        return result;
	    }
}
