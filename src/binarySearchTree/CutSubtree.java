package binarySearchTree;
/*
 * 一个Binary Tree，每个Node都有value，在树中切掉一个edge，变成两个树，找出哪里切导致两个数的Value总和差值最小
 */
public class CutSubtree {
	int min = Integer.MAX_VALUE;
	TreeNode res = null;
	public TreeNode cut(TreeNode root){
		if(root == null){
			return null;
		}
		TreeNode sumRoot = sum(root);
		int halfSum = sumRoot.val >> 1;
		dfsHelper(root,halfSum);
		return res;
	}
	public void dfsHelper(TreeNode root,int num){
		if(root == null){
			return;
		}
		if(Math.abs(root.val - num) < min){
			min = Math.abs(root.val - num);
			res = root;
		}
		dfsHelper(root.left,num);
		dfsHelper(root.right,num);
	}
	public TreeNode sum(TreeNode root){
		if(root == null){
			return null;
		}
		TreeNode left = sum(root.left);
		TreeNode right = sum(root.right);
		int sum = root.val;
		if(left != null){
			sum += left.val;
		}
		if(right != null){
			sum += right.val;
		}
		TreeNode newRoot = new TreeNode(sum);
		newRoot.left = left;
		newRoot.right = right;
		return newRoot;
	}
}
