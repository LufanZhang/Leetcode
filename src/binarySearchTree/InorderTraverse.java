package binarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraverse {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                while(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
            }
            else{
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
