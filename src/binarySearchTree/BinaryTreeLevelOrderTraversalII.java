package binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

 */
public class BinaryTreeLevelOrderTraversalII {
	 public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        if(root==null)
	        return result;
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        int currentNum = 1;
	        int nextNum = 0;
	        ArrayList<Integer> array = new ArrayList<Integer>();
	        while(!queue.isEmpty()){
	            TreeNode currentNode = queue.poll();
	            array.add(currentNode.val);
	            currentNum--;
	            if(currentNode.left!=null){
	                queue.offer(currentNode.left);
	                nextNum++;
	            }
	            if(currentNode.right!=null){
	                queue.offer(currentNode.right);
	                nextNum++;
	            }
	            if(currentNum==0){
	                result.add(0,(ArrayList<Integer>)array.clone());
	                array.clear();
	                currentNum = nextNum;
	                nextNum = 0;
	            }
	        }
	        return result;
	    }
}
