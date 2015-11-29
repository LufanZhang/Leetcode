package binarySearchTree;

public class LongestConsecutiveNumbers {
	int res = 0;
	public int longestNumbers(TreeNode root){
		if(root == null){
			return 0;
		}
		longestHelper(root);
		return res;
	}
	public int longestHelper(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftPath = longestHelper(root.left);
		int rightPath = longestHelper(root.right);
		int max = 1;
		if(root.left != null && root.left.val == root.val + 1){
			max = Math.max(leftPath+1,max);
		}
		if(root.right != null && root.right.val == root.val + 1){
			max = Math.max(rightPath+1,max);
		}
		if(res < max){
			res = max;
		}
		return max;
	}
}
