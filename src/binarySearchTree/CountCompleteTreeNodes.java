package binarySearchTree;

public class CountCompleteTreeNodes {
	 public int countNodes(TreeNode root) {
	        if(root == null){
	            return 0;
	        }
	        int left = leftHight(root);
	        int right = rightHight(root);
	        if(left == right){
	            return (1 << left) - 1;
	        }
	        return 1 + countNodes(root.left) + countNodes(root.right);
	    }
	    public int leftHight(TreeNode root){
	        if(root == null){
	            return 0;
	        }
	        return 1 + leftHight(root.left);
	    }
	    public int rightHight(TreeNode root){
	        if(root == null){
	            return 0;
	        }
	        return 1 + rightHight(root.right);
	    }
}
