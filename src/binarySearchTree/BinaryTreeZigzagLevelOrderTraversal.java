package binarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

 */
public class BinaryTreeZigzagLevelOrderTraversal {
	 public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        if(root==null)
	        return result;
	        boolean normalOrder = true;  //from left to left
	        Stack<TreeNode> currentLevel = new Stack<TreeNode>(); //represent the non-empty stack
	        Stack<TreeNode> nextLevel = new Stack<TreeNode>();  //represent the empty stack which waiting future node
	        currentLevel.push(root);
	        while(!currentLevel.isEmpty()){
	            ArrayList<Integer> list = new ArrayList<Integer>();
	            if(normalOrder==true){
	                while(!currentLevel.isEmpty()){
	                    TreeNode cur = currentLevel.pop();
	                    list.add(cur.val);
	                    if(cur.left!=null){
	                        nextLevel.push(cur.left);
	                    }
	                    if(cur.right!=null){
	                        nextLevel.push(cur.right);
	                    }
	                }
	                normalOrder = false;
	            }
	            else{
	                 while(!currentLevel.isEmpty()){
	                    TreeNode cur = currentLevel.pop();
	                    list.add(cur.val);
	                    if(cur.right!=null){
	                        nextLevel.push(cur.right);
	                    }
	                    if(cur.left!=null){
	                        nextLevel.push(cur.left);
	                    }
	                }
	                normalOrder = true;
	            }
	            result.add(new ArrayList<Integer>(list));
	        //now,one level has been pop out complete and the currentLevel stack is empty
	        Stack<TreeNode> temp = nextLevel;
	        nextLevel = currentLevel;
	        currentLevel = temp;
	        }
	        return result;
	    }
}
