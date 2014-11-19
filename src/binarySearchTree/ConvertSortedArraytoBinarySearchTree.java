package binarySearchTree;
/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree {
	 private TreeNode buildTree(int[] num, int start, int end) {
	        if (start > end) {
	            return null;
	        }

	        TreeNode node = new TreeNode(num[(start + end) / 2]);
	        node.left = buildTree(num, start, (start + end) / 2 - 1);
	        node.right = buildTree(num, (start + end) / 2 + 1, end);
	        return node;
	    }

	    public TreeNode sortedArrayToBST(int[] num) {
	        if (num == null) {
	            return null;
	        }
	        return buildTree(num, 0, num.length - 1);
	    }
}
