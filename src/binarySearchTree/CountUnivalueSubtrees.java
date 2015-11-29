package binarySearchTree;
/*
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.


 */
public class CountUnivalueSubtrees {
	int res = 0;
	public int countUnivalSubtrees(TreeNode root){
		helper(root);
		return res;
	}
	public boolean helper(TreeNode root){
		if(root == null){
			return true;
		}
		if(root.left != null && root.right != null){
			res++;
			return true;
		}
		if(root.left != null || root.right != null){
			return false;
		}
		if(helper(root.left) && helper(root.right) && root.val == root.left.val && root.val == root.right.val){
			res++;
			return true;
		}
		return false;
	}
}
