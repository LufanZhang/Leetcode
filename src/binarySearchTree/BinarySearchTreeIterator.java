package binarySearchTree;

import java.util.Stack;

public class BinarySearchTreeIterator {
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	TreeNode cur;
    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
       cur = root;
       stack = new Stack<TreeNode>();
    }

    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }

    public int next() {
       while(cur != null){
           stack.push(cur);
           cur = cur.left;
       }
       int res = stack.peek().val;
       cur = stack.pop().right;
       return res;
    }
}
