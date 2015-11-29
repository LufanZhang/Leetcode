package binarySearchTree;

public class LowestCommonAncestorofaBinaryTree {
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root == null){
	            return null;
	        }
	       if(root.equals(p) || root.equals(q)){
	           return root;
	       }
	       TreeNode isLeft = lowestCommonAncestor(root.left,p,q);
	       TreeNode isRight = lowestCommonAncestor(root.right,p,q);
	       if(isLeft != null && isRight != null){
	           return root;
	       }
	       if(isLeft != null){
	           return isLeft;
	       }
	       else if(isRight != null){
	           return isRight;
	       }
	       else{
	           return null;
	       }
	    }
}
