package binarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraverse {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
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
                    result.add(cur.val);
                    stack.push(cur);
                    cur = cur.left;
                }
            }
            else{
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return result;
    }
}
