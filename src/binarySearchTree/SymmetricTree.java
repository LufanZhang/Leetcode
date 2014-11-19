package binarySearchTree;
/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3

 */
public class SymmetricTree {
	public class Solution {
	    public boolean isSymmetric(TreeNode root) {
	        if(root==null)
	        return true;
	        return isMirror(root.left,root.right);
	    }
	    public boolean isMirror(TreeNode t1,TreeNode t2){
	        if(t1==null&&t2==null)
	        return true;
	        if(t1==null||t2==null)
	        return false;
	        if(t1.val!=t2.val)
	        return false;
	        return isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
	    }
	}
}
