package binarySearchTree;
/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree. 
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	   public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if(preorder==null||inorder==null)
	        return null;
	        if(preorder.length!=inorder.length)
	        return null;
	        int length = preorder.length;
	        return buildHelper(preorder,0,length-1,inorder,0,length-1);
	    }
	    public TreeNode buildHelper(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
	        if(preStart>preEnd||inStart>inEnd)
	        return null;
	        TreeNode root = new TreeNode(preorder[preStart]);
	        int index = 0;
	        for(int i=inStart;i<=inEnd;i++){
	            if(inorder[i]==preorder[preStart])
	            index = i;
	        }
	        TreeNode left = buildHelper(preorder,preStart+1,preStart+index-inStart,inorder,inStart,index-1);
	        TreeNode right = buildHelper(preorder,preStart+index-inStart+1,preEnd,inorder,index+1,inEnd);
	        root.left = left;
	        root.right = right;
	        return root;
	    }
}
