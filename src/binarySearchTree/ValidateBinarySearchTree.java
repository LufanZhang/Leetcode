package binarySearchTree;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isValidHelper(root,min,max);
    }
    public static boolean isValidHelper(TreeNode root, int min, int max){
        if(root==null)
        return true;
        if(root.val>=max||root.val<=min)
        return false;
        return isValidHelper(root.left,min,root.val)&&isValidHelper(root.right,root.val,max);
    }
    //another way to solve this problem
    /*
     * private int lastVal = Integer.MIN_VALUE;
    	public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (lastVal >= root.val) {
            return false;
        }
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
     */
}
