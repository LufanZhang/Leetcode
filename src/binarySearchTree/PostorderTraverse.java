package binarySearchTree;

import java.util.ArrayList;
import java.util.Stack;
/*
 * postorder is the most difficult traverse compare with preorder and inorder, because we need an extra pre
 * treeNode pointer to tell us if the right child has been traversed.
 * per Pointer always represent the last treeNode we traverse, if a treeNode's right child is pre Pointer
 * that means this treenode's right sub tree has been traversed completely, because its right child must be the
 * last traversed treeNode in its subtree, 
 * so if a node's right child equals to pre, we can consider that the both the left subtree and right subree 
 * have been visited. then we can pop this node and add it to result arrayList.
 */
public class PostorderTraverse {
	  public ArrayList<Integer> postorderTraversal(TreeNode root) {
	        // write your code here
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if(root == null){
	            return result;
	        }
	        TreeNode cur = root;
	        TreeNode pre = root;
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        while(cur != null || !stack.isEmpty()){
	            if(cur != null){
	                while(cur != null){
	                    stack.push(cur);
	                    cur = cur.left;
	                }
	            }
	            else{
	                cur = stack.peek();
	                if(cur.right == null || cur.right == pre){
	                    stack.pop();
	                    result.add(cur.val);
	                    pre = cur;
	                    cur = null;
	                }
	                else{
	                    cur = cur.right;
	                }
	            }
	        }
	        return result;
	    }
}
