package binarySearchTree;

public class BinaryTreeUpsideDown {
	  public TreeNode upsideDownBinaryTree(TreeNode root) {
	        if(root == null || (root.left == null && root.right == null)){
	            return root;
	        }
	        TreeNode nextRoot = root.left;
	        TreeNode right = root.right;
	        TreeNode res = upsideDownBinaryTree(root.left);
	        root.left = null;
	        root.right = null;
	        nextRoot.left = right;
	        nextRoot.right = root;
	        return res;
	    }
	 //root.left = parent.right;
    //root.right = parent
    //solution 1---->like reverse linkedList,upsideDown from top to end, when a node's parent has updated,it's easy to update
    //this node with above relation
    // public TreeNode UpsideDownBinaryTree(TreeNode root) {
    //     TreeNode parent = null;
    //     TreeNode parentRight = null;
    //     while(root != null){
    //         TreeNode next = root.left;
    //         TreeNode temp = root.right;
    //         root.left = parentRight;
    //         root.right = parent;
    //         parent = root;
    //         parentRight = temp;
    //         root = next;
    //     }
    //     return parent;
    // }
    //solution 2: recursion
//    public TreeNode UpsideDownBinaryTree(TreeNode root){
//        return upsideDownHelper(root,null);
//    }
//    public TreeNode upsideDownHelper(TreeNode root,TreeNode parent){
//        if(root == null){
//            return parent;
//        }
//        TreeNode p = upsideDownHelper(root.left,root);
//        root.left = parent == null?parent:parent.right;
//        root.right = parent;
//        return p;
//    }
}
